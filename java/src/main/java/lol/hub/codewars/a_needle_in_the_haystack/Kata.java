package lol.hub.codewars.a_needle_in_the_haystack;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @see <a href="https://www.codewars.com/kata/56676e8fabd2d1ff3000000c">codewars.com</a>
 */
public class Kata {
    public static final String NEEDLE = "needle";

    public static String findNeedle(Object[] haystack) {
        return "found the needle at position " + IntStream.range(0, Math.toIntExact(Arrays.stream(haystack).count())).filter(i -> haystack[i] == NEEDLE).findFirst().orElseThrow();
    }
}
