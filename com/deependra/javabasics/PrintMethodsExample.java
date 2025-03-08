package com.deependra.javabasics;

public class PrintMethodsExample {
    public static void main(String[] args) {
        // Basic print methods
        System.out.println("Hello, World!"); // Prints with a new line
        System.out.print("This is print method."); // Prints without a new line
        System.out.println(" This continues on the same line.");

        // Using escape sequences
        System.out.println("Line 1\nLine 2\nLine 3"); // Newline
        System.out.println("Tab\tSeparated"); // Tab space
        System.out.println("Backslash: \\ and Double Quote: \"");

        // Using printf for formatted output
        int age = 25;
        double salary = 12345.6789;
        String name = "John";

        System.out.printf("Name: %s, Age: %d, Salary: %.2f%n", name, age, salary);

        // Formatting numbers
        double pi = Math.PI;
        System.out.printf("Pi to 3 decimal places: %.3f%n", pi);
        System.out.printf("Scientific notation: %e%n", pi);

        // Formatting numbers with padding
        int number = 123;
        System.out.printf("Number with padding: |%10d|%n", number);
        System.out.printf("Left-aligned padding: |%-10d|%n", number);

        // Formatting currency
        double amount = 9876.543;
        System.out.printf("Currency format: $%,.2f%n", amount);

        // Formatting booleans
        boolean flag = true;
        System.out.printf("Boolean value: %b%n", flag);

        // Using multiple placeholders
        System.out.printf("%-10s | %-5d | $%,10.2f%n", "Alice", 30, 45999.99);
        System.out.printf("%-10s | %-5d | $%,10.2f%n", "Bob", 28, 38000.75);
    }
}

// My Understanding and Key Points:
// 1. System.out.println() prints text and moves to the next line.
// 2. System.out.print() prints text without a newline.
// 3. Escape sequences like \n (new line) and \t (tab) help format output.
// 4. System.out.printf() allows formatted printing with placeholders (%s, %d, %.2f, etc.).
// 5. We can format numbers using %.xf (decimal places) and %e (scientific notation).
// 6. Padding can be used with %10d (right-aligned) and %-10d (left-aligned).
// 7. Currency formatting includes commas and decimal precision ($%,.2f).
// 8. Boolean values can be formatted using %b.
// 9. Multiple placeholders in printf can be used for structured output.


