package lol.hub.codewars.beginner_series_4_cockroach;

/**
 * @see <a href="https://www.codewars.com/kata/55fab1ffda3e2e44f00000c6">codewars.com</a>
 */
public class Cockroach {
    public static final double FACTOR_KMH_CMS = 0.036;

    public int cockroachSpeed(double x) {
        return (int) (x / FACTOR_KMH_CMS);
    }
}
