package com.deependra.datetime;

/*
Definition of LocalTime and LocalDateTime in Java
Java provides LocalTime and LocalDateTime in the java.time package to handle time-related operations efficiently.

-LocalTime represents only time (hours, minutes, seconds, nanoseconds) without a date or time zone.
-LocalDateTime represents both date and time but does not consider time zones.

Key Points about LocalTime
-Represents only time (hours, minutes, seconds, nanoseconds) without a date.
-Immutable & Thread-Safe, ensuring safe multi-threading operations.
-Supports Comparisons using methods like isBefore(), isAfter(), and equals().
-Allows Arithmetic Operations such as plusHours(), minusMinutes(), etc.
-Used for Time-Based Validations, like checking business hours.

-Use Case: Business Hours Validation
-Ensures that transactions or customer service requests are processed only during banking hours.
-Key Points about LocalDateTime
-Represents both Date & Time without considering time zones.
-Stores timestamps for records like transactions, logs, and event tracking.
-Allows Date-Time Arithmetic such as adding/subtracting days, hours, or minutes.
-Supports Formatting & Parsing using DateTimeFormatter.
-Used for Recording Events with timestamps.
*/

import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeExample {
    public static void main(String[] args) {
        // Use Case 1: Business Hours Validation (LocalTime)
        LocalTime bankOpeningTime = LocalTime.of(9, 0);  // Bank opens at 9:00 AM
        LocalTime bankClosingTime = LocalTime.of(17, 0); // Bank closes at 5:00 PM
        LocalTime currentTime = LocalTime.now();

        if (currentTime.isAfter(bankOpeningTime) && currentTime.isBefore(bankClosingTime)) {
            System.out.println("Bank is OPEN (Current Time: " + currentTime + ")");
        } else {
            System.out.println("Bank is CLOSED (Current Time: " + currentTime + ")");
        }

        // Use Case 2: Transaction Timestamp (LocalDateTime)
        LocalDateTime transactionTimestamp = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss");

        System.out.println("Transaction Time: " + transactionTimestamp.format(dateTimeFormatter));
    }
}

