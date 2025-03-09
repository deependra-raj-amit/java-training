package com.deependra.oops.inheritance;

// Parent class
class CoreBankAccount {
    String accountHolder;
    double balance;

    CoreBankAccount(String accountHolder, double balance) {
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

// Child class 1 - Savings Account
class SavingsBankAccount extends CoreBankAccount {
    double interestRate;

    SavingsBankAccount(String accountHolder, double balance, double interestRate) {
        super(accountHolder, balance);
        this.interestRate = interestRate;
    }

    void addInterest() {
        double interest = (balance * interestRate) / 100;
        balance += interest;
        System.out.println("Interest added: " + interest + ". New Balance: " + balance);
    }
}

// Child class 2 - Loan Account
class LoanBankAccount extends CoreBankAccount {
    double loanAmount;
    double interestRate;

    LoanBankAccount(String accountHolder, double balance, double loanAmount, double interestRate) {
        super(accountHolder, balance);
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
    }
    void displayLoanAmount(){
        System.out.println("Loan amount " + loanAmount);
    }

    void calculateEMI(int months) {
        double emi = (loanAmount + (loanAmount * interestRate / 100)) / months;
        System.out.println("EMI for " + months + " months: " + emi);
    }
}

// Child class 3 - Fixed Deposit Account
class FixedDepositBankAccount extends CoreBankAccount {
    double fixedDepositAmount;
    double fdInterestRate;
    int tenureMonths;

    FixedDepositBankAccount(String accountHolder, double balance, double fixedDepositAmount, double fdInterestRate, int tenureMonths) {
        super(accountHolder, balance);
        this.fixedDepositAmount = fixedDepositAmount;
        this.fdInterestRate = fdInterestRate;
        this.tenureMonths = tenureMonths;
    }

    void calculateMaturityAmount() {
        double maturityAmount = fixedDepositAmount + (fixedDepositAmount * fdInterestRate * tenureMonths) / 1200;
        System.out.println("Maturity Amount after " + tenureMonths + " months: " + maturityAmount);
    }
}

// Standard class name for execution
public class BankApplicationHierarchical {
    public static void main(String[] args) {
        SavingsBankAccount savingsAccount = new SavingsBankAccount("Deependra", 15000, 4.5);
        LoanBankAccount loanAccount = new LoanBankAccount("Amit", 10000, 50000, 7.5);
        FixedDepositBankAccount fdAccount = new FixedDepositBankAccount("Raj", 20000, 100000, 6.5, 12);

        savingsAccount.displayBalance();
        savingsAccount.addInterest();
        savingsAccount.displayBalance();

        loanAccount.displayBalance();
        loanAccount.displayLoanAmount();
        loanAccount.calculateEMI(12);

        fdAccount.displayBalance();
        fdAccount.calculateMaturityAmount();


    }
}
