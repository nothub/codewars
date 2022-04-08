package lol.hub.codewars.single_word_pig_latin;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertEquals;

public class TestPigLatin {
    @Rule
    public Timeout globalTimeout = Timeout.millis(16000);

    @Test
    public void testMap() {
        assertEquals("apmay", new PigLatin().translate("map"));
    }

    @Test
    public void testegg() {
        assertEquals("eggway", new PigLatin().translate("egg"));
    }

    @Test
    public void testspaghetti() {
        assertEquals("aghettispay", new PigLatin().translate("spaghetti"));
    }
}
