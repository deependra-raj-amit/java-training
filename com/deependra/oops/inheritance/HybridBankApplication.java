package com.deependra.oops.inheritance;

// Base class (Parent)
class GeneralBankAccount {
    String accountHolder;
    double balance;

    GeneralBankAccount(String accountHolder, double balance) {
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

// Hierarchical Inheritance (Multiple Child Classes)
class RegularSavingsAccount extends GeneralBankAccount {
    double interestRate;

    RegularSavingsAccount(String accountHolder, double balance, double interestRate) {
        super(accountHolder, balance);
        this.interestRate = interestRate;
    }

    void addInterest() {
        double interest = (balance * interestRate) / 100;
        balance += interest;
        System.out.println("Interest added: " + interest + ". New Balance: " + balance);
    }
}

// Multilevel Inheritance (Child of RegularSavingsAccount)
class EliteSavingsAccount extends RegularSavingsAccount {
    double extraBonusInterest;

    EliteSavingsAccount(String accountHolder, double balance, double interestRate, double extraBonusInterest) {
        super(accountHolder, balance, interestRate);
        this.extraBonusInterest = extraBonusInterest;
    }

    void addBonusInterest() {
        double bonus = (balance * extraBonusInterest) / 100;
        balance += bonus;
        System.out.println("Bonus Interest added: " + bonus + ". New Balance: " + balance);
    }
}

// Another child class of GeneralBankAccount (Hierarchical Inheritance)
class BusinessLoanAccount extends GeneralBankAccount {
    double loanAmount;
    double interestRate;

    BusinessLoanAccount(String accountHolder, double balance, double loanAmount, double interestRate) {
        super(accountHolder, balance);
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
    }

    void calculateEMI(int months) {
        double emi = (loanAmount + (loanAmount * interestRate / 100)) / months;
        System.out.println("EMI for " + months + " months: " + emi);
    }
}

// Execution class
public class HybridBankApplication {
    public static void main(String[] args) {
        // Hierarchical: Regular Savings Account
        RegularSavingsAccount savingsAccount = new RegularSavingsAccount("Deependra", 20000, 4.5);
        savingsAccount.displayBalance();
        savingsAccount.addInterest();
        savingsAccount.displayBalance();

        // Multilevel: Elite Savings Account
        EliteSavingsAccount premiumAccount = new EliteSavingsAccount("Amit", 50000, 5.0, 1.5);
        premiumAccount.displayBalance();
        premiumAccount.addInterest();
        premiumAccount.addBonusInterest();
        premiumAccount.displayBalance();

        // Hierarchical: Business Loan Account
        BusinessLoanAccount loanAccount = new BusinessLoanAccount("Raj", 10000, 75000, 6.5);
        loanAccount.displayBalance();
        loanAccount.calculateEMI(12);
    }
}
