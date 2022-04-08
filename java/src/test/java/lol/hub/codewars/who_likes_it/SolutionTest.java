package lol.hub.codewars.who_likes_it;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test_0() {
        assertEquals("no one likes this", Solution.whoLikesIt());
    }

    @Test
    public void test_1() {
        assertEquals("Peter likes this", Solution.whoLikesIt("Peter"));
    }

    @Test
    public void test_2() {
        assertEquals("Jacob and Alex like this", Solution.whoLikesIt("Jacob", "Alex"));
    }

    @Test
    public void test_3() {
        assertEquals("Max, John and Mark like this", Solution.whoLikesIt("Max", "John", "Mark"));
    }

    @Test
    public void test_4() {
        assertEquals("Alex, Jacob and 2 others like this", Solution.whoLikesIt("Alex", "Jacob", "Mark", "Max"));
    }
}
