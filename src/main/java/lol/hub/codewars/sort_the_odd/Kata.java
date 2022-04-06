package lol.hub.codewars.sort_the_odd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://www.codewars.com/kata/578aa45ee9fd15ff4600090d">codewars.com</a>
 */
public class Kata {
    public static int[] sortArray(int[] array) {
        int[] out = new int[array.length];
        Arrays.fill(out, Integer.MIN_VALUE);
        List<Integer> odd = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                out[i] = array[i];
            } else odd.add(array[i]);
        }
        odd.sort(Integer::compareTo);
        while (!odd.isEmpty()) {
            for (int i = 0; i < out.length; i++) {
                if (out[i] == Integer.MIN_VALUE) {
                    out[i] = odd.remove(0);
                    break;
                }
            }
        }
        return out;
    }
}
