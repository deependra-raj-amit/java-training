package com.deependra.oops;

class BankAccount {
    // Private fields (data hiding)
    private String accountHolder;
    private String accountNumber;
    private double balance;

    // Constructor to initialize account details
    public BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getter for account holder
    public String getAccountHolder() {
        return accountHolder;
    }

    // Setter for account holder
    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    // Getter for account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Setter for account number (Restricted, can't change once set)
    public void setAccountNumber(String accountNumber) {
        System.out.println("Error: Cannot change account number once set!");
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit money (ensuring positive amount)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Method to withdraw money (checking sufficient balance)
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    // Display account details
    public void displayAccountDetails() {
        System.out.println("\nAccount Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: $" + balance);
    }
}

// Main class to test encapsulation
public class BankEncapsulationExample {
    public static void main(String[] args) {
        // Creating a bank account object
        BankAccount myAccount = new BankAccount("Deependra Raj Amit", "123456789", 5000.0);

        // Display initial details
        myAccount.displayAccountDetails();

        // Depositing money
        myAccount.deposit(2000);

        // Trying to withdraw money
        myAccount.withdraw(1500);

        // Attempting to change account number (should be restricted)
        myAccount.setAccountNumber("987654321");

        // Display updated details
        myAccount.displayAccountDetails();
    }
}
