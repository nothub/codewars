package lol.hub.codewars.how_many_numbers_3;

import java.util.ArrayList;
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

    static boolean isDigitsSum(int num, int sum) {
        int digitSum = 0;
        for (Integer digit : splitToDigits(num)) {
            digitSum += digit;
        }
        return digitSum == sum;
    }

    static boolean isDigitsIncreasing(int num) {
        int last = Integer.MIN_VALUE;
        for (Integer digit : splitToDigits(num)) {
            if (last > digit) return false;
            last = digit;
        }
        return true;
    }

    static int[] splitToDigits(int num) {
        int size = (int) (Math.log10(num) + 1);
        int[] digits = new int[size];
        int i = size - 1;
        while (num > 0) {
            digits[i] = num % 10;
            num /= 10;
            i--;
        }
        return digits;
    }
}
