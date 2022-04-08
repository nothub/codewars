package lol.hub.codewars.break_camel_case;

/**
 * @see <a href="https://www.codewars.com/kata/5208f99aee097e6552000148">codewars.com</a>
 */
class Solution {
    public static String camelCase(String input) {
        return input.replaceAll("([a-z])([A-Z])", "$1 $2");
    }
}
