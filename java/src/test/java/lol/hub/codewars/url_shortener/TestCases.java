package lol.hub.codewars.url_shortener;

import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCases {
    Shortener shortener = new Shortener();

    private static boolean testFormat(String string) {
        return Pattern.matches("^short.ly\\/[a-z]{1,4}$", string);
    }

    @Test
    public void test_two_different_URLs() {
        String shortURL1 = shortener.urlShortener("https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c3e");
        assertTrue("Wrong string format!", testFormat(shortURL1));
        String shortURL2 = shortener.urlShortener("https://www.codewars.com/kata/5efae11e2d12df00331f91a6");
        assertTrue("Wrong string format!", testFormat(shortURL2));
        assertEquals("https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c3e", shortener.urlRedirector(shortURL1));
        assertEquals("https://www.codewars.com/kata/5efae11e2d12df00331f91a6", shortener.urlRedirector(shortURL2));
    }

    @Test
    public void test_same_URLs() {
        String shortURL1 = shortener.urlShortener("https://www.codewars.com/kata/5ef9c85dc41b4e000f9a645f");
        assertTrue("Wrong string format!", testFormat(shortURL1));
        String shortURL2 = shortener.urlShortener("https://www.codewars.com/kata/5ef9c85dc41b4e000f9a645f");
        assertTrue("Wrong string format!", testFormat(shortURL2));
        assertEquals("Should work with same URLs", shortURL1, shortURL2);
        assertEquals("https://www.codewars.com/kata/5ef9c85dc41b4e000f9a645f", shortener.urlRedirector(shortURL1));
    }
}

