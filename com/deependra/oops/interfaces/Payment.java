package com.deependra.oops.interfaces;

// Interface representing a Payment method
interface Payment {
    // Abstract method (to be implemented by subclasses)
    void makePayment(double amount);

    // Default method (common validation logic)
    default void validateTransaction() {
        System.out.println("Validating transaction...");
    }

    // Static method (utility function)
    static void getPlatformInfo() {
        System.out.println("Welcome to the Secure Payment Gateway!");
    }
}
