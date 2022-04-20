package lol.hub.codewars.string_n_iterations_string;

import org.apache.commons.lang3.time.StopWatch;

/**
 * @see <a href="https://www.codewars.com/kata/5ae43ed6252e666a6b0000a4">codewars.com</a>
 */
public class JomoPipi {
    public static String jumbledString(String s, long n) {
        StopWatch sw = new StopWatch();
        sw.start();
        String init = s;
        System.out.println("input=" + s);
        System.out.println("iters=" + n);
        long distance = -1;
        for (long i = 1; i <= n; i++) {
            s = shift(s);
            if (s.equals(init)) {
                if (distance == -1) {
                    distance = n % i;
                } else {
                    // shift by (n mod offset) + distance
                    System.out.println("Skipping " + (n - i - distance) + " steps");
                    for (int j = 0; j < distance; j++) {
                        s = shift(s);
                    }
                    break;
                }
            }
        }
        sw.stop();
        System.out.println("speed=" + sw.getTime() + "ms");
        return s;
    }

    private static String shift(String s) {
        char[] array = s.toCharArray();
        char[] shifted = new char[array.length];
        int front = 0;
        int back = Math.round(array.length / 2f);
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                shifted[front] = array[i];
                front++;
            } else {
                shifted[back] = array[i];
                back++;
            }
        }
        return new String(shifted);
    }
}
