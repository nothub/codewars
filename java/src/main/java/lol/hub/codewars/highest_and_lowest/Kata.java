package lol.hub.codewars.highest_and_lowest;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

/**
 * @see <a href="https://www.codewars.com/kata/554b4ac871d6813a03000035">codewars.com</a>
 */
public class Kata {
    public static String highAndLow(String numbers) {
        IntSummaryStatistics stats = Arrays
            .stream(numbers.split(" "))
            .mapToInt(Integer::valueOf)
            .summaryStatistics();
        return stats.getMax() + " " + stats.getMin();
    }
}
