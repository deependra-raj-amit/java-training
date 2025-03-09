package com.deependra.oops.inheritance;

// Parent class
class BankAccount {
    String accountHolder;
    double balance;

    BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited. New Balance: " + balance);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void displayBalance() {
        System.out.println("Account Holder: " + accountHolder + ", Balance: " + balance);
    }
}

// Child class inheriting from BankAccount
class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String accountHolder, double balance, double interestRate) {
        super(accountHolder, balance); // Calling parent class constructor
        this.interestRate = interestRate;
    }

    void addInterest() {
        double interest = (balance * interestRate) / 100;
        balance += interest;
        System.out.println("Interest added: " + interest + ". New Balance: " + balance);
    }
}

// Standard class name for execution
public class BankApplicationSingleInheritance {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("Deependra", 10000, 5.0);

        sa.displayBalance();  // Show initial balance
        sa.deposit(5000);     // Deposit money
        sa.withdraw(3000);    // Withdraw money
        sa.addInterest();     // Apply interest
        sa.displayBalance();  // Show final balance
    }
}
