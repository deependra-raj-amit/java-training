package com.deependra.exceptionHandling;

// Exception Handling in Java
// 1. Exception: An unwanted or unexpected event that disrupts the normal flow of a program.
// 2. Try Block: Contains code that may generate an exception.
// 3. Catch Block: Handles the exception thrown by the try block.
// 4. Finally Block: Code that always executes, regardless of exception occurrence.
// 5. Throw: Used to manually throw an exception.
// 6. Throws: Declares an exception in the method signature.

import java.util.Scanner;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class ATMExceptionHandling {
    private double balance;

    public ATMExceptionHandling(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient Balance! You tried to withdraw: " + amount);
        }
        balance -= amount;
        System.out.println("Withdrawal successful! Remaining balance: " + balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATMExceptionHandling myAccount = new ATMExceptionHandling(5000); // Initial balance

        try {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            myAccount.withdraw(amount);
        } catch (InsufficientBalanceException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        } finally {
            System.out.println("Thank you for using our ATM service.");
            scanner.close();
        }
    }
}
