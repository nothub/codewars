package lol.hub.codewars.break_camel_case;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void tests0() {
        assertEquals("Incorrect", "camel Casing", Solution.camelCase("camelCasing"));
    }

    @Test
    public void tests1() {
        assertEquals("Incorrect", "camel Casing Test", Solution.camelCase("camelCasingTest"));
    }

    @Test
    public void tests2() {
        assertEquals("Incorrect", "camelcasingtest", Solution.camelCase("camelcasingtest"));
    }
}
