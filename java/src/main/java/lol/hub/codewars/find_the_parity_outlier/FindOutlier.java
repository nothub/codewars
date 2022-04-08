package lol.hub.codewars.find_the_parity_outlier;

/**
 * @see <a href="https://www.codewars.com/kata/5526fc09a1bbd946250002dc">codewars.com</a>
 */
public class FindOutlier {
    static int find(int[] integers) {
        int odds = 0, evens = 0, lastOdd = 0, lastEven = 0;
        for (int i : integers) {
            if (i % 2 == 0) {
                lastEven = i;
                evens++;
            } else {
                lastOdd = i;
                odds++;
            }
            if (odds == 1 && evens > 1) return lastOdd;
            if (odds > 1 && evens == 1) return lastEven;
        }
        throw new IllegalArgumentException();
    }
}
