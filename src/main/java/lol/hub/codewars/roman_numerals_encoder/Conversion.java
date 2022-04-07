package lol.hub.codewars.roman_numerals_encoder;

import org.apache.commons.lang3.NotImplementedException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @see <a href="https://www.codewars.com/kata/51b62bf6a9c58071c600001b">codewars.com</a>
 */
public class Conversion {
    private final List<Map.Entry<Integer, String>> numerals;

    public Conversion() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        this.numerals = map.entrySet().stream()
            .sorted(Map.Entry.<Integer, String>comparingByValue().reversed())
            .collect(Collectors.toUnmodifiableList());
    }

    public String solution(int n) {
        throw new NotImplementedException("Not done yet!");
/*        StringBuilder roman = new StringBuilder();
        for (Map.Entry<Integer, String> pair : numerals) {
            if (n >= pair.getKey()) {
                roman.append(pair.getValue());
                n = n - pair.getKey();
            }
        }
        return roman.toString();*/
    }
}
