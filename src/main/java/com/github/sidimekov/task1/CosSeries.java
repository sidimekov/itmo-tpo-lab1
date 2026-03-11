package com.github.sidimekov.task1;

public class CosSeries {
    private static long factorial(int x) {
        return x == 1 ? 1 : x * factorial(x - 1);
    }

    public static double calculate(double x, int n) {
        double result = 1;
        for (int k = 1; k < n; k++) {
            int sign = k % 2 == 0 ? 1 : -1;
            result += sign * Math.pow(x, 2 * k) / factorial(2 * k);
        }
        return result;
    }
}
