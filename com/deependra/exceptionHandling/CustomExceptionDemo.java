package com.deependra.exceptionHandling;

// Custom Exception Demonstration
// 1. Custom Exception: A user-defined exception that extends Exception or RuntimeException.
// 2. Purpose: Used when built-in exceptions don’t cover specific error cases in an application.
// 3. Steps to Create a Custom Exception:
//    - Extend Exception (Checked Exception) or RuntimeException (Unchecked Exception).
//    - Define a constructor to pass custom error messages.
// 4. Real-Life Use Case: Validating bank withdrawals to prevent overdrafts.


import java.util.Scanner;

// Step 1: Create a custom exception by extending Exception
class InsufficientBalanceExceptions extends Exception {
    public InsufficientBalanceExceptions(String message) {
        super(message);
    }
}

// Step 2: BankAccount class that throws the custom exception
class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public void withdraw(int amount) throws InsufficientBalanceException {
        System.out.println("\nProcessing Withdrawal...");
        if (amount > balance) {
            throw new InsufficientBalanceException("Error: Insufficient Balance! Available balance: " + balance);
        }
        balance -= amount;
        System.out.println("Withdrawal Successful! Remaining balance: " + balance);
    }
}

// Step 3: Demonstrating the custom exception in main class
public class CustomExceptionDemo {
    public static void main(String[] args) {

        // Creating a bank account with an initial balance
        BankAccount account = new BankAccount(5000);

        // Taking user input for withdrawal amount
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter withdrawal amount: ");
        int amount = scanner.nextInt();

        try {
            // Attempting withdrawal
            account.withdraw(amount);
        } catch (InsufficientBalanceException e) {
            System.out.println(">> Caught Custom Exception: " + e.getMessage());
        } finally {
            System.out.println("Transaction Completed. Thank you for banking with us!");
        }

        scanner.close();
    }
}
