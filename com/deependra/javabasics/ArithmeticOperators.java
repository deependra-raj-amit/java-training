package com.deependra.javabasics;

import java.util.Scanner;

public class ArithmeticOperators {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Compound Interest Calculation: A = P(1 + r/n)^(nt)
        System.out.println("Enter Principal amount: ");
        double principal = scanner.nextDouble();
        System.out.println("Enter Annual Interest Rate (in %): ");
        double rate = scanner.nextDouble() / 100;
        System.out.println("Enter Time (in years): ");
        double time = scanner.nextDouble();
        System.out.println("Enter Number of times interest applied per year: ");
        int n = scanner.nextInt();

        double amount = principal * Math.pow((1 + rate / n), (n * time));
        System.out.println("Compound Interest Amount: " + amount);

        // Matrix Addition
        int[][] matrix1 = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
        int[][] matrix2 = { {9, 8, 7}, {6, 5, 4}, {3, 2, 1} };
        int[][] sumMatrix = new int[3][3];

        System.out.println("Matrix Addition Result:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j]; // '+' operator used
                System.out.print(sumMatrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
