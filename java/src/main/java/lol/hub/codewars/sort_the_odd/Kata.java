package lol.hub.codewars.sort_the_odd;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://www.codewars.com/kata/578aa45ee9fd15ff4600090d">codewars.com</a>
 */
public class Kata {
    public static int[] sortArray(int[] array) {
        List<Integer> odd = new ArrayList<>();
        for (int n : array) {
            if (n % 2 != 0) odd.add(n);
        }
        odd.sort(Integer::compareTo);
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                array[i] = odd.remove(0);
            }
        }
        return array;
    }
}
