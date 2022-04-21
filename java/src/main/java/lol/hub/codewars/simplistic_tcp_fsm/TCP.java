package lol.hub.codewars.simplistic_tcp_fsm;

import java.util.Map;

import static java.util.Map.entry;

/**
 * @see <a href="https://www.codewars.com/kata/54acc128329e634e9a000362">codewars.com</a>
 */
public class TCP {
    private static final Map<String, String> transitions = Map.ofEntries(
        entry("CLOSED" + "APP_PASSIVE_OPEN", "LISTEN"),
        entry("CLOSED" + "APP_ACTIVE_OPEN", "SYN_SENT"),
        entry("LISTEN" + "RCV_SYN", "SYN_RCVD"),
        entry("LISTEN" + "APP_SEND", "SYN_SENT"),
        entry("LISTEN" + "APP_CLOSE", "CLOSED"),
        entry("SYN_RCVD" + "APP_CLOSE", "FIN_WAIT_1"),
        entry("SYN_RCVD" + "RCV_ACK", "ESTABLISHED"),
        entry("SYN_SENT" + "RCV_SYN", "SYN_RCVD"),
        entry("SYN_SENT" + "RCV_SYN_ACK", "ESTABLISHED"),
        entry("SYN_SENT" + "APP_CLOSE", "CLOSED"),
        entry("ESTABLISHED" + "APP_CLOSE", "FIN_WAIT_1"),
        entry("ESTABLISHED" + "RCV_FIN", "CLOSE_WAIT"),
        entry("FIN_WAIT_1" + "RCV_FIN", "CLOSING"),
        entry("FIN_WAIT_1" + "RCV_FIN_ACK", "TIME_WAIT"),
        entry("FIN_WAIT_1" + "RCV_ACK", "FIN_WAIT_2"),
        entry("CLOSING" + "RCV_ACK", "TIME_WAIT"),
        entry("FIN_WAIT_2" + "RCV_FIN", "TIME_WAIT"),
        entry("TIME_WAIT" + "APP_TIMEOUT", "CLOSED"),
        entry("CLOSE_WAIT" + "APP_CLOSE", "LAST_ACK"),
        entry("LAST_ACK" + "RCV_ACK", "CLOSED"));

    public static String traverseStates(String[] events) {
        String state = "CLOSED"; // initial state
        for (String event : events) {
            state = transitions.get(state + event);
            if (state == null) return "ERROR";
        }
        return state;
    }
}
