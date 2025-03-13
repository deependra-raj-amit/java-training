package com.deependra.collectionframework;

/*Definition of Set in Java
A Set in Java is a collection that does not allow duplicate elements and provides efficient operations
for searching, insertion, and deletion. It is part of the java.util package and is implemented through
HashSet, LinkedHashSet, and TreeSet.

Key Points of Set:
-No Duplicate Elements – Ensures each element is unique.
-Implements Collection Interface – Provides standard collection methods.
-Different Implementations:
-HashSet – Unordered, uses hashing for fast operations.
-LinkedHashSet – Maintains insertion order.
-TreeSet – Stores elements in sorted order.
-Allows One null Value – HashSet and LinkedHashSet allow one null, while TreeSet does not.
-Not Synchronized – Requires manual synchronization in multithreading.
-Faster Lookup – contains() and remove() have O(1) complexity in HashSet*/

import java.util.HashSet;
import java.util.Set;

/*
 Banking System - Tracking Fraudulent Transactions Using HashSet
 This program demonstrates how HashSet helps in detecting and storing unique fraudulent transaction IDs.
*/
public class SetExample {
    public static void main(String[] args) {
        // HashSet to store unique fraudulent transaction IDs
        Set<String> fraudTransactions = new HashSet<>();

        // Adding fraudulent transaction IDs
        fraudTransactions.add("TXN1024");
        fraudTransactions.add("TXN2056");
        fraudTransactions.add("TXN3098");
        fraudTransactions.add("TXN1024"); // Duplicate entry, will not be added again
        fraudTransactions.add("TXN4123");

        // Displaying all unique fraudulent transactions
        System.out.println("Fraudulent Transactions Detected: " + fraudTransactions);

        // Checking if a specific transaction is marked as fraudulent
        String checkTransaction = "TXN2056";
        if (fraudTransactions.contains(checkTransaction)) {
            System.out.println("Transaction " + checkTransaction + " is flagged as fraudulent.");
        } else {
            System.out.println("Transaction " + checkTransaction + " is not fraudulent.");
        }

        // Removing a false-positive transaction from the fraud list
        fraudTransactions.remove("TXN4123");
        System.out.println("Updated Fraudulent Transactions List: " + fraudTransactions);
    }
}
