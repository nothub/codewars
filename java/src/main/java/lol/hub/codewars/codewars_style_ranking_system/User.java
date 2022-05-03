package lol.hub.codewars.codewars_style_ranking_system;

// Note: In Java some methods may throw an IllegalArgumentException.

/**
 * @see <a href="https://www.codewars.com/kata/51fda2d95d6efda45e00004e">codewars.com</a>
 */
public class User {
    public int rank = -8;
    public int progress = 0;

    public void incProgress(int i) {
        if (i < 1 || i > 8) throw new IllegalArgumentException();
        System.out.println(i);
        if (rank == 8) return;
        int gain = 0;
        if (i > rank) {
            int d = i - rank;
            gain = 10 * d * d;
        } else if (i == rank) {
            gain = 3;
        } else if (i == rank - 1) {
            gain = 1;
        }
        progress = progress + gain;
        if (progress >= 100) {
            rank++;
            if (rank == 0) rank++;
            int remain = progress - 100;
            progress = 0;
            incProgress(remain);
        }
    }
}
