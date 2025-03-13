package com.deependra.collectionframework;

/*
Definition of Queue in Java:
A Queue in Java is a FIFO (First-In-First-Out) data structure that processes elements in the order they
are added. It is part of the Java Collection Framework and is implemented using the Queue interface in
java.util.

Types of Queue in Java:
-PriorityQueue – Orders elements based on priority rather than FIFO.
-LinkedList (as Queue) – Implements a FIFO queue with dynamic size.
-ArrayDeque – Faster than LinkedList, used for both FIFO and LIFO operations.
-BlockingQueue – Used in multithreading, blocks when the queue is full/empty.
-Deque (Double-Ended Queue) – Supports insertion and removal from both ends.

Key Points of Queue in Java:
-Follows FIFO Order – Elements are processed in the order they arrive.
-Supports Various Implementations – Different queue types for different use cases.
-Thread-Safe Variants Available – BlockingQueue is used in concurrent applications.
-Efficient Operations – offer(), poll(), peek() provide fast access.
-Used in Real-World Applications – Task scheduling, load balancing, request handling, etc.
*/

import java.util.PriorityQueue;
import java.util.Queue;

/*
 * Banking System - Loan Application Processing Using PriorityQueue
-This program demonstrates how PriorityQueue is used to prioritize loan applications.
-Higher loan amounts get processed first, ensuring important applications are handled quickly.
 */
public class QueueExample {
    public static void main(String[] args) {
        // PriorityQueue to store loan applications (sorted by highest loan amount first)
        Queue<BankLoanRequest> loanQueue = new PriorityQueue<>();

        // Adding loan applications with different amounts (higher amount = higher priority)
        loanQueue.offer(new BankLoanRequest(101, "John Doe", 50000));  // Medium priority
        loanQueue.offer(new BankLoanRequest(102, "Alice Smith", 200000)); // High priority
        loanQueue.offer(new BankLoanRequest(103, "Bob Johnson", 10000));  // Low priority
        loanQueue.offer(new BankLoanRequest(104, "Emily Davis", 150000)); // Medium-high priority

        // Processing loan applications in priority order
        System.out.println("Processing Loan Applications:");
        while (!loanQueue.isEmpty()) {
            System.out.println(loanQueue.poll()); // Removes and processes the highest loan amount first
        }
    }
}

// Class representing a Bank Loan Request
class BankLoanRequest implements Comparable<BankLoanRequest> {
    int requestId;
    String applicantName;
    int loanAmount; // Higher loan amount = higher priority

    public BankLoanRequest(int requestId, String applicantName, int loanAmount) {
        this.requestId = requestId;
        this.applicantName = applicantName;
        this.loanAmount = loanAmount;
    }

    // Sorting loan applications by loan amount (higher loan amounts processed first)
    @Override
    public int compareTo(BankLoanRequest other) {
        return Integer.compare(other.loanAmount, this.loanAmount); // Higher loan amount first
    }

    @Override
    public String toString() {
        return "BankLoanRequest{" + "requestId=" + requestId + ", applicantName='" + applicantName + "', loanAmount=" + loanAmount + '}';
    }
}
