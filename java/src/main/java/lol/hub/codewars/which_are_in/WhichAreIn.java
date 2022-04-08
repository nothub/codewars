package lol.hub.codewars.which_are_in;

import java.util.Arrays;

/**
 * @see <a href="https://www.codewars.com/kata/550554fd08b86f84fe000a58">codewars.com</a>
 */
public class WhichAreIn {
    public static String[] inArray(String[] array1, String[] array2) {
        return Arrays.stream(array1)
            .filter(needle -> Arrays.stream(array2).anyMatch(haystack -> haystack.contains(needle)))
            .sorted()
            .toArray(String[]::new);
    }
}
