package lol.hub.codewars;

public class DnaStrand {
    public static String makeComplement(String dna) {
        char[] original = dna.toCharArray();
        char[] complement = new char[dna.length()];
        for (int i = 0; i < original.length; i++) {
            switch (original[i]) {
                case 'A':
                    complement[i] = 'T';
                    break;
                case 'T':
                    complement[i] = 'A';
                    break;
                case 'C':
                    complement[i] = 'G';
                    break;
                case 'G':
                    complement[i] = 'C';
                    break;
                default:
                    throw new IllegalArgumentException("Unknown symbols: " + original[i]);
            }
        }
        return new String(complement);
    }
}
