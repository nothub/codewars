package lol.hub.codewars.simple_pig_latin;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @see <a href="https://www.codewars.com/kata/520b9d2ad5c005041100000f">codewars.com</a>
 */
public class PigLatin {
    public static String pigIt(String str) {
        return Arrays.stream(str.split(" "))
            .map(PigLatin::pigify)
            .collect(Collectors.joining(" "));
    }

    private static String pigify(String word) {
        for (char c : word.toCharArray()) {
            if (!Character.isAlphabetic(c)) return word;
        }
        return word.substring(1) + word.charAt(0) + "ay";
    }
}
