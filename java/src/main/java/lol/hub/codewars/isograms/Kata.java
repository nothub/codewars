package lol.hub.codewars.isograms;

import java.util.stream.Collectors;

/**
 * @see <a href="https://www.codewars.com/kata/54ba84be607a92aa900000f1">codewars.com</a>
 */

public class Kata {
    public static boolean isIsogram(String str) {
        if (str.isEmpty()) return true;
        return str.length() <= str.toLowerCase().chars().boxed().collect(Collectors.toSet()).size();
    }
}
