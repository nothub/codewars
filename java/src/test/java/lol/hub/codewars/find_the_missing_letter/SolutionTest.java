package lol.hub.codewars.find_the_missing_letter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test0() {
        assertEquals('e', Kata.findMissingLetter(new char[]{'a', 'b', 'c', 'd', 'f'}));
    }

    @Test
    public void test1() {
        assertEquals('P', Kata.findMissingLetter(new char[]{'O', 'Q', 'R', 'S'}));
    }
}
