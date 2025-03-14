package com.deependra.datetime;

/*
Definition of ZonedDateTime and OffsetDateTime in Java
Java provides ZonedDateTime and OffsetDateTime in the java.time package to handle date-time operations with
time zones and offsets.
-ZonedDateTime represents date, time, and time zone (e.g., Asia/Kolkata, America/New_York).
-OffsetDateTime represents date, time, and fixed UTC offset (e.g., +05:30 for India).

Key Points about ZonedDateTime
-Includes Time Zone Information, making it useful for international banking operations.
-Handles Daylight Saving Time (DST) automatically.
-Supports Conversions between different time zones using withZoneSameInstant().
-Can Parse & Format timestamps with time zone using DateTimeFormatter.
-Used for Global Transactions to record the exact transaction time in different regions.

-Use Case: Cross-Border Transactions
Ensures transactions are recorded accurately across different time zones, avoiding confusion in global banking.


Key Points about OffsetDateTime
Includes UTC Offset, representing time with a fixed difference from UTC (e.g., +05:30).
More Lightweight than ZonedDateTime as it doesn’t store time zone rules.
Used for Standardized Timestamps in financial records and auditing.
Ensures Consistency Across Systems, even if they operate in different time zones.
Preferred for Storing Timestamps in databases for accurate historical records.

Use Case: Audit Logs for Transactions
Ensures consistent transaction logging across multiple banking servers using a fixed UTC offset.
*/

import java.time.ZonedDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class ZonedOffsetDateTimeExample {
    public static void main(String[] args) {
        // Use Case 1: Cross-Border Transaction Timestamp (ZonedDateTime)

        ZonedDateTime indiaTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        ZonedDateTime newYorkTime = indiaTime.withZoneSameInstant(ZoneId.of("America/New_York"));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss z");

        System.out.println("Transaction Time in India: " + indiaTime.format(dateTimeFormatter));
        System.out.println("Transaction Time in New York: " + newYorkTime.format(dateTimeFormatter));

        // Use Case 2: Transaction Audit Log (OffsetDateTime)

        OffsetDateTime transactionLogTime = OffsetDateTime.now();
        DateTimeFormatter offsetFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss X");

        System.out.println("Transaction Log Time (UTC Offset): " + transactionLogTime.format(offsetFormatter));
    }
}

