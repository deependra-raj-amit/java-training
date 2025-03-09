package com.deependra.oops.polymorphism;

class DiscountCalculator {
    // Method to calculate discount for a fixed amount
    double getDiscount(double price, double discountAmount) {
        return price - discountAmount;
    }

    // Method to calculate discount based on percentage
    double getDiscount(double price, int discountPercentage) {
        return price - (price * discountPercentage / 100);
    }

    // Method to apply discount using a coupon code
    double getDiscount(double price, String couponCode) {
        if (couponCode.equals("SAVE500")) {
            return price - 500; // ₹500 discount
        } else if (couponCode.equals("NEWUSER")) {
            return price - 200; // ₹200 discount
        }
        return price; // No discount for invalid coupon
    }
}


public class EcommerceDiscount {
    public static void main(String[] args) {
        DiscountCalculator calculator = new DiscountCalculator();

        // Applying different discounts using method overloading
        System.out.println("Price after flat ₹500 discount: ₹" + calculator.getDiscount(5000, 500));
        System.out.println("Price after 10% discount: ₹" + calculator.getDiscount(5000, 10));
        System.out.println("Price after applying 'SAVE500' coupon: ₹" + calculator.getDiscount(5000, "SAVE500"));
    }
}
