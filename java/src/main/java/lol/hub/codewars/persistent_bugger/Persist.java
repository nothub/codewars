package lol.hub.codewars.persistent_bugger;

/**
 * @see <a href="https://www.codewars.com/kata/55bf01e5a717a0d57e0000ec">codewars.com</a>
 */
class Persist {
    public static int persistence(long n) {
        int count = 0;
        while (n > 9) {
            count++;
            long result = 1;
            for (long i : splitToDigits(n)) {
                result = result * i;
            }
            n = result;
        }
        return count;
    }

    static long[] splitToDigits(long num) {
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
