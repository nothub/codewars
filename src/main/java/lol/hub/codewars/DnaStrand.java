package lol.hub.codewars;

import java.util.Map;

public class DnaStrand {
    private static final Map<Character, Character> complements = Map.of(
        'A', 'T',
        'T', 'A',
        'C', 'G',
        'G', 'C'
    );

    public static String makeComplement(String dna) {
        char[] original = dna.toCharArray();
        char[] complement = new char[dna.length()];
        for (int i = 0; i < original.length; i++) {
            complement[i] = complements.get(original[i]);
        }
        return new String(complement);
    }
}
