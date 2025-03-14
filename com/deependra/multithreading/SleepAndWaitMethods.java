package com.deependra.multithreading;

/*
Thread Coordination Methods Used:

-->sleep(ms)    - Simulates document verification time in the loan process.
-->wait()       - Customers wait if the loan officer is busy.
-->notify()     - Notifies a single waiting customer when loan approval is completed.
-->notifyAll()  - Notifies all waiting customers when multiple loans are approved.
 */

class BankLoanSystem {
    private boolean isLoanApproved = false; // Flag to check loan status

    // Synchronized method to apply for a loan
    synchronized void applyForLoan() {
        System.out.println(Thread.currentThread().getName() + " applied for a loan.");

        // If loan is not approved, customer waits
        while (!isLoanApproved) {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting for loan approval...");
                wait(); // Customer waits for loan officer's approval
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " was interrupted while waiting.");
            }
        }

        System.out.println(Thread.currentThread().getName() + " received loan approval! ✅");
    }

    // Synchronized method to process and approve loans
    synchronized void approveLoan(boolean approveMultiple) {
        try {
            System.out.println("Loan Officer is verifying documents...");
            Thread.sleep(5000); // Simulating document verification delay
        } catch (InterruptedException e) {
            System.out.println("Loan Officer was interrupted during verification.");
        }

        isLoanApproved = true;
        System.out.println("Loan Officer has approved the loan(s).");

        // Notify waiting customers
        if (approveMultiple) {
            notifyAll(); // Notify all waiting customers
        } else {
            notify(); // Notify only one customer
        }
    }
}

// Thread class for customers applying for loans
class CustomerThread extends Thread {
    private BankLoanSystem bank;

    CustomerThread(BankLoanSystem bank, String name) {
        super(name);
        this.bank = bank;
    }

    public void run() {
        bank.applyForLoan();
    }
}

// Thread class for the loan officer approving loans
class LoanOfficerThread extends Thread {
    private BankLoanSystem bank;
    private boolean approveMultiple;

    LoanOfficerThread(BankLoanSystem bank, boolean approveMultiple) {
        this.bank = bank;
        this.approveMultiple = approveMultiple;
    }

    public void run() {
        bank.approveLoan(approveMultiple);
    }
}

// Main class with the requested meaningful name
public class SleepAndWaitMethods {
    public static void main(String[] args) {
        BankLoanSystem bank = new BankLoanSystem();

        // Creating customer threads (loan applicants)
        CustomerThread customer1 = new CustomerThread(bank, "Customer-1");
        CustomerThread customer2 = new CustomerThread(bank, "Customer-2");
        CustomerThread customer3 = new CustomerThread(bank, "Customer-3");

        // Start customer threads (they will wait for approval)
        customer1.start();
        customer2.start();
        customer3.start();

        // Loan officer thread starts after some delay to approve loans
        LoanOfficerThread officer = new LoanOfficerThread(bank, true);
        officer.start();
    }
}

