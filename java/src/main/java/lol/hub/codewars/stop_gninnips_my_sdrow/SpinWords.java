package lol.hub.codewars.stop_gninnips_my_sdrow;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @see <a href="https://www.codewars.com/kata/5264d2b162488dc400000001">codewars.com</a>
 */
public class SpinWords {
    private static String spin(String s) {
        if (s.length() < 5) return s;
        return new StringBuilder(s).reverse().toString();
    }

    public String spinWords(String sentence) {
        return Arrays.stream(sentence.split(" "))
            .map(SpinWords::spin)
            .collect(Collectors.joining(" "));
    }
}
