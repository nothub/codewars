package lol.hub.codewars.duplicate_encoder;

/**
 * @see <a href="https://www.codewars.com/kata/54b42f9314d9229fd6000d9c">codewars.com</a>
 */
public class DuplicateEncoder {
    static String encode(String word) {
        word = word.toLowerCase();
        StringBuilder out = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (hasMultiple(word, c)) {
                out.append(")");
            } else {
                out.append("(");
            }
        }
        return out.toString();
    }

    private static boolean hasMultiple(String word, char ch) {
        int count = 0;
        for (char c : word.toCharArray()) {
            if (c == ch) count++;
        }
        return count > 1;
    }
}
