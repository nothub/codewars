package lol.hub.codewars.next_bigger_number_with_the_same_digits;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertEquals;

public class KataTests {
    @Rule
    public Timeout globalTimeout = Timeout.millis(16000);

    @Test
    public void test1() {
        assertEquals(21, Kata.nextBiggerNumber(12));
    }

    @Test
    public void test2() {
        assertEquals(531, Kata.nextBiggerNumber(513));
    }

    @Test
    public void test3() {
        assertEquals(2071, Kata.nextBiggerNumber(2017));
    }

    @Test
    public void test4() {
        assertEquals(441, Kata.nextBiggerNumber(414));
    }

    @Test
    public void test5() {
        assertEquals(414, Kata.nextBiggerNumber(144));
    }

    @Test
    public void test6() {
        assertEquals(19009, Kata.nextBiggerNumber(10990));
    }

    @Test
    public void test7() {
        assertEquals(337034564, Kata.nextBiggerNumber(337034546));
    }

    @Test
    public void test8() {
        assertEquals(2049247957, Kata.nextBiggerNumber(2049247795));
    }

    @Test
    public void test9() {
        assertEquals(1647732015, Kata.nextBiggerNumber(1647731520));
    }

    @Test
    public void test10() {
        assertEquals(123456798, Kata.nextBiggerNumber(123456789));
    }

    @Test
    public void test11() {
        assertEquals(1234567908, Kata.nextBiggerNumber(1234567890));
    }

    @Test // TODO: too slow ;c
    public void test12() {
        assertEquals(-1L, Kata.nextBiggerNumber(9876543210L));
    }
}
