package lol.hub.codewars.are_they_the_same;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AreSameTest {
    @Test
    public void test1() {
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
        assertTrue(AreSame.comp(a, b));
    }

    @Test
    public void test2() {
        int[] a = new int[]{31};
        int[] b = new int[]{42};
        assertFalse(AreSame.comp(a, b));
    }

    @Test
    public void test3() {
        int[] a = new int[]{};
        int[] b = new int[]{};
        assertTrue(AreSame.comp(a, b));
    }

    @Test
    public void test4() {
        int[] a = new int[]{2, 2, 3};
        int[] b = new int[]{4, 9, 9};
        assertFalse(AreSame.comp(a, b));
    }
}
