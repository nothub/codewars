package lol.hub.codewars.your_order_please;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Order {
    public static String order(String words) {
        List<String> input = new ArrayList<>(List.of(words.split(" ")));
        input.sort(Comparator.comparingInt(o -> Integer.parseInt(o.replaceAll("\\D", ""))));
        return String.join(" ", input);
    }
}
