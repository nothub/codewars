package lol.hub.codewars.string_n_iterations_string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void fixed1() {
        String s = "Such Wow!", a = "Sc o!uhWw";
        assertEquals(a, JomoPipi.jumbledString(s, 25));
    }

    @Test
    public void fixed2() {
        String s = "better example", a = "bexltept merae";
        assertEquals(a, JomoPipi.jumbledString(s, 2));
    }

    @Test
    public void fixed3() {
        String s = "Greetings", a = "Gtsegenri";
        assertEquals(a, JomoPipi.jumbledString(s, 8));
    }

    @Test
    public void python() {
        String s = "qwertyuio", a = "qtorieuwy";
        assertEquals(a, JomoPipi.jumbledString(s, 2));
    }

    @Test
    public void extended1() {
        String s = "I like it!", a = "Iiei t kl!";
        assertEquals(a, JomoPipi.jumbledString(s, 1234));
    }
}
