package com.deependra.collectionframework;
import java.util.Vector;

/*Definition of Vector in Java:
Vector is a resizable array that implements the List interface and provides thread-safe
operations. It is synchronized, meaning multiple threads can access it without causing concurrency
issues. It automatically grows when elements are added beyond its initial capacity.

Key Points of Vector:
-Thread-Safe & Synchronized: Methods in Vector are synchronized, making it safe for multi-threaded environments.
-Dynamic Resizing: Expands automatically when more elements are added, typically doubling its size.
-Allows Duplicates & Maintains Order: Elements are stored in insertion order and duplicates are permitted.
-Legacy but Still Used: Although replaced by ArrayList in single-threaded applications, Vector is used in
 banking, trading, and financial applications where synchronization is needed.
-Higher Memory Consumption: Since it grows by doubling capacity, it may lead to more unused memory allocation.
-Provides Enumeration & Iterator: Supports both Enumeration (legacy) and Iterator for traversing elements.

loan processing is a real-world banking function where multiple employees manage applications simultaneously.
Since Vector is thread-safe and synchronized, it ensures data consistency when updating loan records.
The program demonstrates key Vector operations like adding, updating, removing, searching, and
optimizing storage
        */

class LoanApplication {
    int applicationId;
    String customerName;
    double loanAmount;
    String status; // Pending, Approved, Rejected

    public LoanApplication(int applicationId, String customerName, double loanAmount, String status) {
        this.applicationId = applicationId;
        this.customerName = customerName;
        this.loanAmount = loanAmount;
        this.status = status;
    }

    @Override
    public String toString() {
        return "LoanApplication { ID: " + applicationId + ", Name: " + customerName +
                ", Amount: $" + loanAmount + ", Status: " + status + " }";
    }
}

public class VectorExample {
    public static void main(String[] args) {
        // Creating a synchronized list of loan applications
        Vector<LoanApplication> loanApplications = new Vector<>();

        // 1. Adding new loan applications
        loanApplications.add(new LoanApplication(101, "Rahul Sharma", 500000, "Pending"));
        loanApplications.add(new LoanApplication(102, "Priya Singh", 250000, "Pending"));
        loanApplications.add(new LoanApplication(103, "Anil Verma", 700000, "Pending"));

        // 2. Fetching and displaying loan applications
        System.out.println("All Loan Applications: " + loanApplications);

        // 3. Approving a loan application (Updating a record)
        for (LoanApplication loan : loanApplications) {
            if (loan.applicationId == 102) {  // Suppose Priya Singh's loan is approved
                loan.status = "Approved";
                break;
            }
        }
        System.out.println("After Approval Update: " + loanApplications);

        // 4. Removing rejected loan applications (Deleting a record)
        loanApplications.removeIf(loan -> loan.applicationId == 103); // Removing Anil Verma's rejected loan
        System.out.println("After Removing Rejected Loan: " + loanApplications);

        // 5. Checking if a particular loan application exists
        boolean exists = loanApplications.stream()
                .anyMatch(loan -> loan.applicationId == 101);
        System.out.println("Is Loan Application 101 Present? " + exists);

        // 6. Finding the index of a loan application
        int index = -1;
        for (int i = 0; i < loanApplications.size(); i++) {
            if (loanApplications.get(i).applicationId == 101) {
                index = i;
                break;
            }
        }
        System.out.println("Index of Loan Application 101: " + index);

        // 7. Getting the first and last application
        System.out.println("First Loan Application: " + loanApplications.firstElement());
        System.out.println("Last Loan Application: " + loanApplications.lastElement());

        // 8. Checking the total number of loan applications
        System.out.println("Total Loan Applications: " + loanApplications.size());

        // 9. Optimizing memory by trimming unused capacity
        System.out.println("Initial Capacity: " + loanApplications.capacity());
        loanApplications.trimToSize();
        System.out.println("Optimized Capacity: " + loanApplications.capacity());

        // 10. Clearing all applications after processing is completed
        loanApplications.clear();
        System.out.println("All Loan Applications Cleared: " + loanApplications);
    }
}
