package lol.hub.codewars.human_readable_time;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExampleTest {
    @Test
    public void test1() {
        assertEquals("00:00:00", HumanReadableTime.makeReadable(0));
    }

    @Test
    public void test2() {
        assertEquals("00:00:05", HumanReadableTime.makeReadable(5));
    }

    @Test
    public void test3() {
        assertEquals("00:01:00", HumanReadableTime.makeReadable(60));
    }

    @Test
    public void test4() {
        assertEquals("23:59:59", HumanReadableTime.makeReadable(86399));
    }

    @Test
    public void test5() {
        assertEquals("99:59:59", HumanReadableTime.makeReadable(359999));
    }
}
