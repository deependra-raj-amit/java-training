package com.deependra.oops; // Defines the package where the classes belong

// CustomerBankAccount class to represent a bank account
class CustomerBankAccount {
    private String holderName;
    private String accountNo;
    private double balance;

    // **No-Argument Constructor (Default Constructor)**
    // This constructor initializes a new bank account with default values
    public CustomerBankAccount() {
        this.holderName = "Unknown";
        this.accountNo = "000000000";
        this.balance = 0.0;
        System.out.println("Default Bank Account Created!");
    }

    // **Parameterized Constructor**
    // This constructor allows setting values for account holder, account number, and balance
    public CustomerBankAccount(String holderName, String accountNo, double balance) {
        this.holderName = holderName;
        this.accountNo = accountNo;
        this.balance = balance;
        System.out.println("Bank Account Created for: " + holderName); // Message indicating account creation
    }

    // **Method to Display Account Details**
    public void showAccountDetails() {
        System.out.println("\nAccount Holder: " + holderName);
        System.out.println("Account Number: " + accountNo);
        System.out.println("Current Balance: $" + balance);
    }
}

// **Main class to test constructors**
public class BankConstructorDemo {
    public static void main(String[] args) {
        // **Creating an account using the No-Argument Constructor**
        // This object is created without passing any values, so default values are used
        CustomerBankAccount defaultAccount = new CustomerBankAccount();
        defaultAccount.showAccountDetails(); // Display default account details

        // **Creating an account using the Parameterized Constructor**
        // This object is created with specific values for account holder, number, and balance
        CustomerBankAccount myAccount = new CustomerBankAccount("Deependra Raj Amit", "123456789", 10000.0);
        myAccount.showAccountDetails(); // Display provided account details
    }
}
