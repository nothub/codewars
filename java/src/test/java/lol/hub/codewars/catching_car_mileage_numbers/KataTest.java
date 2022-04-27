package lol.hub.codewars.catching_car_mileage_numbers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KataTest {
    @Test
    public void test1() {
        assertEquals(0, Kata.isInteresting(3, new int[]{1337, 256}));
    }

    @Test
    public void test2() {
        assertEquals(1, Kata.isInteresting(1335, new int[]{1337, 256}));
    }

    @Test
    public void test3() {
        assertEquals(1, Kata.isInteresting(1336, new int[]{1337, 256}));
    }

    @Test
    public void test4() {
        assertEquals(2, Kata.isInteresting(1337, new int[]{1337, 256}));
    }

    @Test
    public void test5() {
        assertEquals(0, Kata.isInteresting(3236, new int[]{1337, 256}));
    }

    @Test
    public void test6() {
        assertEquals(0, Kata.isInteresting(11207, new int[]{}));
    }

    @Test
    public void test7() {
        assertEquals(0, Kata.isInteresting(11208, new int[]{}));
    }

    @Test
    public void test8() {
        assertEquals(0, Kata.isInteresting(11208, new int[]{1337, 256}));
    }

    @Test
    public void test9() {
        assertEquals(1, Kata.isInteresting(11209, new int[]{}));
    }

    @Test
    public void test10() {
        assertEquals(1, Kata.isInteresting(11209, new int[]{1337, 256}));
    }

    @Test
    public void test11() {
        assertEquals(1, Kata.isInteresting(11210, new int[]{}));
    }

    @Test
    public void test12() {
        assertEquals(2, Kata.isInteresting(11211, new int[]{}));
    }

    @Test
    public void test13() {
        assertEquals(2, Kata.isInteresting(11211, new int[]{1337, 256}));
    }
}
