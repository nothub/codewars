package lol.hub.codewars.java_functional_programming_part_4_row_row_row_your_boat_gently_down_the_dot_dot_dot;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

/**
 * @see <a href="https://www.codewars.com/kata/54ac045d35adf4e6e2000e43">codewars.com</a>
 */
public class DragonsCurve {

    private final Function<String, String> clean = x -> x.chars()
        .filter(createFilter('a', false))
        .filter(createFilter('b', false))
        .mapToObj(c -> String.valueOf((char) c))
        .collect(Collectors.joining());

    public IntFunction<String> mapFunction = c -> {
        if (c == 'a') return "aRbFR";
        if (c == 'b') return "LFaLb";
        return String.valueOf((char) c);
    };

    private final BiFunction<String, Integer, String> generateCurve = (s, n) -> {
        while (n > 0) {
            s = s.chars()
                .mapToObj(c -> mapFunction.apply(c))
                .collect(Collectors.joining());
            n--;
        }
        return clean.apply(s);
    };

    public String createCurve(int n) {
        return generateCurve.apply("Fa", n);
    }

    public long howMany(char c, String curve) {
        return curve.chars().filter(createFilter(c, true)).count();
    }

    public IntPredicate createFilter(char filterWhat, boolean keep) {
        return keep ? (i -> i == filterWhat) : (i -> i != filterWhat);
    }
}
