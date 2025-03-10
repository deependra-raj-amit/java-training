package com.deependra.javabasics;

// Final class to prevent inheritance
final class GovernmentTaxRules {
    // Final variable (constant tax rate)
    private final double taxRate = 18.0; // 18% GST

    // Final method (cannot be overridden)
    public final double calculateTax(double amount) {
        return (amount * taxRate) / 100;
    }

    // Method to display tax details
    public void displayTaxDetails(double amount) {
        System.out.println("Amount: ₹" + amount);
        System.out.println("Tax Rate: " + taxRate + "%");
        System.out.println("Tax Amount: ₹" + calculateTax(amount));
    }
}


public class FinalExampleTaxCalculation {
    public static void main(String[] args) {
        GovernmentTaxRules taxRules = new GovernmentTaxRules();

        // Example transactions
        taxRules.displayTaxDetails(5000);
        System.out.println();
        taxRules.displayTaxDetails(10000);
    }
}
