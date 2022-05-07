package lol.hub.codewars.make_a_spiral;

import org.junit.Test;

import static lol.hub.codewars.make_a_spiral.Spiralizor.spiralize;
import static org.junit.Assert.assertArrayEquals;

/**
 * @see <a href="https://www.codewars.com/kata/534e01fbbb17187c7e0000c6">codewars.com</a>
 */
public class SpiralizorTest {
    @Test
    public void test5() {
        int[][] expected = {
            {1, 1, 1, 1, 1},
            {0, 0, 0, 0, 1},
            {1, 1, 1, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1}};
        int[][] actual = spiralize(5);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test8() {
        int[][] expected = {
            {1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 1, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1}};
        int[][] actual = spiralize(8);
        assertArrayEquals(expected, actual);
    }
}
