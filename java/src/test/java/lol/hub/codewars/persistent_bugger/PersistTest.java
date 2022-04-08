package lol.hub.codewars.persistent_bugger;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersistTest {
    @Test
    public void test1() {
        assertEquals(3, Persist.persistence(39));
    }

    @Test
    public void test2() {
        assertEquals(0, Persist.persistence(4));
    }

    @Test
    public void test3() {
        assertEquals(2, Persist.persistence(25));
    }

    @Test
    public void test4() {
        assertEquals(4, Persist.persistence(999));
    }
}
