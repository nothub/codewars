package lol.hub.codewars.duplicate_encoder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DuplicateEncoderTest {
    @Test
    public void test1() {
        assertEquals(")()())()(()()(", DuplicateEncoder.encode("Prespecialized"));
    }

    @Test
    public void test2() {
        assertEquals("))))())))", DuplicateEncoder.encode("   ()(   "));
    }

    @Test
    public void test3() {
        assertEquals("(((", DuplicateEncoder.encode("din"));
    }

    @Test
    public void test4() {
        assertEquals("()()()", DuplicateEncoder.encode("recede"));
    }

    @Test
    public void test5() {
        assertEquals(")())())", DuplicateEncoder.encode("Success"));
    }

    @Test
    public void test6() {
        assertEquals("))((", DuplicateEncoder.encode("(( @"));
    }
}
