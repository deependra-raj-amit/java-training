package com.deependra.collectionframework;

import java.util.LinkedList;

/*
A LinkedList in Java is a linear data structure where elements (nodes) are stored in
non-contiguous memory locations and connected via pointers (references).
It implements the List and Deque interfaces, allowing dynamic memory allocation and efficient
insertions/deletions.

Key Points of LinkedList
Dynamic Size – Unlike arrays, LinkedList grows and shrinks dynamically.
Efficient Insertions/Deletions – Adding/removing elements is O(1) at the beginning or end.
Higher Memory Usage – Each node stores extra references (next/previous).
Slower Search – Accessing elements takes O(n), unlike ArrayList (O(1)).
Types – Supports Singly, Doubly, and Circular LinkedLists.
Use Cases – Ideal for transaction history, undo-redo, cache, and task scheduling.
*/

public class LinkedListExample {
    public static void main(String[] args) {
        // Creating a LinkedList to store transaction history
        LinkedList<String> transactionHistory = new LinkedList<>();

        // 1. add(E e) - Adds a transaction to the end of the list
        transactionHistory.add("Deposit: ₹5000");
        transactionHistory.add("Withdraw: ₹2000");
        transactionHistory.add("Deposit: ₹15000");

        // 2. addFirst(E e) - Adds a new transaction at the beginning (recent transactions first)
        transactionHistory.addFirst("Withdraw: ₹1000");

        // 3. addLast(E e) - Adds a transaction at the end (used in FIFO-based history)
        transactionHistory.addLast("Deposit: ₹7000");

        // 4. get(int index) - Fetches transaction details at a specific position
        System.out.println("Transaction at index 2: " + transactionHistory.get(2));

        // 5. getFirst() - Retrieves the most recent transaction
        System.out.println("Most recent transaction: " + transactionHistory.getFirst());

        // 6. getLast() - Retrieves the oldest transaction
        System.out.println("Oldest transaction: " + transactionHistory.getLast());

        // 7. removeFirst() - Removes the most recent transaction
        System.out.println("Removing latest transaction: " + transactionHistory.removeFirst());

        // 8. removeLast() - Removes the oldest transaction
        System.out.println("Removing oldest transaction: " + transactionHistory.removeLast());

        // 9. remove(int index) - Removes a transaction at a specific position
        System.out.println("Removing transaction at index 1: " + transactionHistory.remove(1));

        // 10. set(int index, E e) - Modifies an existing transaction record
        transactionHistory.set(1, "Withdraw: ₹5000 (Updated)");
        System.out.println("Updated transaction history: " + transactionHistory);

        // 11. contains(Object o) - Checks if a specific transaction exists
        System.out.println("Is 'Deposit: ₹5000' in history? " + transactionHistory.contains("Deposit: ₹5000"));

        // 12. indexOf(Object o) - Returns index of a specific transaction
        System.out.println("Index of 'Deposit: ₹5000': " + transactionHistory.indexOf("Deposit: ₹5000"));

        // 13. peek() - Retrieves the first transaction without removing it
        System.out.println("Peek first transaction: " + transactionHistory.peek());

        // 14. poll() - Retrieves and removes the first transaction
        System.out.println("Polling transaction: " + transactionHistory.poll());

        // 15. size() - Returns the number of transactions in the history
        System.out.println("Total transactions left: " + transactionHistory.size());

        // 16. clear() - Clears all transaction history
        transactionHistory.clear();
        System.out.println("Transaction history after clearing: " + transactionHistory);
    }
}

