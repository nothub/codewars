package lol.hub.codewars.array_diff;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @see <a href="https://www.codewars.com/kata/523f5d21c841566fde000009">codewars.com</a>
 */
public class Kata {
    public static int[] arrayDiff(int[] a, int[] b) {
        Set<Integer> remove = Arrays.stream(b).boxed().collect(Collectors.toUnmodifiableSet());
        return Arrays.stream(a).filter(i -> !remove.contains(i)).toArray();
    }
}
