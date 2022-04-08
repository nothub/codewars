package lol.hub.codewars.airport_arrivals_departures_1;

/**
 * @see <a href="https://www.codewars.com/kata/57feb00f08d102352400026e">codewars.com</a>
 */
class Dinglemouse {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ?!@#&()|<>.:=-+*/0123456789";

    public static String[] flapDisplay(final String[] lines, final int[][] rotors) {
        String[] result = new String[lines.length];
        for (int i = 0; i < lines.length; i++) {
            result[i] = flap(lines[i], rotors[i]);
        }
        return result;
    }

    private static String flap(String line, int[] rotor) {
        if (line.length() != rotor.length) throw new IllegalArgumentException();
        StringBuilder sb = new StringBuilder();
        int distance = 0;
        for (int i = 0; i < rotor.length; i++) {
            distance = distance + rotor[i];
            sb.append(ALPHABET.charAt((ALPHABET.indexOf(line.charAt(i)) + distance) % ALPHABET.length()));
        }
        return sb.toString();
    }
}
