package lol.hub.codewars.multiples_of_3_or_5;

import java.util.stream.IntStream;

/**
 * @see <a href="https://www.codewars.com/kata/514b92a657cdc65150000006">codewars.com</a>
 */
public class Solution {
    public int solution(int number) {
        return IntStream.range(1, number).filter(i -> i % 3 == 0 || i % 5 == 0).sum();
    }
}
