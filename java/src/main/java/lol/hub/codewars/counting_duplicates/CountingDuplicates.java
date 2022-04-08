package lol.hub.codewars.counting_duplicates;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://www.codewars.com/kata/54bf1c2cd5b56cc47f0007a1">codewars.com</a>
 */
public class CountingDuplicates {
    public static int duplicateCount(String text) {
        Map<Character, Integer> map = new HashMap<>();
        text = text.toLowerCase();
        for (char c : text.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return (int) map.values().stream().filter(i -> i > 1).count();
    }
}
