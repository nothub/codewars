package lol.hub.codewars.are_they_the_same;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
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
        List<Integer> la = Arrays.stream(a).boxed().map(i -> i * i).collect(Collectors.toList());
        List<Integer> lb = Arrays.stream(b).boxed().collect(Collectors.toCollection(CopyOnWriteArrayList::new));
        for (Integer nb : lb) {
            la.remove(nb);
            lb.remove(nb);
        }
        return la.size() == 0 && lb.size() == 0;
    }
}
