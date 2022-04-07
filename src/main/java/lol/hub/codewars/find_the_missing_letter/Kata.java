package lol.hub.codewars.find_the_missing_letter;

public class Kata {
    public static char findMissingLetter(char[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i + 1] - array[i] > 1) return (char) (array[i] + 1);
        }
        throw new IllegalStateException();
    }
}
