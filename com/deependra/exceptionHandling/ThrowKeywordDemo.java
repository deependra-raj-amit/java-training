package com.deependra.exceptionHandling;

// Throw Keyword Demonstration
// 1. throw Keyword: Used to explicitly throw an exception in Java.
// 2. Purpose: Helps in custom exception handling and stopping execution when an error occurs.
// 3. Difference from throws: 'throw' is used to generate an exception, while 'throws' declares possible exceptions.
// 4. Real-Life Use Case: Used for validating conditions (e.g., ATM withdrawal, age verification).


import java.util.Scanner;

// Custom exception for invalid age
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class AgeValidator {
    // Method to validate age for driving license
    public void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            // Throwing a custom exception
            throw new InvalidAgeException("Error: Age must be 18 or above to apply for a driving license.");
        } else {
            System.out.println("✅ Age verified. You are eligible for a driving license.");
        }
    }
}

public class ThrowKeywordDemo {
    public static void main(String[] args) {
        System.out.println("------ Demonstrating throw Keyword in Java ------");

        // Taking user input for age validation
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter your age: ");
        int age = scanner.nextInt();

        // Creating an instance of AgeValidator
        AgeValidator validator = new AgeValidator();

        // Handling exception
        try {
            validator.checkAge(age);
        } catch (InvalidAgeException e) {
            System.out.println(">> Caught Exception: " + e.getMessage());
        }


        scanner.close();
    }
}

