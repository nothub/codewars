package lol.hub.codewars.psychic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RandomTest {
    @Test
    public void testRandom() {
        assertEquals(Psychic.guess(), java.lang.Math.random(), 0);
    }
}
