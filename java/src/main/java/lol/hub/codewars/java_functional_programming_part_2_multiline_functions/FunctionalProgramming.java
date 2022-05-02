package lol.hub.codewars.java_functional_programming_part_2_multiline_functions;

import java.util.function.ToDoubleFunction;

/**
 * @see <a href="https://www.codewars.com/kata/54a6c6e7478d8ee02d000cd9">codewars.com</a>
 */
public class FunctionalProgramming {
    public static ToDoubleFunction<Triangle> f = t -> {
        t.setArea(t.base * t.height * 0.5);
        return t.getArea();
    };
}
