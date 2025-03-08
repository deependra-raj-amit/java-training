package com.deependra.javabasics;

import java.util.Scanner;

public class LogicalOperators {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User Authentication with Age Verification
        String storedUsername = "admin";
        String storedPassword = "secure123";

        System.out.print("Enter Username: ");
        String inputUsername = scanner.next();
        System.out.print("Enter Password: ");
        String inputPassword = scanner.next();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();

        // Using Logical AND (&&) and Logical OR (||)
        if (inputUsername.equals(storedUsername) && inputPassword.equals(storedPassword)) {
            if (age >= 18 && age <= 60) {
                System.out.println("Login successful! You are within the eligible age range.");
            } else {
                System.out.println("Login successful! But you are not in the eligible age range.");
            }
        } else {
            System.out.println("Invalid username or password. Access denied.");
        }

        scanner.close();
    }
}
