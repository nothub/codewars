package lol.hub.codewars.java_functional_programming_part_3_closured_for_business;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdderFactoryTest {
    @Test
    public void testMakeFunction() throws Exception {
        assertEquals("Created add 1 function; gave it 4; did not get 5 back",
            5, AdderFactory.create(1).applyAsInt(4));
    }
}
