package com.deependra.collectionframework;

/*
Definition of HashMap in Java
A HashMap in Java is a part of the java.util package that implements the Map interface, storing
key-value pairs. It provides constant-time complexity (O(1)) for basic operations like insertion, deletion,
and lookup using hashing.

Key Points of HashMap:
1. Stores Data in Key-Value Pairs – Each key is unique and maps to a specific value.
2. Uses Hashing for Fast Access – Provides O(1) average time complexity for operations.
3. Allows One null Key & Multiple null Values – Unlike HashTable, which doesn’t allow null.
4. Not Thread-Safe – Requires Collections.synchronizedMap() or ConcurrentHashMap for multi-threading.
5. Unordered Collection – Entries are not stored in any specific order.
6. Handles Collisions Using Chaining – Uses linked lists or binary trees for collision resolution.
*/

import java.util.HashMap;
import java.util.Map;

class HashMapExample {
    public static void main(String[] args) {
        // Creating a HashMap to store loan details (Loan ID -> Loan Amount)
        HashMap<String, Double> loans = new HashMap<>();

        // Adding new loans (put)
        addLoan(loans, "LN1001", 500000.0);
        addLoan(loans, "LN1002", 250000.0);
        addLoan(loans, "LN1003", 1000000.0);

        // Retrieving loan details (get)
        checkLoanAmount(loans, "LN1001");

        // Updating loan balance (put)
        makePayment(loans, "LN1001", 50000.0);

        // Checking if a loan exists (containsKey)
        checkLoanExists(loans, "LN2000");

        // Removing a fully paid loan (remove)
        closeLoan(loans, "LN1003");

        // Displaying all active loans (entrySet, keySet, values)
        displayAllLoans(loans);
    }

    // Method to add a new loan
    public static void addLoan(HashMap<String, Double> loans, String loanID, double amount) {
        loans.put(loanID, amount);
        System.out.println("New Loan Added: " + loanID + " | Amount: ₹" + amount);
    }

    // Method to check loan amount
    public static void checkLoanAmount(HashMap<String, Double> loans, String loanID) {
        if (loans.containsKey(loanID)) {
            System.out.println("Loan ID: " + loanID + " | Outstanding Amount: ₹" + loans.get(loanID));
        } else {
            System.out.println("Loan ID " + loanID + " not found.");
        }
    }

    // Method to make a payment towards a loan
    public static void makePayment(HashMap<String, Double> loans, String loanID, double payment) {
        if (loans.containsKey(loanID)) {
            double newBalance = loans.get(loanID) - payment;
            loans.put(loanID, newBalance);
            System.out.println("Payment of ₹" + payment + " made for Loan ID: " + loanID + " | New Balance: ₹" + newBalance);
        } else {
            System.out.println("Loan ID " + loanID + " not found.");
        }
    }

    // Method to check if a loan exists
    public static void checkLoanExists(HashMap<String, Double> loans, String loanID) {
        if (loans.containsKey(loanID)) {
            System.out.println("Loan " + loanID + " exists.");
        } else {
            System.out.println("Loan " + loanID + " does not exist.");
        }
    }

    // Method to remove a loan once fully paid
    public static void closeLoan(HashMap<String, Double> loans, String loanID) {
        if (loans.containsKey(loanID) && loans.get(loanID) <= 0) {
            loans.remove(loanID);
            System.out.println("Loan ID " + loanID + " has been fully paid and closed.");
        } else {
            System.out.println("Loan ID " + loanID + " is not fully paid yet or does not exist.");
        }
    }

    // Method to display all active loans
    public static void displayAllLoans(HashMap<String, Double> loans) {
        System.out.println("\nAll Active Loans:");
        for (Map.Entry<String, Double> entry : loans.entrySet()) {
            System.out.println("Loan ID: " + entry.getKey() + " | Outstanding Amount: ₹" + entry.getValue());
        }
    }
}
