package lol.hub.codewars.human_readable_time;

/**
 * @see <a href="https://www.codewars.com/kata/52685f7382004e774f0001f7">codewars.com</a>
 */
public class HumanReadableTime {
    private static final int SECOND = 1;
    private static final int MINUTE = 60 * SECOND;
    private static final int HOUR = 60 * MINUTE;
    public static final int MAX_SECONDS = 59 * SECOND + 59 * MINUTE + 99 * HOUR;

    public static String makeReadable(int seconds) {
        if (seconds > MAX_SECONDS) seconds = MAX_SECONDS;
        int h = seconds / HOUR;
        int m = seconds % HOUR / MINUTE;
        int s = seconds % MINUTE / SECOND;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}
