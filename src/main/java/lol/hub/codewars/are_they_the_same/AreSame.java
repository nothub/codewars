package lol.hub.codewars.are_they_the_same;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @see <a href="https://www.codewars.com/kata/550498447451fbbd7600041c">codewars.com</a>
 */
public class AreSame {
    public static boolean comp(int[] a, int[] b) {
        if (a == null || b == null) return false;
        if (a.length == 0 && b.length == 0) return true;
        if (a.length != 0 && b.length == 0) return false;
        if (a.length == 0 && b.length != 0) return false;
        return Arrays.stream(a)
            .mapToObj(i -> i * i)
            .collect(Collectors.toUnmodifiableSet())
            .containsAll(Arrays.stream(b)
                .boxed()
                .collect(Collectors.toUnmodifiableSet()));
    }
}
