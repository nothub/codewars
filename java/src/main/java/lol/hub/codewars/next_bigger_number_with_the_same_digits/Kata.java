package lol.hub.codewars.next_bigger_number_with_the_same_digits;

// TODO: too slow! use knuth-l or something like that instead of recursive

import java.util.List;
import java.util.stream.Collectors;

/**
 * @see <a href="https://www.codewars.com/kata/55983863da40caa2c900004e">codewars.com</a>
 */
public class Kata {
    public static long nextBiggerNumber(long n) {
        for (int i = 1; i < n * 10; i++) {
            List<Integer> nl = String.valueOf(n).chars().sorted().boxed().collect(Collectors.toUnmodifiableList());
            List<Integer> bl = String.valueOf(n + i).chars().sorted().boxed().collect(Collectors.toUnmodifiableList());
            if (nl.equals(bl)) return n + i;
        }
        throw new IllegalStateException();
    }
}
