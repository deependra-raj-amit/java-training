package com.deependra.oops.interfaces;

public class PaymentSystem {
    public static void main(String[] args) {
        // Call static method from interface
        Payment.getPlatformInfo();

        // UPI Payment
        Payment upi = new UPIPayment();
        upi.validateTransaction(); // Calls default method
        upi.makePayment(2000);

        System.out.println();

        // Credit Card Payment
        Payment card = new CreditCardPayment();
        card.validateTransaction();
        card.makePayment(5000);
    }
}
