package lol.hub.codewars.convert_string_to_camel_case;

/**
 * @see <a href="https://www.codewars.com/kata/517abf86da9663f1d2000003">codewars.com</a>
 */
class Solution {
    static String toCamelCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.charAt(i);
            if (c == '_' || c == '-') {
                if (i + 1 < s.length()) {
                    char n = s.charAt(i + 1);
                    sb.append(Character.toUpperCase(n));
                    i++;
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
