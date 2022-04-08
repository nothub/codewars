package lol.hub.codewars.find_the_unique_number;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindUniqTest {
    private final double precision = 0.0000000000001;

    @Test
    public void sampleTestCases() {
        assertEquals(1.0, Kata.findUniq(new double[]{0, 1, 0}), precision);
        assertEquals(2.0, Kata.findUniq(new double[]{1, 1, 1, 2, 1, 1}), precision);
    }
}
