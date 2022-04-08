package lol.hub.codewars.decode_the_morse_code;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://www.codewars.com/kata/54b724efac3d5402db00065e">codewars.com</a>
 */
public class MorseCodeDecoder {
    public static String decode(String morseCode) {
        List<String> words = List.of(morseCode.split("   "));
        List<String> wordsTranslated = new ArrayList<>();
        for (String word : words) {
            List<String> codes = List.of(word.split(" "));
            String wordTranslated = "";
            for (String code : codes) {
                wordTranslated = wordTranslated + MorseCode.get(code);
            }
            wordsTranslated.add(wordTranslated);
        }
        return String.join(" ", wordsTranslated);
    }
}
