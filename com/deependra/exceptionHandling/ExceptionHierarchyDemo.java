package com.deependra.exceptionHandling;

// Exception Hierarchy Demonstration
// 1. Throwable: The root class of all exceptions and errors.
// 2. Exception: Handles expected issues in the program (Checked and Unchecked exceptions).
// 3. RuntimeException (Unchecked): Occurs at runtime (e.g., ArithmeticException, NullPointerException).
// 4. Checked Exceptions: Must be handled at compile-time (e.g., IOException, InterruptedException).
// 5. Error: Represents system-level issues that cannot be handled (e.g., OutOfMemoryError).

public class ExceptionHierarchyDemo {
    public static void main(String[] args) {
        System.out.println("------ Demonstrating Exception Hierarchy in Java ------");

        // 1. Unchecked Exception - ArithmeticException
        try {
            System.out.println("\n[1] Unchecked Exception: ArithmeticException");
            int result = 10 / 0; // Division by zero
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println(">> Caught ArithmeticException: " + e.getMessage());
        }

        // 2. Unchecked Exception - NullPointerException
        try {
            System.out.println("\n[2] Unchecked Exception: NullPointerException");
            String text = null;
            System.out.println(text.length()); // Accessing length of null
        } catch (NullPointerException e) {
            System.out.println(">> Caught NullPointerException: " + e.getMessage());
        }

        // 3. Checked Exception - InterruptedException
        try {
            System.out.println("\n[3] Checked Exception: InterruptedException");
            Thread.sleep(1000); // Must be handled or declared with 'throws'
            System.out.println("Thread resumed after sleep.");
        } catch (InterruptedException e) {
            System.out.println(">> Caught InterruptedException: " + e.getMessage());
        }

        // 4. Checked Exception - FileNotFoundException (Requires explicit handling)
        try {
            System.out.println("\n[4] Checked Exception: FileNotFoundException");
            throw new java.io.FileNotFoundException("File not found on the system.");
        } catch (java.io.FileNotFoundException e) {
            System.out.println(">> Caught FileNotFoundException: " + e.getMessage());
        }


    }
}

