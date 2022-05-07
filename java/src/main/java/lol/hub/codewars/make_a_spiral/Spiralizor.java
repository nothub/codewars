package lol.hub.codewars.make_a_spiral;

/**
 * @see <a href="https://www.codewars.com/kata/534e01fbbb17187c7e0000c6">codewars.com</a>
 */
public class Spiralizor {
    public static int[][] spiralize(int size) {
        int[][] spiral = new int[size][size];
        var steps = size - 1;
        var x = steps;
        var y = 0;
        for (int i = 0; i < size; i++) spiral[y][i] = 1;
        while (steps > 0) {
            for (int i = 0; i < steps; i++) spiral[++y][x] = 1;
            if (steps == 1) break;
            for (int i = 0; i < steps; i++) spiral[y][--x] = 1;
            steps = steps - 2;
            for (int i = 0; i < steps; i++) spiral[--y][x] = 1;
            if (steps == 1) break;
            for (int i = 0; i < steps; i++) spiral[y][++x] = 1;
            steps = steps - 2;
        }
        return spiral;
    }
}
