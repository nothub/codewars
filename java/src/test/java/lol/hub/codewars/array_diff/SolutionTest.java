package lol.hub.codewars.array_diff;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test1() {
        assertArrayEquals(new int[]{2}, Kata.arrayDiff(new int[]{1, 2}, new int[]{1}));
    }

    @Test
    public void test2() {
        assertArrayEquals(new int[]{2, 2}, Kata.arrayDiff(new int[]{1, 2, 2}, new int[]{1}));
    }

    @Test
    public void test3() {
        assertArrayEquals(new int[]{1}, Kata.arrayDiff(new int[]{1, 2, 2}, new int[]{2}));
    }

    @Test
    public void test4() {
        assertArrayEquals(new int[]{1, 2, 2}, Kata.arrayDiff(new int[]{1, 2, 2}, new int[]{}));
    }

    @Test
    public void test5() {
        assertArrayEquals(new int[]{}, Kata.arrayDiff(new int[]{}, new int[]{1, 2}));
    }
}
