package lol.hub.codewars.catching_car_mileage_numbers;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * @see <a href="https://www.codewars.com/kata/52c4dd683bfd3b434c000292">codewars.com</a>
 */
public class CarMileage {

    public static final int NOT_INTERESTING = 0;
    public static final int NEXT_TWO_MILES = 1;
    public static final int INTERESTING = 2;

    public static int isInteresting(int number, int[] awesomePhrases) {
        if (interesting(number, awesomePhrases)) {
            return INTERESTING;
        } else if (interesting(number + 1, awesomePhrases) || interesting(number + 2, awesomePhrases)) {
            return NEXT_TWO_MILES;
        }
        return NOT_INTERESTING;
    }

    private static boolean interesting(int number, int[] awesomePhrases) {
        System.out.println(number);

        boolean threeOrMoreDigits = threeOrMoreDigits(number);
        System.out.println("threeOrMoreDigits:\t" + threeOrMoreDigits);

        boolean followedByAllZeros = followedByAllZeros(number);
        System.out.println("followedByAllZeros:\t" + followedByAllZeros);

        boolean everyDigitSame = everyDigitSame(number);
        System.out.println("everyDigitSame:\t" + everyDigitSame);

        boolean sequentialIncementing = isSequentialIncementing(number);
        System.out.println("sequentialIncementing:\t" + sequentialIncementing);

        boolean sequentialDecrementing = isSequentialDecrementing(number);
        System.out.println("sequentialDecrementing:\t" + sequentialDecrementing);

        boolean palindrome = palindrome(number);
        System.out.println("palindrome:\t" + palindrome);

        boolean awesomePhrasesContains = awesomePhrasesContains(number, awesomePhrases);
        System.out.println("awesomePhrasesContains:\t" + awesomePhrasesContains);

        boolean interesting = threeOrMoreDigits && (followedByAllZeros || everyDigitSame || sequentialIncementing || sequentialDecrementing || palindrome || awesomePhrasesContains);
        System.out.println("interesting:\t" + interesting);

        return interesting;
    }

    private static boolean threeOrMoreDigits(int number) {
        // 3 or more digits in number
        return number - 100 >= 0;
    }

    private static boolean followedByAllZeros(int number) {
        // digit followed by all zeros: 100, 90000
        var digits = splitToDigits(number);
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] != 0) return false;
        }
        return true;
    }

    private static boolean everyDigitSame(int number) {
        // every digit is the same number: 1111
        return Arrays.stream(splitToDigits(number)).distinct().count() == 1;
    }

    private static boolean isSequentialIncementing(int number) {
        // The digits are sequential, incementing: 1234 (For incrementing sequences, 0 should come after 9, and not before 1, as in 7890)
        var digits = splitToDigits(number);
        long last = digits[0] - 1;
        for (long digit : digits) {
            long n = digit == 0 ? 10 : digit;
            if (last != n - 1) return false;
            last = n;
        }
        return true;
    }

    private static boolean isSequentialDecrementing(int number) {
        // The digits are sequential, decrementing: 4321 (For decrementing sequences, 0 should come after 1, and not before 9, as in 3210)
        var digits = splitToDigits(number);
        long last = digits[0] + 1;
        for (long n : digits) {
            if (last != n + 1) return false;
            last = n;
        }
        return true;
    }

    private static boolean palindrome(int number) {
        // The digits are a palindrome: 1221 or 73837
        var digits = splitToDigits(number);
        var left = Arrays.stream(Arrays.copyOfRange(digits, 0, digits.length / 2)).boxed().collect(Collectors.toUnmodifiableList());
        var right = Arrays.stream(Arrays.copyOfRange(digits, digits.length / 2 + (digits.length % 2 == 0 ? 0 : 1), digits.length)).boxed().collect(Collectors.toList());
        Collections.reverse(right);
        return left.equals(right);
    }

    private static boolean awesomePhrasesContains(int number, int[] awesomePhrases) {
        // The digits match one of the values in the awesomePhrases array
        return Arrays.stream(awesomePhrases).filter(i -> number == i).findAny().isPresent();
    }

    private static long[] splitToDigits(long num) {
        int size = (int) (Math.log10(num) + 1);
        long[] digits = new long[size];
        int i = size - 1;
        while (num > 0) {
            digits[i] = num % 10;
            num /= 10;
            i--;
        }
        return digits;
    }

}
