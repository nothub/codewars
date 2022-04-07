package lol.hub.codewars.highest_and_lowest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @see <a href="https://www.codewars.com/kata/554b4ac871d6813a03000035">codewars.com</a>
 */
public class Kata {
    public static String highAndLow(String numbers) {
        Set<Integer> set = Arrays
            .stream(numbers.split(" "))
            .mapToInt(Integer::valueOf)
            .boxed()
            .collect(Collectors.toUnmodifiableSet());
        return set.stream().max(Comparator.naturalOrder()).orElseThrow() + " " + set.stream().min(Comparator.naturalOrder()).orElseThrow();
    }
}
