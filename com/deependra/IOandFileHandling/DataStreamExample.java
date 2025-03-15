package com.deependra.IOandFileHandling;

/*
A Data Stream in Java is a specialized stream that allows reading and writing primitive data types
(int, double, float, etc.) and String values in a machine-independent format.

Why Use Data Streams?
-->Reads/Writes Primitive Data Directly – No need to convert data types to bytes manually.
-->Platform Independent – Uses a standardized format, ensuring compatibility across different systems.
-->Efficient for Structured Data – Ideal for handling structured records like banking transactions or customer details.
-->Works with File and Network Streams – Used for saving/loading data efficiently.

Key Data Stream Classes and Methods
    Class	Type	    Description
    DataInputStream	    Byte Stream	Reads primitive data from an input stream.
    DataOutputStream	Byte Stream	Writes primitive data to an output stream.

Common Methods:
    Method	Description
    writeInt(int v)	Writes an int value.
    writeDouble(double v)	Writes a double value.
    writeUTF(String s)	Writes a String in UTF format.
    readInt()	Reads an int value.
    readDouble()	Reads a double value.
    readUTF()	Reads a String in UTF format.
    flush()	Ensures buffered data is written immediately.
    close()	Closes the stream and releases resources.


*/

import java.io.*;

public class DataStreamExample {
    public static void main(String[] args) {
        String file = "C:\\Users\\DEEPENDRA\\Downloads\\File handling demo file.txt";

        // Writing cheque transaction details using DataOutputStream
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            dos.writeLong(987654321012L); // Cheque Number
            dos.writeUTF("Amit Sharma"); // Issuer Name
            dos.writeUTF("Neha Verma"); // Payee Name
            dos.writeDouble(25000.75); // Amount
            dos.writeUTF("Cleared"); // Status
            dos.flush();
            System.out.println("Cheque transaction details stored successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading cheque transaction details using DataInputStream
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            long chequeNumber = dis.readLong();
            String issuerName = dis.readUTF();
            String payeeName = dis.readUTF();
            double amount = dis.readDouble();
            String status = dis.readUTF();

            System.out.println("\nRetrieved Cheque Transaction Details:");
            System.out.println("Cheque Number: " + chequeNumber);
            System.out.println("Issuer: " + issuerName);
            System.out.println("Payee: " + payeeName);
            System.out.println("Amount: $" + amount);
            System.out.println("Status: " + status);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

