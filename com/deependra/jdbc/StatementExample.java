package com.deependra.jdbc;

/*
The Statement interface is one of the core components of JDBC, used to execute static SQL queries.
It allows sending SQL commands to the database without parameterization, meaning it does not support
input placeholders (?).

Key Characteristics of Statement Interface:
-->Executes SQL Queries Directly: It sends queries as plain text to the database.
-->No Parameterized Queries: Unlike PreparedStatement, it does not allow parameterized queries, making it
   prone to SQL injection attacks.
-->Simple CRUD Operations: Useful for executing basic Create, Read, Update, and Delete (CRUD) operations.
-->Less Secure: Since input values are directly concatenated into SQL queries, it can be exploited if user
   input is not validated properly.
-->Suitable for Static Queries: Best used when query statements do not change dynamically.

DriverManager (Class in JDBC):
DriverManager is a built-in JDBC class that manages database drivers and establishes connections to
the database.

Connection (Interface in JDBC)
Connection represents an active connection to the database, allowing execution of SQL queries.
*/

import java.sql.*;
import java.util.Scanner;

public class StatementExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/BankDB";
        String user = "root";  // Change to your MySQL username
        String password = "Password";  // Change to your MySQL password

        try {
            // Load MySQL Driver (Optional for JDBC 4.0+)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nBANKING SYSTEM");
                System.out.println("1. Open Account");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Check Balance");
                System.out.println("5. Close Account");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        // CREATE - Open a New Account
                        System.out.print("Enter Account Holder Name: ");
                        scanner.nextLine();  // Consume newline
                        String name = scanner.nextLine();
                        System.out.print("Enter Account Number: ");
                        String accNumber = scanner.next();
                        String insertSQL = "INSERT INTO BankAccounts (AccountHolderName, AccountNumber, Balance) VALUES ('"
                                + name + "', '" + accNumber + "', 0.00)";
                        stmt.executeUpdate(insertSQL);
                        System.out.println("Account Created Successfully!");
                        break;

                    case 2:
                        // UPDATE - Deposit Money
                        System.out.print("Enter Account Number: ");
                        accNumber = scanner.next();
                        System.out.print("Enter Deposit Amount: ");
                        double depositAmount = scanner.nextDouble();
                        String depositSQL = "UPDATE BankAccounts SET Balance = Balance + " + depositAmount +
                                " WHERE AccountNumber = '" + accNumber + "'";
                        int depositResult = stmt.executeUpdate(depositSQL);
                        if (depositResult > 0)
                            System.out.println("Amount Deposited Successfully!");
                        else
                            System.out.println("Account Not Found!");
                        break;

                    case 3:
                        // UPDATE - Withdraw Money
                        System.out.print("Enter Account Number: ");
                        accNumber = scanner.next();
                        System.out.print("Enter Withdrawal Amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        // Check balance first
                        String checkBalanceSQL = "SELECT Balance FROM BankAccounts WHERE AccountNumber = '" + accNumber + "'";
                        ResultSet rs = stmt.executeQuery(checkBalanceSQL);
                        if (rs.next() && rs.getDouble("Balance") >= withdrawAmount) {
                            String withdrawSQL = "UPDATE BankAccounts SET Balance = Balance - " + withdrawAmount +
                                    " WHERE AccountNumber = '" + accNumber + "'";
                            stmt.executeUpdate(withdrawSQL);
                            System.out.println("Amount Withdrawn Successfully!");
                        } else {
                            System.out.println("Insufficient Balance or Account Not Found!");
                        }
                        break;

                    case 4:
                        // READ - Check Account Balance
                        System.out.print("Enter Account Number: ");
                        accNumber = scanner.next();
                        String selectSQL = "SELECT * FROM BankAccounts WHERE AccountNumber = '" + accNumber + "'";
                        rs = stmt.executeQuery(selectSQL);
                        if (rs.next()) {
                            System.out.println("Account Holder: " + rs.getString("AccountHolderName"));
                            System.out.println("Balance: $" + rs.getDouble("Balance"));
                        } else {
                            System.out.println("Account Not Found!");
                        }
                        break;

                    case 5:
                        // DELETE - Close Account
                        System.out.print("Enter Account Number: ");
                        accNumber = scanner.next();
                        String deleteSQL = "DELETE FROM BankAccounts WHERE AccountNumber = '" + accNumber + "'";
                        int deleteResult = stmt.executeUpdate(deleteSQL);
                        if (deleteResult > 0)
                            System.out.println("Account Closed Successfully!");
                        else
                            System.out.println("Account Not Found!");
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        scanner.close();
                        stmt.close();
                        conn.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid Option! Try Again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
