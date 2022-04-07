package lol.hub.codewars.count_ip_addresses;

import java.util.Arrays;

/**
 * @see <a href="https://www.codewars.com/kata/526989a41034285187000de4">codewars.com</a>
 */
public class CountIPAddresses {
    public static long ipsBetween(String start, String end) {
        int[] a = Arrays.stream(start.split("\\.")).mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.stream(end.split("\\.")).mapToInt(Integer::parseInt).toArray();
        long distance = 0L;
        distance = distance + ((b[0] - a[0]) * 256L * 256L * 256L);
        distance = distance + ((b[1] - a[1]) * 256L * 256L);
        distance = distance + ((b[2] - a[2]) * 256L);
        distance = distance + ((b[3] - a[3]));
        return distance;
    }
}
