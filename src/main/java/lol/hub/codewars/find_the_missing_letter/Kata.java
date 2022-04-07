package lol.hub.codewars.find_the_missing_letter;

/**
 * @see <a href="https://www.codewars.com/kata/5839edaa6754d6fec10000a2">codewars.com</a>
 */
public class Kata {
    public static char findMissingLetter(char[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i + 1] - array[i] > 1) return (char) (array[i] + 1);
        }
        throw new IllegalStateException();
    }
}
