package lol.hub.codewars.your_order_please;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @see <a href="https://www.codewars.com/kata/55c45be3b2079eccff00010f">codewars.com</a>
 */
public class Order {
    public static String order(String words) {
        List<String> input = new ArrayList<>(List.of(words.split(" ")));
        input.sort(Comparator.comparingInt(o -> Integer.parseInt(o.replaceAll("\\D", ""))));
        return String.join(" ", input);
    }
}
