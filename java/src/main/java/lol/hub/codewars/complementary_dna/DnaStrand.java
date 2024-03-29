package lol.hub.codewars.complementary_dna;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @see <a href="https://www.codewars.com/kata/554e4a2f232cdd87d9000038">codewars.com</a>
 */
public class DnaStrand {
    private static final Map<Integer, String> complements = Map.of(
        (int) 'A', "T",
        (int) 'T', "A",
        (int) 'C', "G",
        (int) 'G', "C"
    );

    public static String makeComplement(String dna) {
        return dna.chars()
            .mapToObj(complements::get)
            .collect(Collectors.joining());
    }
}
