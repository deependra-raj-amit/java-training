package com.deependra.oops.interfaces;

// UPI Payment implementation
class UPIPayment implements Payment {
    public void makePayment(double amount) {
        System.out.println("UPI Payment of ₹" + amount + " completed.");
    }
}
