package com.deependra.exceptionHandling;

// Throws Keyword Demonstration
// 1. throws Keyword: Used in method declaration to indicate that a method may throw exceptions.
// 2. Purpose: Allows exception handling to be delegated to the caller rather than handling it inside the method.
// 3. Checked Exceptions: Must be declared using 'throws' (e.g., IOException, InterruptedException).
// 4. Real-Life Use Case: Helps in propagating exceptions in multi-layered applications (e.g., file handling, databases).


import java.io.IOException;

// Class simulating a real-world scenario: File operations
class FileHandler {

    // Method that simulates reading a file (throws IOException)
    public void readFile() throws IOException {
        // Simulating an exception
        throw new IOException("Error: File not found while reading.");
    }

    // Method that simulates writing to a file (throws IOException)
    public void writeFile() throws IOException {
        // Simulating an exception
        throw new IOException("Error: Cannot write to file due to permission issues.");
    }
}

public class ThrowsKeywordDemo {
    public static void main(String[] args) {
        System.out.println("------ Demonstrating throws Keyword in Java ------");

        // Creating an instance of FileHandler
        FileHandler fileHandler = new FileHandler();

        // Handling readFile() exception
        try {
            System.out.println("\n[1] Attempting to read a file...");
            fileHandler.readFile();
        } catch (IOException e) {
            System.out.println(">> Caught IOException: " + e.getMessage());
        }

        // Handling writeFile() exception
        try {
            System.out.println("\n[2] Attempting to write to a file...");
            fileHandler.writeFile();
        } catch (IOException e) {
            System.out.println(">> Caught IOException: " + e.getMessage());
        }


    }
}
