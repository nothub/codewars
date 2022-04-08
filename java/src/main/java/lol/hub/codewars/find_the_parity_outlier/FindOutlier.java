package lol.hub.codewars.find_the_parity_outlier;

/**
 * @see <a href="https://www.codewars.com/kata/5526fc09a1bbd946250002dc">codewars.com</a>
 */
public class FindOutlier {
    static int find(int[] integers) {
        int odds = 0;
        int evens = 0;
        int lastOdd = 0;
        int lastEven = 0;
        for (int i : integers) {
            if (i % 2 == 0) {
                lastEven = i;
                evens++;
            } else {
                lastOdd = i;
                odds++;
            }
            if (evens > 1 && odds == 1) return lastOdd;
            if (evens == 1 && odds > 1) return lastEven;
        }
        throw new IllegalArgumentException();
    }
}
