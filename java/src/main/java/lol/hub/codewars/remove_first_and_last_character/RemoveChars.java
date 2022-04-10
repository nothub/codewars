package lol.hub.codewars.remove_first_and_last_character;

/**
 * @see <a href="https://www.codewars.com/kata/56bc28ad5bdaeb48760009b0">codewars.com</a>
 */
public class RemoveChars {
    public static String remove(String str) {
        return str.replaceFirst(".(.+).", "$1");
    }
}
