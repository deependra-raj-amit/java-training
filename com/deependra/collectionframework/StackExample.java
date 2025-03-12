package com.deependra.collectionframework;

import java.util.Stack;

class StackExample {
    public static void main(String[] args) {
        Stack<Integer> withdrawalHistory = new Stack<>(); // Stack to track withdrawals

        // Customer withdraws cash
        withdrawCash(withdrawalHistory, 2000);
        withdrawCash(withdrawalHistory, 5000);
        withdrawCash(withdrawalHistory, 3000);

        System.out.println("Withdrawal History: " + withdrawalHistory);

        // Undo last withdrawal
        undoLastWithdrawal(withdrawalHistory);

        // Check last transaction
        checkLastTransaction(withdrawalHistory);
    }

    // Method to withdraw cash
    public static void withdrawCash(Stack<Integer> history, int amount) {
        history.push(amount); // Push transaction to history
        System.out.println("Withdrawn: ₹" + amount);
    }

    // Method to undo last withdrawal
    public static void undoLastWithdrawal(Stack<Integer> history) {
        if (!history.isEmpty()) {
            System.out.println("Undo Last Withdrawal: ₹" + history.pop());
        } else {
            System.out.println("No transactions to undo.");
        }
    }

    // Method to check last transaction
    public static void checkLastTransaction(Stack<Integer> history) {
        if (!history.isEmpty()) {
            System.out.println("Last Transaction: ₹" + history.peek());
        } else {
            System.out.println("No transactions available.");
        }
    }
}
