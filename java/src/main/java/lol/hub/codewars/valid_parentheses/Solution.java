package lol.hub.codewars.valid_parentheses;

/**
 * @see <a href="https://www.codewars.com/kata/52774a314c2333f0a7000688">codewars.com</a>
 */
public class Solution {
    public static boolean validParentheses(String parens) {
        int level = 0;
        for (char c : parens.replaceAll("[^()]", "").toCharArray()) {
            if (c == '(') level++;
            else if (c == ')') level--;
            if (level < 0) return false;
        }
        return level == 0;
    }
}
