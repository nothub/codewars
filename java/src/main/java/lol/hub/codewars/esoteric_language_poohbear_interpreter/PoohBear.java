package lol.hub.codewars.esoteric_language_poohbear_interpreter;

import java.util.Map;
import java.util.function.Consumer;

import static java.util.Map.entry;

/**
 * @see <a href="https://www.codewars.com/kata/59a9735a485a4d807f00008a">codewars.com</a>
 */
public class PoohBear {

    public static final Consumer<Memory> NOOP = m -> {
    };

    static final Map<String, Consumer<Memory>> commands = Map.ofEntries(
        /* Add 1 to the current cell */
        entry("+", m -> m.write(m.read() + 1)),
        /* Subtract 1 from the current cell */
        entry("-", m -> m.write(m.read() - 1)),
        /* Move the cell pointer 1 space to the right */
        entry(">", Memory::right),
        /* Move the cell pointer 1 space to the left */
        entry("<", Memory::left),
        /* "Copy" the current cell */
        entry("c", Memory::copy),
        /* Paste the "copied" cell into the current cell */
        entry("p", Memory::paste),
        /* While the current cell is not equal to 0, jump to the corresponding E */
        entry("W", Memory::jumpRight),
        /* While the current cell is not equal to 1, jump to the corresponding W */
        entry("E", Memory::jumpLeft),
        /* Output the current cell's value as ascii */
        entry("P", m -> m.appendBuffer(String.valueOf((char) m.read()))),
        /* Output the current cell's value as an integer */
        entry("N", m -> m.appendBuffer(String.valueOf(m.read()))),
        /* Multiply the current cell by 2 */
        entry("T", m -> m.write(m.read() * 2)),
        /* Square the current cell */
        entry("Q", m -> m.write(Math.pow(m.read(), 2))),
        /* Square root the current cell's value */
        entry("U", m -> m.write(Math.sqrt(m.read()))),
        /* Add 2 to the current cell */
        entry("L", m -> m.write(m.read() + 2)),
        /* Subtract 2 from the current cell */
        entry("I", m -> m.write(m.read() - 2)),
        /* Divide the current cell by 2 */
        entry("V", m -> m.write(m.read() / 2)),
        /* Add the copied value to the current cell's value */
        entry("A", m -> m.write(m.read() + m.clipboard())),
        /* Subtract the copied value from the current cell's value */
        entry("B", m -> m.write(m.read() - m.clipboard())),
        /* Multiply the current cell's value by the copied value */
        entry("Y", m -> m.write(m.read() * m.clipboard())),
        /* Divide the current cell's value by the copied value. */
        entry("D", m -> m.write(m.read() / m.clipboard())));

    public static String interpret(final String s) {
        Memory memory = new Memory();
        for (String c : s.split("")) {
            commands.getOrDefault(c, NOOP).accept(memory);
        }
        return memory.printBuffer();
    }

}
