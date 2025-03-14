package com.deependra.multithreading;

/*
==>join() → Makes the current thread wait until another thread finishes execution.
==>yield() → Suggests the scheduler to temporarily pause the current thread and allow other threads to execute.
==>currentThread() → Returns a reference to the currently executing thread.
==>daemon() → Checks whether a thread is running as a background (daemon) thread.
==>setDaemon(true) → Marks a thread as a daemon, meaning it will run in the background and terminate when all user threads finish execution.

Program: Customer Account Verification System (Using Synchronization & Concurrency Methods)
This program simulates a **Bank's Customer Account Verification Process**, where:
-->DocumentVerificationThread checks submitted documents.
-->BackgroundCheckThread waits for document verification to complete before running (uses `join()`).
-->RiskAssessmentThread evaluates risk but gives priority to background checks (uses `yield()`).
-->AuditLoggingThread runs as a **daemon thread**, continuously maintaining verification logs.

Thread Methods Demonstrated:
==>join() - Ensures document verification completes before background checks start.
==>yield() - Allows background check to execute before risk assessment.
==>currentThread() - Identifies the currently executing thread.
==>daemon() & setDaemon(true) - Keeps logging running in the background.
 */

class DocumentVerificationThread extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " (Document Verification) - Checking submitted documents...");
        try {
            Thread.sleep(2000); // Simulating document verification delay
        } catch (InterruptedException e) {
            System.out.println("Document verification interrupted.");
        }
        System.out.println(Thread.currentThread().getName() + " (Document Verification) - Documents verified successfully.");
    }
}

class BackgroundCheckThread extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " (Background Check) - Waiting for document verification...");

        DocumentVerificationThread documentVerification = new DocumentVerificationThread();
        documentVerification.start();

        try {
            documentVerification.join(); // Ensures background check starts only after document verification
        } catch (InterruptedException e) {
            System.out.println("Background check interrupted.");
        }

        System.out.println(Thread.currentThread().getName() + " (Background Check) - Performing background verification...");
        try {
            Thread.sleep(3000); // Simulating background check processing
        } catch (InterruptedException e) {
            System.out.println("Background check interrupted.");
        }
        System.out.println(Thread.currentThread().getName() + " (Background Check) - Background check completed!");
    }
}

class RiskAssessmentThread extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " (Risk Assessment) - Assessing risk level...");
        Thread.yield(); // Allowing background check to complete first

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Risk assessment interrupted.");
        }
        System.out.println(Thread.currentThread().getName() + " (Risk Assessment) - Risk assessment completed.");
    }
}

class AuditLoggingThread extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " (Audit Logging) - Running in background...");
        while (true) {
            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " (Audit Logging) - Logs updated.");
            } catch (InterruptedException e) {
                System.out.println("Audit logging interrupted.");
            }
        }
    }
}

public class SynchronizationConcurrencyMethods {
    public static void main(String[] args) {
        System.out.println("Initiating Customer Account Verification Process...");

        BackgroundCheckThread backgroundCheck = new BackgroundCheckThread();
        RiskAssessmentThread riskAssessment = new RiskAssessmentThread();
        AuditLoggingThread auditLogging = new AuditLoggingThread();

        // Naming the threads
        backgroundCheck.setName("BackgroundCheck-Thread");
        riskAssessment.setName("RiskAssessment-Thread");
        auditLogging.setName("AuditLogging-Thread");

        // Setting audit logging as a daemon thread
        auditLogging.setDaemon(true);

        // Starting the threads
        auditLogging.start(); // Daemon thread
        backgroundCheck.start();
        riskAssessment.start();
    }
}
