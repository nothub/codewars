package lol.hub.codewars.codewars_style_ranking_system;

/**
 * @see <a href="https://www.codewars.com/kata/51fda2d95d6efda45e00004e">codewars.com</a>
 */
public class User {
    public int rank = -8;
    public int progress = 0;

    public void incProgress(int i) {
        if (i < -8 || i == 0 || i > 8) throw new IllegalArgumentException();
        if (rank == 8) return;
        int distance = Math.abs(i - rank);
        if (rank < 0 && i > 0 || i < 0 && rank > 0) distance--;
        if (i > rank && distance > 0) {
            update(10 * distance * distance);
        } else if (i == rank) {
            update(3);
        } else if (i < rank && distance == 1) {
            update(1);
        }
    }

    public void update(int gain) {
        if (rank == 8) return;
        progress = progress + gain;
        if (progress >= 100) {
            rank++;
            if (rank == 0) rank++;
            int remain = progress - 100;
            progress = 0;
            update(remain);
        }
    }
}
