package com.deependra.oops.polymorphism;

// Parent class
class Payment {
    void makePayment(double amount) {
        System.out.println("Processing payment of ₹" + amount);
    }
}

// Credit Card Payment
class CreditCardPayment extends Payment {
    @Override
    void makePayment(double amount) {
        System.out.println("Processing ₹" + amount + " via Credit Card.");
    }
}

// Debit Card Payment
class DebitCardPayment extends Payment {
    @Override
    void makePayment(double amount) {
        System.out.println("Processing ₹" + amount + " via Debit Card.");
    }
}

// UPI Payment
class UpiPayment extends Payment {
    @Override
    void makePayment(double amount) {
        System.out.println("Processing ₹" + amount + " via UPI.");
    }
}


public class PaymentProcessor {
    public static void main(String[] args) {
        // Parent class reference, child class objects
        Payment payment1 = new CreditCardPayment();
        Payment payment2 = new DebitCardPayment();
        Payment payment3 = new UpiPayment();

        // Method call, polymorphism in action
        payment1.makePayment(5000);  // Calls CreditCardPayment's method
        payment2.makePayment(2000);  // Calls DebitCardPayment's method
        payment3.makePayment(1500);  // Calls UpiPayment's method
    }
}

