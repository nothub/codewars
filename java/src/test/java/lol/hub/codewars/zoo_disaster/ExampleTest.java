package lol.hub.codewars.zoo_disaster;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class ExampleTest {

    @Test
    public void example() {
        final String input = "fox,bug,chicken,grass,sheep";
        final String[] expected = {
            "fox,bug,chicken,grass,sheep",
            "chicken eats bug",
            "fox eats chicken",
            "sheep eats grass",
            "fox eats sheep",
            "fox"};
        String[] actual = Dinglemouse.whoEatsWho(input);
        System.out.println("expected: " + Arrays.toString(expected));
        System.out.println("actual:   " + Arrays.toString(actual));
        assertArrayEquals(expected, actual);
    }

}
