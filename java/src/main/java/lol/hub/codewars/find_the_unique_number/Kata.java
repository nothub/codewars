package lol.hub.codewars.find_the_unique_number;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://www.codewars.com/kata/585d7d5adb20cf33cb000235">codewars.com</a>
 */
public class Kata {
    public static double findUniq(double[] arr) {
        Map<Double, Integer> m = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        }
        return Arrays.stream(arr)
            .distinct()
            .boxed()
            .filter(d -> d != (double) m.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .findAny()
                .map(Map.Entry::getKey)
                .orElseThrow())
            .findAny()
            .orElseThrow();
    }
}
