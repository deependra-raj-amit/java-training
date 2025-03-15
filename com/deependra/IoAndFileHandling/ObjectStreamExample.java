package com.deependra.IoAndFileHandling;

import java.io.*;

// Bank Employee class implementing Serializable
class BankEmployee implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L; // Ensures compatibility during deserialization
    private int employeeID;
    private String name;
    private String designation;
    private double salary;
    private String department;

    // Constructor
    public BankEmployee(int employeeID, String name, String designation, double salary, String department) {
        this.employeeID = employeeID;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.department = department;
    }

    // Display Employee Details
    public void displayEmployeeInfo() {
        System.out.println("\nEmployee Details:");
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Name: " + name);
        System.out.println("Designation: " + designation);
        System.out.println("Salary: $" + salary);
        System.out.println("Department: " + department);
    }
}

public class ObjectStreamExample {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\DEEPENDRA\\Downloads\\File handling demo file.txt";

        // Creating a BankEmployee object
        BankEmployee employee = new BankEmployee(1001, "Rahul Verma", "Branch Manager", 75000, "Loans");

        // Writing Employee Object using ObjectOutputStream
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(employee);
            System.out.println("Employee record saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading Employee Object using ObjectInputStream
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            BankEmployee retrievedEmployee = (BankEmployee) ois.readObject();
            retrievedEmployee.displayEmployeeInfo();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

