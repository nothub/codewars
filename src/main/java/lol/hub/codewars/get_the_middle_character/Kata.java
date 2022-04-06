package lol.hub.codewars.get_the_middle_character;

// https://www.codewars.com/kata/56747fd5cb988479af000028

class Kata {
    public static String getMiddle(String word) {
        int l = word.length();
        if (l % 2 == 1) return String.valueOf(word.charAt(l / 2));
        return String.valueOf(word.charAt((l / 2) - 1)) + word.charAt((l / 2));
    }
}
