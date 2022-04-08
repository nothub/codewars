package lol.hub.codewars.single_word_pig_latin;

import java.util.Set;

/**
 * @see <a href="https://www.codewars.com/kata/558878ab7591c911a4000007">codewars.com</a>
 */
public class PigLatin {
    private static final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

    public String translate(String str) {
        // If the input string has any non-alpha characters, the function must return None, null, Nothing (depending on the language).
        for (char c : str.toCharArray()) {
            if (!Character.isAlphabetic(c)) return null;
        }

        // The result must be lowercase, regardless of the case of the input.
        str = str.toLowerCase();

        // The input string has no vowels -> return the original string plus "ay".
        boolean hasVowels = false;
        for (Character vowel : vowels) {
            if (str.contains(String.valueOf(vowel))) {
                hasVowels = true;
                break;
            }
        }
        if (!hasVowels) return str + "ay";

        // The word starts with a vowel(a,e,i,o,u) -> return the original string plus "way".
        if (vowels.contains(str.charAt(0))) return str + "way";

        // The word starts with a consonant -> move consonants from the beginning of the word to the end of the word until the first vowel, then return it plus "ay".
        while (!vowels.contains(str.charAt(0))) {
            str = str.substring(1) + str.charAt(0);
        }
        return str + "ay";
    }
}
