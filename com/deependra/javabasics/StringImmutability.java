package com.deependra.javabasics;

public class StringImmutability {
    public static void main(String[] args) {
        String original = "Hello";
        String modified = original.concat(", World!");

        System.out.println("Original String: " + original);
        System.out.println("Modified String: " + modified);

        // Checking if original is unchanged
        if (original.equals("Hello")) {
            System.out.println("String is immutable! The original string remains unchanged.");
        }
    }
}

