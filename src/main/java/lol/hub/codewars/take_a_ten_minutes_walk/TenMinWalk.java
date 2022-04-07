package lol.hub.codewars.take_a_ten_minutes_walk;

public class TenMinWalk {
    public static boolean isValid(char[] walk) {
        if (walk.length != 10) return false;
        int x = 0;
        int z = 0;
        for (char direction : walk) {
            if (direction == 'n') {
                x = x + 1;
            } else if (direction == 's') {
                x = x - 1;
            } else if (direction == 'e') {
                z = z + 1;
            } else if (direction == 'w') {
                z = z - 1;
            }
        }
        return x == 0 && z == 0;
    }
}
