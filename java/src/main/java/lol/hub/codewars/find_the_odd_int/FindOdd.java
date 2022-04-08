package lol.hub.codewars.find_the_odd_int;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://www.codewars.com/kata/54da5a58ea159efa38000836">codewars.com</a>
 */
public class FindOdd {
    public static int findIt(int[] a) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i : a) {
            m.put(i, m.getOrDefault(i, 0) + 1);
        }
        return m.entrySet().stream()
            .filter(entry -> entry.getValue() % 2 != 0)
            .findFirst()
            .map(Map.Entry::getKey)
            .orElseThrow();
    }
}
