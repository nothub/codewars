package lol.hub.codewars.codewars_style_ranking_system;

/**
 * @see <a href="https://www.codewars.com/kata/51fda2d95d6efda45e00004e">codewars.com</a>
 */
public class User {
    public int rank = -8;
    public int progress = 0;

    public void incProgress(int i) {
        System.out.println("start user: " + this);
        System.out.println("kata: " + i);

        if (i < -8 || i == 0 || i > 8) throw new IllegalArgumentException();
        if (rank == 8) return;

        int distance = Math.abs(i - rank);
        if (rank < 0 && i > 0 || i < 0 && rank > 0) distance--;

        System.out.println("distance: " + distance);

        if (i > rank && distance > 0) {
            progress(10 * distance * distance);
        } else if (i == rank) {
            progress(3);
        } else if (i < rank && distance == 1) {
            progress(1);
        }

        System.out.println("end user: " + this);
        System.out.println("---");
    }

    public void progress(int gain) {
        if (gain <= 0) return;
        System.out.println("progress: " + (progress + gain) + " (gain: " + gain + ")");
        progress = progress + gain;
        if (progress >= 100) {
            rank++;
            if (rank == 0) rank++;
            int remain = progress - 100;
            System.out.println("rankup!");
            System.out.println("remain: " + remain);
            progress = 0;
            if (rank == 8) return;
            progress(remain);
        }
    }

    @Override
    public String toString() {
        return "User{" + "rank=" + rank + ", progress=" + progress + '}';
    }
}
