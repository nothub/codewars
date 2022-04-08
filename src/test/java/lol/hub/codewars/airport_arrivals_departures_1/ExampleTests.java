package lol.hub.codewars.airport_arrivals_departures_1;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ExampleTests {
    @Test
    public void test1() {
        // HELLO => WORLD!
        String[] initial = new String[]{"HELLO "};
        int[][] rotors = new int[][]{{15, 49, 50, 48, 43, 13}};
        assertArrayEquals(new String[]{"WORLD!"}, Dinglemouse.flapDisplay(initial, rotors));
    }

    @Test
    public void test2() {
        // CODE => WARS
        String[] initial = new String[]{"CODE"};
        int[][] rotors = new int[][]{{20, 20, 28, 0}};
        assertArrayEquals(new String[]{"WARS"}, Dinglemouse.flapDisplay(initial, rotors));
    }

    @Test
    public void test3() {
        // CAT => DOG
        String[] initial = new String[]{"CAT"};
        int[][] rotors = new int[][]{{1, 13, 27}};
        assertArrayEquals(new String[]{"DOG"}, Dinglemouse.flapDisplay(initial, rotors));
    }
}
