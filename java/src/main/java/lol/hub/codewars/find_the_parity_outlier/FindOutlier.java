package lol.hub.codewars.find_the_parity_outlier;

/**
 * @see <a href="https://www.codewars.com/kata/5526fc09a1bbd946250002dc">codewars.com</a>
 */
public class FindOutlier {
    static int find(int[] integers) {
        int numOdds = 0, numEvens = 0, lastOdd = 0, lastEven = 0;
        for (int i : integers) {
            if (i % 2 == 0) {
                lastEven = i;
                numEvens++;
            } else {
                lastOdd = i;
                numOdds++;
            }
            if (numOdds == 1 && numEvens > 1) return lastOdd;
            if (numOdds > 1 && numEvens == 1) return lastEven;
        }
        throw new IllegalArgumentException();
    }
}
