package com.deependra.collectionframework.list;

/*ArrayList in Java
Dynamic Resizing – Grows automatically when needed.
Maintains Insertion Order – Elements remain in the order they were added.
Allows Duplicates & Null Values – Supports duplicate elements and null.
Fast Random Access – get(index) takes O(1) time.
Slow Insertions/Deletions – Adding/removing in the middle is O(n) due to shifting.
Non-Synchronized – Not thread-safe; must be manually synchronized.
Initial Capacity – Default is 10, grows by 50% when full.
Implements List Interface – Supports all List methods (add(), remove(), get(), etc.)*/

import java.util.*;

class Customer {
    int accountNumber;
    String name;
    double balance;

    Customer(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account: " + accountNumber + ", Name: " + name + ", Balance: $" + balance;
    }
}

public class ArrayListExample {
    public static void main(String[] args) {
        // Creating a list to store customers
        List<Customer> customers = new ArrayList<>();

        // Adding new customers
        customers.add(new Customer(101, "Deependra Raj Amit", 5000.0));
        customers.add(new Customer(102, "Ravi Kumar", 7000.0));
        customers.add(new Customer(103, "Amit Sharma", 6500.0));

        // Display all customers (Using forEach method)
        System.out.println("All Customers:");
        customers.forEach(System.out::println);

        // Adding a customer at a specific index (insert operation)
        customers.add(1, new Customer(104, "Rakesh Yadav", 8000.0));

        System.out.println("\nAfter adding at index 1:");
        customers.forEach(System.out::println);

        // Fetching a customer by index
        System.out.println("\nCustomer at index 2: " + customers.get(2));

        // Updating customer details (Replacing element at index)
        customers.set(2, new Customer(105, "Manoj Verma", 6000.0));

        System.out.println("\nAfter updating index 2:");
        customers.forEach(System.out::println);

        // Removing a customer by index
        customers.remove(3);
        System.out.println("\nAfter removing customer at index 3:");
        customers.forEach(System.out::println);

        // Removing a customer by object reference
        customers.removeIf(c -> c.accountNumber == 101);
        System.out.println("\nAfter removing customer with Account Number 101:");
        customers.forEach(System.out::println);

        // Searching: Find the index of a customer
        int index = customers.indexOf(new Customer(104, "Rakesh Yadav", 8000.0));
        System.out.println("\nIndex of customer with Account Number 104: " + index);

        // Sorting customers based on balance
        customers.sort(Comparator.comparingDouble(c -> c.balance));
        System.out.println("\nCustomers sorted by balance:");
        customers.forEach(System.out::println);

        // Creating a sublist (VIP Customers with high balance)
        List<Customer> vipCustomers = customers.subList(0, 2);
        System.out.println("\nVIP Customers (Top 2 Richest):");
        vipCustomers.forEach(System.out::println);

        // Checking if the list is empty
        System.out.println("\nIs customer list empty? " + customers.isEmpty());

        // Finding size of the list
        System.out.println("Total number of customers: " + customers.size());

        // Converting list to array for database operations
        Customer[] customerArray = customers.toArray(new Customer[0]);
        System.out.println("\nCustomer array:");
        for (Customer c : customerArray) {
            System.out.println(c);
        }

        // Clearing all customer records
        customers.clear();
        System.out.println("\nAfter clearing all customers, is list empty? " + customers.isEmpty());
    }
}
