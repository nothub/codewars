package lol.hub.codewars.finding_neo_pg_13;

/**
 * @see <a href="https://www.codewars.com/kata/5522d19f20cc1c8330001218">codewars.com</a>
 */
public class Morpheus {
    public int[] find(Matrix matrix, int neo) {
        for (int x = 0; x < matrix.size(); x++) {
            for (int y = 0; y < matrix.size(); y++) {
                if (matrix.get(x, y) == neo) return new int[]{x, y};
            }
        }
        throw new IllegalStateException();
    }
}
