package com.deependra.exceptionHandling;

// try-with-resources Demonstration
// 1. try-with-resources: A try block that automatically closes resources when execution completes.
// 2. Purpose: Ensures efficient resource management (e.g., closing files, database connections).
// 3. Why use it?
//    - Prevents memory leaks by closing resources automatically.
//    - Avoids the need for an explicit finally block to close resources.
// 4. Real-Life Use Case: Used for file handling, database connections, and network streams.


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesDemo {
    public static void main(String[] args) {
        System.out.println("------ Demonstrating try-with-resources in Java ------");

        // Using try-with-resources to handle file reading
        try (BufferedReader reader = new BufferedReader(new FileReader("sample.txt"))) {
            System.out.println("\nReading File Contents...");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(">> Caught Exception: " + e.getMessage());
        }


    }
}
