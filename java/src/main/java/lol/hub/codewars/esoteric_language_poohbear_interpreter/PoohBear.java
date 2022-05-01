package lol.hub.codewars.esoteric_language_poohbear_interpreter;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

import static java.util.Map.entry;

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
        /* While the current cell is not equal to 0, jump to the corresponding E */
        entry("W", ctx -> ctx.memory().jumpRight()),
        /* While the current cell is not equal to 1, jump to the corresponding W */
        entry("E", ctx -> ctx.memory().jumpLeft()),
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
        String[] commands = code.split("");
        AtomicInteger pointer = new AtomicInteger();
        while (pointer.get() >= 0 && pointer.get() < commands.length) {
            Context ctx = new Context(memory, commands, pointer, commands[pointer.getAndIncrement()]);
            PoohBear.commands.getOrDefault(ctx.instruction(), noop -> {}).accept(ctx);
        }
        return memory.printBuffer();
    }
}
