package lol.hub.codewars;

import java.util.Map;
import java.util.stream.Collectors;

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
