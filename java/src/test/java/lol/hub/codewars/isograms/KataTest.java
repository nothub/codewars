package lol.hub.codewars.isograms;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @see <a href="https://www.codewars.com/kata/54ba84be607a92aa900000f1">codewars.com</a>
 */
public class KataTest {
    @Test
    public void test() {
        assertTrue( Kata.isIsogram("Dermatoglyphics"));
        assertTrue( Kata.isIsogram("isogram"));
        assertFalse(Kata.isIsogram("moose"));
        assertFalse(Kata.isIsogram("isIsogram"));
        assertFalse(Kata.isIsogram("aba"));
        assertFalse(Kata.isIsogram("moOse"));
        assertTrue( Kata.isIsogram("thumbscrewjapingly"));
        assertTrue( Kata.isIsogram(""));
    }
}
