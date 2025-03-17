package com.deependra.jdbc;

/*
PreparedStatement in JDBC:
PreparedStatement is an interface in JDBC that represents a precompiled SQL statement. It is used to execute
parameterized queries, making it more secure and efficient than the Statement interface.

Key Characteristics of PreparedStatement
-->Supports Parameterized Queries (Uses ? as placeholders for values).
-->Precompiled SQL: The query is compiled once and executed multiple times with different values.
-->Prevents SQL Injection: Since values are set separately, it reduces the risk of injection attacks.
-->Better Performance: Useful for batch executions and repeated query execution.

Methods in PreparedStatement:
    Method	                        Description
    setInt(int, int)	            Sets an integer value at the specified position.
    setString(int, String)	        Sets a string value at the specified position.
    setDouble(int, double)	        Sets a double value at the specified position.
    setBoolean(int, boolean)	    Sets a boolean value at the specified position.
    executeQuery()	                Executes a SELECT query and returns a ResultSet.
    executeUpdate()	                Executes an INSERT, UPDATE, DELETE query.
    executeBatch()	                Executes multiple SQL statements in batch processing.

Statement vs. PreparedStatement: Key Differences
    Feature	            Statement	                                PreparedStatement
    Query Type	        Static queries	                            Parameterized queries
    Security	        Prone to SQL Injection	                    Prevents SQL Injection
    Performance	        Compiles query every time	                Precompiled and optimized
    Use Case	        Simple, one-time queries	                Repeated execution with different values
    Example	            "SELECT * FROM users WHERE id = " + id;	    "SELECT * FROM users WHERE id = ?";

*/

import java.sql.*;
import java.util.Scanner;

public class PreparedStatementExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/BankDB";
        String user = "root";
        String password = "Password";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
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
                        scanner.nextLine(); // Consume newline
                        String name = scanner.nextLine();
                        System.out.print("Enter Account Number: ");
                        String accNumber = scanner.next();
                        String insertSQL = "INSERT INTO BankAccounts (AccountHolderName, AccountNumber, Balance) VALUES (?, ?, 0.00)";
                        PreparedStatement insertStmt = conn.prepareStatement(insertSQL);
                        insertStmt.setString(1, name);
                        insertStmt.setString(2, accNumber);
                        insertStmt.executeUpdate();
                        System.out.println("Account Created Successfully!");
                        break;

                    case 2:
                        // UPDATE - Deposit Money
                        System.out.print("Enter Account Number: ");
                        accNumber = scanner.next();
                        System.out.print("Enter Deposit Amount: ");
                        double depositAmount = scanner.nextDouble();
                        String depositSQL = "UPDATE BankAccounts SET Balance = Balance + ? WHERE AccountNumber = ?";
                        PreparedStatement depositStmt = conn.prepareStatement(depositSQL);
                        depositStmt.setDouble(1, depositAmount);
                        depositStmt.setString(2, accNumber);
                        int depositResult = depositStmt.executeUpdate();
                        System.out.println(depositResult > 0 ? "Amount Deposited Successfully!" : "Account Not Found!");
                        break;

                    case 3:
                        // UPDATE - Withdraw Money
                        System.out.print("Enter Account Number: ");
                        accNumber = scanner.next();
                        System.out.print("Enter Withdrawal Amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        String checkBalanceSQL = "SELECT Balance FROM BankAccounts WHERE AccountNumber = ?";
                        PreparedStatement checkBalanceStmt = conn.prepareStatement(checkBalanceSQL);
                        checkBalanceStmt.setString(1, accNumber);
                        ResultSet rs = checkBalanceStmt.executeQuery();
                        if (rs.next() && rs.getDouble("Balance") >= withdrawAmount) {
                            String withdrawSQL = "UPDATE BankAccounts SET Balance = Balance - ? WHERE AccountNumber = ?";
                            PreparedStatement withdrawStmt = conn.prepareStatement(withdrawSQL);
                            withdrawStmt.setDouble(1, withdrawAmount);
                            withdrawStmt.setString(2, accNumber);
                            withdrawStmt.executeUpdate();
                            System.out.println("Amount Withdrawn Successfully!");
                        } else {
                            System.out.println("Insufficient Balance or Account Not Found!");
                        }
                        break;

                    case 4:
                        // READ - Check Account Balance
                        System.out.print("Enter Account Number: ");
                        accNumber = scanner.next();
                        String selectSQL = "SELECT * FROM BankAccounts WHERE AccountNumber = ?";
                        PreparedStatement selectStmt = conn.prepareStatement(selectSQL);
                        selectStmt.setString(1, accNumber);
                        rs = selectStmt.executeQuery();
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
                        String deleteSQL = "DELETE FROM BankAccounts WHERE AccountNumber = ?";
                        PreparedStatement deleteStmt = conn.prepareStatement(deleteSQL);
                        deleteStmt.setString(1, accNumber);
                        int deleteResult = deleteStmt.executeUpdate();
                        System.out.println(deleteResult > 0 ? "Account Closed Successfully!" : "Account Not Found!");
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        scanner.close();
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
