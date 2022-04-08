package lol.hub.codewars.valid_parentheses;

/**
 * @see <a href="https://www.codewars.com/kata/52774a314c2333f0a7000688">codewars.com</a>
 */
public class Solution {
    public static boolean validParentheses(String parens) {
        String s = parens.replaceAll("[^()]", "");
        return s.replaceAll("[^(]", "").length() == s.replaceAll("[^)]", "").length();
    }
}
