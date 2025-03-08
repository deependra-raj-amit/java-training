package com.deependra.javabasics;

import java.util.Scanner;

public class FactorialExample {
    // Recursive method to calculate factorial
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1; // Base case: Factorial of 0 and 1 is 1
        }
        return n * factorial(n - 1); // Recursive call
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to find its factorial: ");
        int number = scanner.nextInt();

        // Calling the recursive function
        int result = factorial(number);

        System.out.println("Factorial of " + number + " is: " + result);

        scanner.close();
    }
}
