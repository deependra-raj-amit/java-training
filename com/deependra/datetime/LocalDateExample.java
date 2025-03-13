package com.deependra.datetime;

/*
Definition of Java Date-Time API (java.time Package)
Java Date-Time API (java.time) provides a comprehensive framework for handling date and time operations
in Java applications. It was introduced in Java 8 to replace the outdated java.util.Date and java.util.Calendar,
offering better clarity, immutability, and time-zone support.

Key Points about Java Date-Time API
-Immutability & Thread Safety: All date-time classes are immutable, making them safe for multi-threaded applications.
-Clear API Design: Provides well-structured classes such as LocalDate, LocalTime, LocalDateTime, and ZonedDateTime.
-Time Zone Support: Supports different time zones using ZoneId and ZonedDateTime.
-Better Formatting & Parsing: Uses DateTimeFormatter for flexible date-time representation.
-Arithmetic Operations: Allows easy addition/subtraction of days, months, or years using plus() and minus() methods.
*/

//Loan Due Date Calculation

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateExample {
    public static void main(String[] args) {
        // Loan issued on this date
        LocalDate loanStartDate = LocalDate.of(2024, 3, 13);

        // Loan tenure in years
        int tenureInYears = 5;

        // Calculate the loan due date
        LocalDate loanDueDate = loanStartDate.plusYears(tenureInYears);

        // Format the output for better readability
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");

        System.out.println("Loan Issued Date: " + loanStartDate.format(formatter));
        System.out.println("Loan Due Date: " + loanDueDate.format(formatter));
    }
}

