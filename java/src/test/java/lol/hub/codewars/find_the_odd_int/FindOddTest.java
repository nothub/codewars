package lol.hub.codewars.find_the_odd_int;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindOddTest {
    @Test
    public void test1() {
        assertEquals(5, FindOdd.findIt(new int[]{20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5}));
    }

    @Test
    public void test2() {
        assertEquals(-1, FindOdd.findIt(new int[]{1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5}));
    }

    @Test
    public void test3() {
        assertEquals(5, FindOdd.findIt(new int[]{20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5}));
    }

    @Test
    public void test4() {
        assertEquals(10, FindOdd.findIt(new int[]{10}));
    }

    @Test
    public void test5() {
        assertEquals(10, FindOdd.findIt(new int[]{1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1}));
    }

    @Test
    public void test6() {
        assertEquals(1, FindOdd.findIt(new int[]{5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10}));
    }
}
