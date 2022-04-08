package lol.hub.codewars.sum_of_digits_digital_root;

import java.util.Arrays;

/**
 * @see <a href="https://www.codewars.com/kata/541c8630095125aba6000c00">codewars.com</a>
 */
public class DRoot {
    public static int digital_root(int n) {
        while (n > 9) n = Arrays.stream(splitToDigits(n)).sum();
        return n;
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
