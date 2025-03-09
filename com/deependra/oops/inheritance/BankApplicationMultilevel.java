package com.deependra.oops.inheritance;

// Parent class
class BaseBankAccount {
    String accountHolder;
    double balance;

    BaseBankAccount(String accountHolder, double balance) {
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

// Intermediate child class inheriting from BaseBankAccount
class StandardSavingsAccount extends BaseBankAccount {
    double interestRate;

    StandardSavingsAccount(String accountHolder, double balance, double interestRate) {
        super(accountHolder, balance);
        this.interestRate = interestRate;
    }

    void addInterest() {
        double interest = (balance * interestRate) / 100;
        balance += interest;
        System.out.println("Interest added: " + interest + ". New Balance: " + balance);
    }
}

// Final child class inheriting from StandardSavingsAccount
class PremiumSavingsAccount extends StandardSavingsAccount {
    double bonusInterestRate;

    PremiumSavingsAccount(String accountHolder, double balance, double interestRate, double bonusInterestRate) {
        super(accountHolder, balance, interestRate);
        this.bonusInterestRate = bonusInterestRate;
    }

    void addBonusInterest() {
        double bonusInterest = (balance * bonusInterestRate) / 100;
        balance += bonusInterest;
        System.out.println("Bonus Interest added: " + bonusInterest + ". New Balance: " + balance);
    }
}

// Standard class name for execution
public class BankApplicationMultilevel {
    public static void main(String[] args) {
        PremiumSavingsAccount psa = new PremiumSavingsAccount("Deependra", 20000, 5.0, 2.0);

        psa.displayBalance();  // Show initial balance
        psa.deposit(5000);     // Deposit money
        psa.withdraw(3000);    // Withdraw money
        psa.addInterest();     // Apply regular interest
        psa.addBonusInterest(); // Apply bonus interest
        psa.displayBalance();  // Show final balance
    }
}
