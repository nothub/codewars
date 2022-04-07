package lol.hub.codewars.detect_pangram;

/**
 * @see <a href="https://www.codewars.com/kata/545cedaa9943f7fe7b000048">codewars.com</a>
 */
public class PangramChecker {
    public boolean check(String sentence) {
        return sentence.toLowerCase().replaceAll("[^a-z]", "").chars().distinct().count() >= 26;
    }
}
