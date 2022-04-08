package lol.hub.codewars.how_many_numbers_3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;

// TODO: too slow!

/**
 * @see <a href="https://www.codewars.com/kata/5877e7d568909e5ff90017e6">codewars.com</a>
 */
class HowManyNumbers {
    public static List<Long> findAll(final int sumDigits, final int numDigits) {
        IntSummaryStatistics stats = IntStream.range(
                Integer.parseInt(1 + "0".repeat(numDigits - 1)),
                Integer.parseInt("9".repeat(numDigits)) + 1)
            .filter(i -> isDigitsSum(i, sumDigits))
            .filter(HowManyNumbers::isDigitsIncreasing)
            .summaryStatistics();
        List<Long> out = new ArrayList<>();
        if (stats.getCount() == 0) return out;
        out.add(stats.getCount());
        out.add((long) stats.getMin());
        out.add((long) stats.getMax());
        return out;
    }

    private static boolean isDigitsSum(int num, int sum) {
        return splitToDigits(num)
            .stream()
            .mapToInt(Integer::intValue)
            .sum() == sum;
    }

    private static boolean isDigitsIncreasing(int num) {
        List<Integer> sorted = splitToDigits(num);
        sorted.sort(Comparator.reverseOrder());
        return splitToDigits(num).equals(sorted);
    }

    private static List<Integer> splitToDigits(int num) {
        List<Integer> digits = new ArrayList<>();
        while (num > 0) {
            digits.add(num % 10);
            num /= 10;
        }
        return digits;
    }
}
