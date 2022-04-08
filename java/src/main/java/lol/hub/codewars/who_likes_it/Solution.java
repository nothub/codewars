package lol.hub.codewars.who_likes_it;

import java.util.Arrays;

/**
 * @see <a href="https://www.codewars.com/kata/5266876b8f4bf2da9b000362">codewars.com</a>
 */
class Solution {
    public static String whoLikesIt(String... names) {
        if (names.length == 0) {
            return "no one likes this";
        } else if (names.length == 1) {
            return names[0] + " likes this";
        } else if (names.length < 4) {
            return (names.length > 2 ?
                String.join(", ", Arrays.copyOfRange(names, 0, names.length - 2)) + ", " : "") +
                String.join(" and ", Arrays.copyOfRange(names, names.length - 2, names.length)) + " like this";
        }
        return names[0] + ", " + names[1] + " and " + (names.length - 2) + " others like this";
    }
}
