package lol.hub.codewars.stop_gninnips_my_sdrow;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpinWordsTest {
    @Test
    public void test0() {
        assertEquals("emocleW", new SpinWords().spinWords("Welcome"));
    }

    @Test
    public void test1() {
        assertEquals("Hey wollef sroirraw", new SpinWords().spinWords("Hey fellow warriors"));
    }
}
