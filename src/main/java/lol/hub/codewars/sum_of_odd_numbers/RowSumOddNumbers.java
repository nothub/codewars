package lol.hub.codewars.sum_of_odd_numbers;

public class RowSumOddNumbers {
    public static int rowSumOddNumbers(int n) {
        int num = 1;
        for (int row = 1; row <= n; row++) {
            int sum = 0;
            for (int j = 1; j <= row; j++) {
                sum = sum + num;
                num = num + 2;
            }
            if (row == n) return sum;
        }
        throw new IllegalStateException();
    }
}
