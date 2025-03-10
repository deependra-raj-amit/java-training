package com.deependra.oops.interfaces;

// Credit Card Payment implementation
class CreditCardPayment implements Payment {
    public void makePayment(double amount) {
        System.out.println("Credit Card Payment of ₹" + amount + " completed.");
    }
}