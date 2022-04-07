package lol.hub.codewars.roman_numerals_encoder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConversionTest {
    private final Conversion conversion = new Conversion();

    @Test
    public void test1() {
        assertEquals("solution(1) should equal to I", "I", conversion.solution(1));
    }

    @Test
    public void test2() {
        assertEquals("solution(4) should equal to IV", "IV", conversion.solution(4));
    }

    @Test
    public void test3() {
        assertEquals("solution(6) should equal to VI", "VI", conversion.solution(6));
    }
}
