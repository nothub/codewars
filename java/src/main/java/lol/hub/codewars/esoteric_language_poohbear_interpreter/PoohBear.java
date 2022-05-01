package lol.hub.codewars.esoteric_language_poohbear_interpreter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Map.entry;

// TODO: UNFINISHED

/**
 * @see <a href="https://www.codewars.com/kata/59a9735a485a4d807f00008a">codewars.com</a>
 */
public class PoohBear {
    static final Map<String, Consumer<Context>> commands = Map.ofEntries(
        /* Add 1 to the current cell */
        entry("+", ctx -> ctx.memory().write(ctx.memory().read() + 1)),
        /* Subtract 1 from the current cell */
        entry("-", ctx -> ctx.memory().write(ctx.memory().read() - 1)),
        /* Move the cell pointer 1 space to the right */
        entry(">", ctx -> ctx.memory().right()),
        /* Move the cell pointer 1 space to the left */
        entry("<", ctx -> ctx.memory().left()),
        /* "Copy" the current cell */
        entry("c", ctx -> ctx.memory().copy()),
        /* Paste the "copied" cell into the current cell */
        entry("p", ctx -> ctx.memory().paste()),
        /* While the current cell is equal to 0, jump to the corresponding E */
        entry("W", PoohBear::jumpRight),
        /* While the current cell is equal to 1, jump to the corresponding W */
        entry("E", PoohBear::jumpLeft),
        /* Output the current cell's value as ascii */
        entry("P", ctx -> ctx.memory().appendBuffer(String.valueOf((char) ctx.memory().read()))),
        /* Output the current cell's value as an integer */
        entry("N", ctx -> ctx.memory().appendBuffer(String.valueOf(ctx.memory().read()))),
        /* Multiply the current cell by 2 */
        entry("T", ctx -> ctx.memory().write(ctx.memory().read() * 2)),
        /* Square the current cell */
        entry("Q", ctx -> ctx.memory().write(Math.pow(ctx.memory().read(), 2))),
        /* Square root the current cell's value */
        entry("U", ctx -> ctx.memory().write(Math.sqrt(ctx.memory().read()))),
        /* Add 2 to the current cell */
        entry("L", ctx -> ctx.memory().write(ctx.memory().read() + 2)),
        /* Subtract 2 from the current cell */
        entry("I", ctx -> ctx.memory().write(ctx.memory().read() - 2)),
        /* Divide the current cell by 2 */
        entry("V", ctx -> ctx.memory().write(ctx.memory().read() / 2)),
        /* Add the copied value to the current cell's value */
        entry("A", ctx -> ctx.memory().write(ctx.memory().read() + ctx.memory().clipboard())),
        /* Subtract the copied value from the current cell's value */
        entry("B", ctx -> ctx.memory().write(ctx.memory().read() - ctx.memory().clipboard())),
        /* Multiply the current cell's value by the copied value */
        entry("Y", ctx -> ctx.memory().write(ctx.memory().read() * ctx.memory().clipboard())),
        /* Divide the current cell's value by the copied value. */
        entry("D", ctx -> ctx.memory().write(ctx.memory().read() / ctx.memory().clipboard())));

    public static String interpret(final String code) {
        Memory memory = new Memory();
        List<String> program = Arrays.stream(code.split("")).filter(commands::containsKey).collect(Collectors.toUnmodifiableList());
        AtomicInteger pointer = new AtomicInteger();

        while (pointer.get() >= 0 && pointer.get() < program.size()) {
            printState(memory, program, pointer);
            System.out.println("---");
            Context ctx = new Context(memory, program, pointer, program.get(pointer.get()));
            PoohBear.commands.getOrDefault(ctx.instruction(), noop -> {
            }).accept(ctx);
            pointer.getAndIncrement();
        }

        printState(memory, program, pointer);
        return memory.printBuffer();
    }

    private static void printState(Memory memory, List<String> program, AtomicInteger pointer) {
        System.out.println(String.join("", program));
        System.out.println(" ".repeat(pointer.get()) + "^");
        System.out.println("cell: " + memory.pointer + "=" + memory.read());
        System.out.println("clip: " + memory.clipboard());
        System.out.println("tape: " + memory.cells);
        System.out.println("buff: " + memory.printBuffer());
    }

    private static void jumpLeft(Context ctx) {
        if (ctx.memory().read() == 0) return;
        var level = 0;
        for (int i = ctx.pointer.get(); i >= 0; i--) {
            if (ctx.program.get(i).equals("E")) level++;
            else if (ctx.program.get(i).equals("W")) {
                level--;
                if (level == 0) {
                    ctx.pointer.set(i - 1);
                    return;
                }
            }
        }
    }

    private static void jumpRight(Context ctx) {
        if (ctx.memory().read() == 1) return;
        var level = 0;
        for (int i = ctx.pointer.get(); i < ctx.program.size(); i++) {
            if (ctx.program.get(i).equals("W")) level++;
            else if (ctx.program.get(i).equals("E")) {
                level--;
                if (level == 0) {
                    ctx.pointer.set(i - 1);
                    return;
                }
            }
        }
    }

    public static class Context {
        private final Memory memory;
        private final List<String> program;
        private final AtomicInteger pointer;
        private final String instruction;

        public Context(Memory memory, List<String> program, AtomicInteger pointer, String instruction) {
            this.memory = memory;
            this.program = program;
            this.pointer = pointer;
            this.instruction = instruction;
        }

        public Memory memory() {
            return memory;
        }

        public List<String> program() {
            return program;
        }

        public AtomicInteger pointer() {
            return pointer;
        }

        public String instruction() {
            return instruction;
        }
    }

    public static class Memory {
        private final Map<Integer, Byte> cells = new HashMap<>();
        private final StringBuilder buffer = new StringBuilder();

        private int pointer;
        private int clipboard;

        public void left() {
            pointer--;
        }

        public void right() {
            pointer++;
        }

        public int read() {
            return Byte.toUnsignedInt(cells.getOrDefault(pointer, (byte) 0));
        }

        public void write(int value) {
            value = ((value % 256) + 256) % 256;
            if (value == 0) cells.remove(value);
            cells.put(pointer, (byte) value);
        }

        public void write(double value) {
            value = Math.min(Integer.MAX_VALUE, value);
            value = Math.max(Integer.MIN_VALUE, value);
            write((int) value);
        }

        public void copy() {
            clipboard = read();
        }

        public void paste() {
            write(clipboard);
        }

        public int clipboard() {
            return clipboard;
        }

        public void appendBuffer(String s) {
            buffer.append(s);
        }

        public String printBuffer() {
            return buffer.toString();
        }
    }
}
