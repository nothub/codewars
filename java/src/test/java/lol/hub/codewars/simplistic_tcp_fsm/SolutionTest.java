package lol.hub.codewars.simplistic_tcp_fsm;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test1() {
        assertEquals("CLOSE_WAIT", TCP.traverseStates(new String[]{"APP_ACTIVE_OPEN", "RCV_SYN_ACK", "RCV_FIN"}));
    }

    @Test
    public void test2() {
        assertEquals("ESTABLISHED", TCP.traverseStates(new String[]{"APP_PASSIVE_OPEN", "RCV_SYN", "RCV_ACK"}));
    }

    @Test
    public void test3() {
        assertEquals("LAST_ACK", TCP.traverseStates(new String[]{"APP_ACTIVE_OPEN", "RCV_SYN_ACK", "RCV_FIN", "APP_CLOSE"}));
    }

    @Test
    public void test4() {
        assertEquals("SYN_SENT", TCP.traverseStates(new String[]{"APP_ACTIVE_OPEN"}));
    }

    @Test
    public void test5() {
        assertEquals("ERROR", TCP.traverseStates(new String[]{"APP_PASSIVE_OPEN", "RCV_SYN", "RCV_ACK", "APP_CLOSE", "APP_SEND"}));
    }
}
