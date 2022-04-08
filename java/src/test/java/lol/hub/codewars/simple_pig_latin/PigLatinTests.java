package lol.hub.codewars.simple_pig_latin;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertEquals;

public class PigLatinTests {
    @Rule
    public Timeout globalTimeout = Timeout.millis(16000);

    @Test
    public void test1() {
        assertEquals("igPay atinlay siay oolcay", PigLatin.pigIt("Pig latin is cool"));
    }

    @Test
    public void test2() {
        assertEquals("hisTay siay ymay tringsay", PigLatin.pigIt("This is my string"));
    }

    @Test
    public void test3() {
        assertEquals("Oay emporatay oay oresmay !", PigLatin.pigIt("O tempora o mores !"));
    }
}
