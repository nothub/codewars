package lol.hub.codewars.are_they_the_same;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @see <a href="https://www.codewars.com/kata/550498447451fbbd7600041c">codewars.com</a>
 */
public class AreSame {
    public static boolean comp(int[] a, int[] b) {
        if (a == null || b == null) return false;
        if (a.length == 0 || b.length == 0) return false;
        Set<Integer> aSquared = Arrays
            .stream(a)
            .mapToObj(i -> i * i)
            .collect(Collectors.toUnmodifiableSet());
        for (int i : b) {
            if (!aSquared.contains(i)) return false;
        }
        return true;
    }
}
