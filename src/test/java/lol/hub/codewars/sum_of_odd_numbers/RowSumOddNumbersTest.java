package lol.hub.codewars.sum_of_odd_numbers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RowSumOddNumbersTest {
    @Test
    public void test1() {
        assertEquals(1, RowSumOddNumbers.rowSumOddNumbers(1));
    }

    @Test
    public void test2() {
        assertEquals(74088, RowSumOddNumbers.rowSumOddNumbers(42));
    }

    @Test
    public void test3() {
        assertEquals(125, RowSumOddNumbers.rowSumOddNumbers(5));
    }
}
