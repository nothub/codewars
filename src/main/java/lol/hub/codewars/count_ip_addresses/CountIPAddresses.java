package lol.hub.codewars.count_ip_addresses;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @see <a href="https://www.codewars.com/kata/526989a41034285187000de4">codewars.com</a>
 */
public class CountIPAddresses {
    public static long ipsBetween(String start, String end) {
        return count(end) - count(start);
    }

    private static long count(String start) {
        AtomicLong size = new AtomicLong();
        Arrays.stream(start.split("\\."))
            .mapToInt(Integer::parseInt)
            .forEach(i -> size.set(size.get() * 256 + i));
        return size.get();
    }
}
