package lol.hub.codewars.next_bigger_number_with_the_same_digits;

import java.util.HashSet;
import java.util.Set;

// TODO: too slow!

/**
 * @see <a href="https://www.codewars.com/kata/55983863da40caa2c900004e">codewars.com</a>
 */
public class Kata {
    public static long nextBiggerNumber(long n) {
        System.out.println(n);
        return findPermutations(n)
            .stream()
            .distinct()
            .sorted()
            .map(Long::parseLong)
            .filter(l -> l > n)
            .findFirst().orElse(-1L);
    }

    private static Set<String> findPermutations(long n) {
        return recursivePermutation("", String.valueOf(n), new HashSet<>());
    }

    private static Set<String> recursivePermutation(String p, String s, Set<String> results) {
        if (s.length() == 0) {
            results.add(p);
        } else {
            for (int i = 0; i < s.length(); i++) {
                recursivePermutation(p + s.charAt(i), s.substring(0, i) + s.substring(i + 1), results);
            }
        }
        return results;
    }
}
