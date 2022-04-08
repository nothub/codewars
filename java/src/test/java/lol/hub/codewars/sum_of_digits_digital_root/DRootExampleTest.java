package lol.hub.codewars.sum_of_digits_digital_root;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DRootExampleTest {
    @Test
    public void Test1() {
        assertEquals("Nope!", 7, DRoot.digital_root(16));
    }

    @Test
    public void Test2() {
        assertEquals("Nope!", 6, DRoot.digital_root(456));
    }
}
