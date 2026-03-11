package com.github.sidimekov;

import com.github.sidimekov.task1.CosSeries;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        // task 1
        double x = Math.PI / 3;
        int n = 3;
        double resultCos = CosSeries.calculate(x, n);
        System.out.printf("cos(%.2f), n = %d: %.4f", x, n, resultCos);
    }
}