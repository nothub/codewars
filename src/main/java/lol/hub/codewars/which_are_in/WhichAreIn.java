package lol.hub.codewars.which_are_in;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @see <a href="https://www.codewars.com/kata/550554fd08b86f84fe000a58">codewars.com</a>
 */
public class WhichAreIn {
    public static String[] inArray(String[] array1, String[] array2) {
        List<String> substrings = new ArrayList<>();
        for (String needle : array1) {
            for (String haystack : array2) {
                if (haystack.contains(needle)) {
                    substrings.add(needle);
                    break;
                }
            }
        }
        substrings.sort(Comparator.naturalOrder());
        return substrings.toArray(new String[0]);
    }
}
