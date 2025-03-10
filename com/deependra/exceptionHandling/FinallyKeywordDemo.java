package com.deependra.exceptionHandling;

// finally Keyword Demonstration
// 1. finally Block: A block that always executes after try-catch, regardless of exception occurrence.
// 2. Purpose: Used for resource cleanup (e.g., closing files, database connections).
// 3. When does finally Execute?
//    - Executes when no exception occurs.
//    - Executes when an exception occurs.
//    - Executes even when return or break is used inside try or catch.
// 4. Real-Life Use Case: Used for closing file streams, database connections, or releasing locks.


import java.util.Scanner;

class ATM {
    private int balance = 10000; // Initial balance

    // Method to withdraw money
    public void withdraw(int amount) {
        System.out.println("\nProcessing withdrawal...");

        try {
            if (amount > balance) {
                throw new ArithmeticException("Error: Insufficient balance!");
            }
            balance -= amount;
            System.out.println("✅ Withdrawal successful! Remaining balance: " + balance);
        } catch (ArithmeticException e) {
            System.out.println(">> Caught Exception: " + e.getMessage());
        } finally {
            System.out.println("📝 Transaction Completed. Thank you for using the ATM!");
        }
    }
}

public class FinallyKeywordDemo {
    public static void main(String[] args) {
        System.out.println("------ Demonstrating finally Keyword in Java ------");

        // Taking user input for withdrawal amount
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter withdrawal amount: ");
        int amount = scanner.nextInt();

        // Creating ATM instance and processing withdrawal
        ATM atm = new ATM();
        atm.withdraw(amount);


        scanner.close();
    }
}
