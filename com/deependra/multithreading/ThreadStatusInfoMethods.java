package com.deependra.multithreading;

/*
 Demonstrating Thread Status & Information Methods
This program simulates a Credit Score Evaluation System in a Banking Sector.
It demonstrates the following **Thread Status & Information Methods:

-->getName()     - Retrieves the thread's name.
-->setName()     - Assigns a custom name to the thread.
-->getId()       - Returns a unique thread ID.
-->getPriority() - Retrieves the thread priority.
-->setPriority() - Changes thread priority (1 to 10, default is 5).
-->isAlive()     - Checks if the thread is still running.
-->getState()    - Retrieves the thread's current execution state.

Scenario:
-->A bank processes credit scores of customers before loan approval.
-->Each customer's credit score is evaluated in a separate thread.
*/

class CreditScoreEvaluator extends Thread {
    private String customerName; // Stores the customer's name

    // Constructor to initialize customer name
    CreditScoreEvaluator(String customerName) {
        this.customerName = customerName;
    }

    // The run() method contains the task that the thread will execute
    public void run() {
        // Display thread information before processing
        System.out.println("Evaluating Credit Score for: " + customerName);
        System.out.println("   - Thread Name: " + getName());
        System.out.println("   - Thread ID: " + getId());
        System.out.println("   - Priority: " + getPriority());
        System.out.println("   - State Before Execution: " + getState());
        System.out.println("------------------------------------------");

        try {
            Thread.sleep(3000); // Simulating credit score calculation (3 seconds delay)
        } catch (InterruptedException e) {
            System.out.println("==> " + getName() + " was interrupted during execution.");
        }

        // Display thread status after execution
        System.out.println("==>Credit Score Evaluation Completed for: " + customerName);
        System.out.println("   - Thread Name: " + getName());
        System.out.println("   - Thread ID: " + getId());
        System.out.println("   - State After Execution: " + getState());
        System.out.println("------------------------------------------");
    }
}


public class ThreadStatusInfoMethods {
    public static void main(String[] args) {
        System.out.println("==> Bank Credit Score Processing System Started...\n");

        // Creating threads for customers' credit score evaluation
        CreditScoreEvaluator customer1 = new CreditScoreEvaluator("John Doe");     // MIN_PRIORITY
        CreditScoreEvaluator customer2 = new CreditScoreEvaluator("Jane Smith");   // LOW_PRIORITY
        CreditScoreEvaluator customer3 = new CreditScoreEvaluator("Alice Brown");  // AVERAGE_PRIORITY (default)
        CreditScoreEvaluator customer4 = new CreditScoreEvaluator("Bob Wilson");   // HIGH_PRIORITY
        CreditScoreEvaluator customer5 = new CreditScoreEvaluator("Emma Davis");   // MAX_PRIORITY

        // Setting custom thread names for better tracking
        customer1.setName("CreditScore-Thread-1 (Low)");
        customer2.setName("CreditScore-Thread-2 (Regular)");
        customer3.setName("CreditScore-Thread-3 (Average)");
        customer4.setName("CreditScore-Thread-4 (High)");
        customer5.setName("CreditScore-Thread-5 (VIP)");

        // Assigning different thread priorities
        customer1.setPriority(Thread.MIN_PRIORITY);  // Priority 1 (Low Priority)
        customer2.setPriority(3);                    // Priority 3 (Regular Customer)
        customer3.setPriority(Thread.NORM_PRIORITY); // Priority 5 (Average - Default)
        customer4.setPriority(7);                    // Priority 7 (High Priority)
        customer5.setPriority(Thread.MAX_PRIORITY);  // Priority 10 (VIP Customer)

        // Displaying initial state of threads before starting them
        System.out.println("Checking Initial Thread States:");
        System.out.println("   - " + customer1.getName() + " is Alive? " + customer1.isAlive());
        System.out.println("   - " + customer2.getName() + " is Alive? " + customer2.isAlive());
        System.out.println("   - " + customer3.getName() + " is Alive? " + customer3.isAlive());
        System.out.println("   - " + customer4.getName() + " is Alive? " + customer4.isAlive());
        System.out.println("   - " + customer5.getName() + " is Alive? " + customer5.isAlive());
        System.out.println("------------------------------------------");

        // Starting the credit score evaluation threads
        customer1.start();
        customer2.start();
        customer3.start();
        customer4.start();
        customer5.start();

        // Checking if threads are running after starting
        System.out.println("Checking Thread States After Starting:");
        System.out.println("   - " + customer1.getName() + " is Alive? " + customer1.isAlive());
        System.out.println("   - " + customer2.getName() + " is Alive? " + customer2.isAlive());
        System.out.println("   - " + customer3.getName() + " is Alive? " + customer3.isAlive());
        System.out.println("   - " + customer4.getName() + " is Alive? " + customer4.isAlive());
        System.out.println("   - " + customer5.getName() + " is Alive? " + customer5.isAlive());
        System.out.println("------------------------------------------");
    }
}
