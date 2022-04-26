package lol.hub.codewars.a_needle_in_the_haystack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NeedleExampleTests {
    @Test
    public void test1() {
        assertEquals("found the needle at position 3", Kata.findNeedle(new Object[]{"3", "123124234", null, "needle", "world", "hay", 2, "3", true, false}));
    }

    @Test
    public void test2() {
        assertEquals("found the needle at position 5", Kata.findNeedle(new Object[]{"283497238987234", "a dog", "a cat", "some random junk", "a piece of hay", "needle", "something somebody lost a while ago"}));
    }

    @Test
    public void test3() {
        assertEquals("found the needle at position 30", Kata.findNeedle(new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 8, 7, 5, 4, 3, 4, 5, 6, 67, 5, 5, 3, 3, 4, 2, 34, 234, 23, 4, 234, 324, 324, "needle", 1, 2, 3, 4, 5, 5, 6, 5, 4, 32, 3, 45, 54}));
    }
}
