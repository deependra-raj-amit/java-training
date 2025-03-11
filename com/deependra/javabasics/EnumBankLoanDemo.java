package com.deependra.javabasics;

// Enums in Java Demonstration
// 1. Enum: A special class in Java that defines a fixed set of constants.
// 2. Why Use Enums?
//    - Ensures type safety by restricting values to predefined constants.
//    - Improves readability and code maintainability.
//    - Can have properties, constructors, and methods.
// 3. Real-Life Use Case (Banking Sector):
//    - Used to represent different types of loans (HOME_LOAN, CAR_LOAN, PERSONAL_LOAN).
//    - Used for loan application status (APPROVED, REJECTED, PENDING).


enum LoanType {
    HOME_LOAN(8.5, "Long-term loan for purchasing a house"),
    CAR_LOAN(9.2, "Loan for buying a new or used vehicle"),
    PERSONAL_LOAN(11.5, "Short-term loan for personal expenses");

    private final double interestRate; // Interest rate of the loan
    private final String description;  // Loan description

    // Constructor for LoanType Enum
    LoanType(double rate, String desc) {
        this.interestRate = rate;
        this.description = desc;
    }

    // Getter methods to retrieve loan details
    public double getInterestRate() {
        return interestRate;
    }

    public String getDescription() {
        return description;
    }
}

// Enum for Loan Application Status
enum LoanStatus {
    APPROVED, REJECTED, PENDING
}

public class EnumBankLoanDemo {
    public static void main(String[] args) {

        // Selecting a loan type
        LoanType selectedLoan = LoanType.HOME_LOAN;
        System.out.println("Selected Loan Type: " + selectedLoan);
        System.out.println("Description: " + selectedLoan.getDescription());
        System.out.println("Interest Rate: " + selectedLoan.getInterestRate() + "%");

        // Checking another loan type
        LoanType carLoan = LoanType.CAR_LOAN;
        System.out.println("\nSelected Loan Type: " + carLoan);
        System.out.println("Description: " + carLoan.getDescription());
        System.out.println("Interest Rate: " + carLoan.getInterestRate() + "%");

        // Demonstrating Loan Application Status Enum
        LoanStatus applicationStatus = LoanStatus.PENDING;
        System.out.println("\nLoan Application Status: " + applicationStatus);

        // Simulating loan approval
        applicationStatus = LoanStatus.APPROVED;
        System.out.println("Updated Loan Application Status: " + applicationStatus);


    }
}
