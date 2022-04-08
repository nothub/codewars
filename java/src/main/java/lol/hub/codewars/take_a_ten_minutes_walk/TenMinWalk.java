package lol.hub.codewars.take_a_ten_minutes_walk;

public class TenMinWalk {
    public static boolean isValid(char[] walk) {
        if (walk.length != 10) return false;
        int x = 0;
        int y = 0;
        for (char direction : walk) {
            if (direction == 'n') {
                x++;
            } else if (direction == 's') {
                x--;
            } else if (direction == 'e') {
                y++;
            } else if (direction == 'w') {
                y--;
            } else {
                throw new IllegalArgumentException();
            }
        }
        return x == 0 && y == 0;
    }
}
