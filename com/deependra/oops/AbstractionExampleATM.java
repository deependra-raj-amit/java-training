package com.deependra.oops;

// Abstract class representing an ATM
abstract class ATM {
    protected double balance = 10000; // Default balance

    // Abstract methods - implementation will be provided by subclasses
    abstract void withdraw(double amount);
    abstract void deposit(double amount);
    abstract void checkBalance();
}

// Concrete class implementing the ATM functionalities
class SBIATM extends ATM {
    @Override
    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn. Remaining balance: ₹" + balance);
        }
    }

    @Override
    void deposit(double amount) {
        balance += amount;
        System.out.println("₹" + amount + " deposited. New balance: ₹" + balance);
    }

    @Override
    void checkBalance() {
        System.out.println("Current balance: ₹" + balance);
    }
}


public class AbstractionExampleATM {
    public static void main(String[] args) {
        ATM myATM = new SBIATM(); // Using the abstract class reference

        myATM.checkBalance();
        myATM.deposit(5000);
        myATM.withdraw(3000);
        myATM.checkBalance();
    }
}
