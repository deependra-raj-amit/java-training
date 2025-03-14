package com.deependra.multithreading;

/*
Thread Life Cycle Control Methods Used:
-->start()       - Begins execution of a thread by calling run().
-->run()         - Defines the thread's task (should be overridden).
-->stop() (Deprecated) - Unsafe method to stop a thread (not used here).
-->interrupt()   - Interrupts a sleeping or waiting thread.
-->isInterrupted() - Checks if the thread is interrupted.
 */

class BankAccount {
    private int balance = 5000; // Initial bank balance

    // Synchronized method to withdraw money
    synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " is trying to withdraw " + amount);

        // If balance is insufficient, wait for deposit
        if (balance < amount) {
            System.out.println("Insufficient funds! Waiting for deposit...");
            try {
                wait(); // Waits until deposit is made
            } catch (InterruptedException e) {
                System.out.println("Withdrawal process interrupted!");
            }
        }

        // Deduct amount after deposit is made
        balance -= amount;
        System.out.println("Withdrawal successful! Remaining balance: " + balance);
    }

    // Synchronized method to deposit money
    synchronized void deposit(int amount) {
        System.out.println(Thread.currentThread().getName() + " is depositing " + amount);

        balance += amount; // Increase balance
        System.out.println("Deposit successful! New balance: " + balance);

        notify(); // Notify the waiting withdrawal thread that deposit is done
    }
}

// Thread responsible for withdrawing money
class WithdrawThread extends Thread {
    private BankAccount account;

    WithdrawThread(BankAccount account) {
        this.account = account;
    }

    // Run method defining withdrawal behavior
    public void run() {
        account.withdraw(7000); // Trying to withdraw more than the available balance
    }
}

// Thread responsible for monitoring account balance
class BalanceMonitor extends Thread {
    private BankAccount account;

    BalanceMonitor(BankAccount account) {
        this.account = account;
    }

    // Run method defining balance monitoring behavior
    public void run() {
        while (!isInterrupted()) { // Loop runs until thread is interrupted
            try {
                Thread.sleep(3000); // Check balance every 3 seconds
                System.out.println("Balance check: Monitoring in progress...");
            } catch (InterruptedException e) {
                System.out.println("Balance monitoring interrupted!");
                break; // Exit loop safely when interrupted
            }
        }
    }
}

public class ThreadLifecycleExample { // Renamed to a meaningful name for easy revision
    public static void main(String[] args) {
        BankAccount account = new BankAccount(); // Create a shared bank account

        // Create and start threads
        WithdrawThread withdrawThread = new WithdrawThread(account);
        BalanceMonitor monitorThread = new BalanceMonitor(account);

        withdrawThread.setName("Withdrawal Thread"); // Set name for clarity
        monitorThread.setName("Balance Monitor Thread");

        withdrawThread.start(); // Start withdrawal thread
        monitorThread.start();  // Start balance monitoring thread

        try {
            // Simulating some delay before depositing money
            Thread.sleep(5000);
            account.deposit(3000); // Deposit money after 5 seconds

            // Let threads run for some more time before stopping monitoring
            Thread.sleep(2000);
            monitorThread.interrupt(); // Interrupt the monitoring thread safely
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted!");
        }
    }
}
