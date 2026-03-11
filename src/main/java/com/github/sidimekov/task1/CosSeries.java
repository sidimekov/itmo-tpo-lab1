package com.github.sidimekov.task1;

public class CosSeries {
    private static double factorial(int x) {
        if (x < 0) throw new IllegalArgumentException("x < 0 нельзя");
        double result = 1.0;
        for (int i = 2; i <= x; i++) {
            result *= i;
        }
        return result;
    }

    public static double calculate(double x, int n) {
        if (n <= 0) throw new IllegalArgumentException("n должен быть положительным");
        double result = 1.0;
        for (int k = 1; k < n; k++) {
            int sign = k % 2 == 0 ? 1 : -1;
            result += sign * Math.pow(x, 2 * k) / factorial(2 * k);
        }
        return result;
    }
}
