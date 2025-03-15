package com.deependra.IoAndFileHandling;

/*
Object Streams in Java are used to serialize (convert an object into a byte stream) and deserialize
(reconstruct an object from a byte stream). This allows objects to be saved to a file, transmitted over a
network, or stored in a database while preserving their state.

Key Points:
-->Serialization & Deserialization: Converts objects into a format that can be stored or transferred and later reconstructed.
-->Implements Serializable Interface: The class whose objects need to be serialized must implement the Serializable interface.
-->Uses ObjectOutputStream & ObjectInputStream: These classes help in writing and reading objects.
-->Preserves Object State: Object streams maintain the state of objects while saving or transmitting them.
-->serialVersionUID (Version Control): Helps avoid compatibility issues when deserializing objects of different versions.
-->Supports Deep Copying: Serialized objects can be deep-copied by writing and reading them back.

Important Methods in Object Streams:
ObjectOutputStream (Writing Objects)
    Method	                    Description
    writeObject(Object obj)	    Serializes an object and writes it to an output stream.
    flush()	                    Ensures that all data is completely written to the destination.
    close()	                    Closes the output stream.

ObjectInputStream (Reading Objects)
    Method	Description
    readObject()	Reads and deserializes an object from an input stream.
    close()	        Closes the input stream.

*/


import java.io.*;

/*
A bank maintains confidential employee records, including Employee ID, Name, Designation, Salary,
and Department. Object Streams allow efficient storage, retrieval, and security of employee data for
HR operations.

*/



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

