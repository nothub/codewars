package lol.hub.codewars.which_are_in;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class WhichAreInTest {
    @Test
    public void test1() {
        String[] a = new String[]{"arp", "live", "strong"};
        String[] b = new String[]{"lively", "alive", "harp", "sharp", "armstrong"};
        String[] r = new String[]{"arp", "live", "strong"};
        assertArrayEquals(r, WhichAreIn.inArray(a, b));
    }

    @Test
    public void test2() {
        String[] a = new String[]{"live", "arp", "strong"};
        String[] b = new String[]{"harp", "sharp", "lively", "alive", "armstrong"};
        String[] r = new String[]{"arp", "live", "strong"};
        assertArrayEquals(r, WhichAreIn.inArray(a, b));
    }
}
