package lol.hub.codewars.how_many_numbers_3;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(16000);

    @Test
    public void test1() {
        assertEquals(Arrays.asList(8L, 118L, 334L), HowManyNumbers.findAll(10, 3));
    }

    @Test
    public void test2() {
        assertEquals(Arrays.asList(1L, 999L, 999L), HowManyNumbers.findAll(27, 3));
    }

    @Test
    public void test3() {
        assertEquals(new ArrayList<Long>(), HowManyNumbers.findAll(84, 4));
    }

    @Test
    public void test4() {
        assertEquals(Arrays.asList(123L, 116999L, 566666L), HowManyNumbers.findAll(35, 6));
    }

    @Test
    public void test5() {
        assertEquals(Arrays.asList(1L, 899L, 899L), HowManyNumbers.findAll(26, 3));
    }

    @Test
    public void test6() {
        assertEquals(Arrays.asList(1L, 8999L, 8999L), HowManyNumbers.findAll(35, 4));
    }

    @Test
    public void test7() {
        assertEquals(Arrays.asList(71L, 11699L, 55556L), HowManyNumbers.findAll(26, 5));
    }

    @Test
    public void test8() {
        assertEquals(Arrays.asList(285L, 1116999L, 5555556L), HowManyNumbers.findAll(36, 7));
    }

    //@Test
    public void test9() {
        assertEquals(Arrays.asList(873L, 111129999L, 444555555L), HowManyNumbers.findAll(42, 9));
    }
}
