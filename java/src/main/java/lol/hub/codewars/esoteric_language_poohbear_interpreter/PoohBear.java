package lol.hub.codewars.esoteric_language_poohbear_interpreter;

import java.util.Map;
import java.util.function.Consumer;

import static java.util.Map.entry;

/**
 * @see <a href="https://www.codewars.com/kata/59a9735a485a4d807f00008a">codewars.com</a>
 */
public class PoohBear {

    static final Map<String, Consumer<Memory>> commands = Map.ofEntries(
        entry("+", m -> { /* Add 1 to the current cell */ }),
        entry("-", m -> { /* Subtract 1 from the current cell */ }),
        entry(">", m -> { /* Move the cell pointer 1 space to the right */ }),
        entry("<", m -> { /* Move the cell pointer 1 space to the left */ }),
        entry("c", m -> { /* "Copy" the current cell */ }),
        entry("p", m -> { /* Paste the "copied" cell into the current cell */ }),
        entry("W", m -> { /* While the current cell is not equal to 0, jump to the corresponding E */ }),
        entry("E", m -> { /* While the current cell is not equal to 1, jump to the corresponding W */ }),
        entry("P", m -> { /* Output the current cell's value as ascii */ }),
        entry("N", m -> { /* Output the current cell's value as an integer */ }),
        entry("T", m -> { /* Multiply the current cell by 2 */ }),
        entry("Q", m -> { /* Square the current cell */ }),
        entry("U", m -> { /* Square root the current cell's value */ }),
        entry("L", m -> { /* Add 2 to the current cell */ }),
        entry("I", m -> { /* Subtract 2 from the current cell */ }),
        entry("V", m -> { /* Divide the current cell by 2 */ }),
        entry("A", m -> { /* Add the copied value to the current cell's value */ }),
        entry("B", m -> { /* Subtract the copied value from the current cell's value */ }),
        entry("Y", m -> { /* Multiply the current cell's value by the copied value */ }),
        entry("D", m -> { /* Divide the current cell's value by the copied value. */ })
    );

    public static String interpret(final String s) {
    /* If the result of an operation isn't an int, round the result down to the nearest one.
    Your interpreter should ignore any non-command characters in the code. */
        return "";
    }

}
