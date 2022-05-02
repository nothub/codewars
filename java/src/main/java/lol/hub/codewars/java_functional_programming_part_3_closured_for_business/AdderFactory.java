package lol.hub.codewars.java_functional_programming_part_3_closured_for_business;

import java.util.function.IntUnaryOperator;

/**
 * @see <a href="https://www.codewars.com/kata/54a6d39a478d8e07e4000b69">codewars.com</a>
 */
public class AdderFactory {
    public static IntUnaryOperator create(int addTo) { return n -> n + addTo; }
}
