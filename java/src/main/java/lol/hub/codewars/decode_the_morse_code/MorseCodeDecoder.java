package lol.hub.codewars.decode_the_morse_code;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @see <a href="https://www.codewars.com/kata/54b724efac3d5402db00065e">codewars.com</a>
 */
public class MorseCodeDecoder {
    public static String decode(String morseCode) {
        return Stream.of(morseCode.strip().split("   "))
            .map(word -> Stream.of(word.split(" "))
                .map(MorseCode::get)
                .map(String::valueOf)
                .collect(Collectors.joining()))
            .collect(Collectors.joining(" "));
    }
}
