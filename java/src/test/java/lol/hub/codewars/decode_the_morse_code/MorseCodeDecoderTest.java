package lol.hub.codewars.decode_the_morse_code;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MorseCodeDecoderTest {
    @Test
    public void testExampleFromDescription() {
        assertEquals("HEY JUDE", MorseCodeDecoder.decode(".... . -.--   .--- ..- -.. ."));
    }

    @Test
    public void test1() {
        assertEquals("E", MorseCodeDecoder.decode("."));
        assertEquals("E", MorseCodeDecoder.decode(" ."));
        assertEquals("E", MorseCodeDecoder.decode(". "));
        assertEquals("E", MorseCodeDecoder.decode(" . "));
    }
}
