package lol.hub.codewars.url_shortener;

import java.util.HashMap;
import java.util.Map;

// TODO: does not pass random_tests_with_multiple_operations

/**
 * @see <a href="https://www.codewars.com/kata/5fee4559135609002c1a1841">codewars.com</a>
 */
public class Shortener {

    private static final int ASCII_OFFSET = 97;
    private static final String URL_PREFIX = "short.ly/";

    private final Map<String, String> m = new HashMap<>();

    static int[] splitToDigits(int num) {
        if (num < 0) num = num * -1;
        int size = (int) (Math.log10(num) + 1);
        int[] digits = new int[size];
        int i = size - 1;
        while (num > 0) {
            digits[i] = num % 10;
            num /= 10;
            i--;
        }
        return digits;
    }

    static String computeHash(int[] ints) {
        return "" +
            ((char) (ASCII_OFFSET + ints[0])) +
            ((char) (ASCII_OFFSET + ints[1])) +
            ((char) (ASCII_OFFSET + ints[2])) +
            ((char) (ASCII_OFFSET + ints[3]));
    }

    public String urlShortener(String longURL) {
        String hash = computeHash(splitToDigits(longURL.hashCode()));
        String shortURL = URL_PREFIX + hash;
        m.put(shortURL, longURL);
        return shortURL;
    }

    public String urlRedirector(String shortURL) {
        return m.get(shortURL);
    }
}
