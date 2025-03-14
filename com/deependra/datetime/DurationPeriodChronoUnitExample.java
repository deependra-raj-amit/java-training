package com.deependra.datetime;

/*
Definition of Duration, Period, and ChronoUnit in Java
Java provides Duration, Period, and ChronoUnit in the java.time package to handle time intervals between dates and times.

--Duration represents an exact time-based amount (e.g., hours, minutes, seconds).
--Period represents a date-based amount (e.g., years, months, days).
--ChronoUnit provides unit-based time manipulation (e.g., DAYS, HOURS, SECONDS).

==>Key Points about Duration
-->Measures time intervals in hours, minutes, seconds, and nanoseconds.
-->Used for precise time calculations (e.g., transaction processing time).
-->Supports arithmetic operations like plus(), minus(), and between().
-->Can be extracted from Instant or LocalTime for measuring execution time.
-->Best for short durations, such as millisecond precision timing.

Use Case: Transaction Processing Time Calculation

==>Key Points about Period
-->Represents a date-based duration (years, months, days).
-->Used for age calculations and loan tenures.
-->Supports addition/subtraction operations on LocalDate.
-->Provides between() method to calculate differences in dates.
-->Best for long-term calculations like loan repayment schedules.

Use Case: Loan Tenure Calculation

==>Key Points about ChronoUnit
-->Defines time-based units like DAYS, MONTHS, YEARS, HOURS, etc.
-->Works with any date-time type for unit-based arithmetic.
-->Supports between() method for easy time difference calculations.
-->Can be used to truncate date-time values to a certain unit (e.g., truncate to DAYS).
-->More flexible than Duration and Period for general time-based operations.

Use Case: Interest Calculation for Fixed Deposit

*/

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DurationPeriodChronoUnitExample {
    public static void main(String[] args) {
        // Use Case 1: Transaction Processing Time (Duration)
        Instant transactionStart = Instant.now();

        // Simulating transaction process delay
        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }

        Instant transactionEnd = Instant.now();
        Duration transactionTime = Duration.between(transactionStart, transactionEnd);

        System.out.println("Transaction Processing Time: " + transactionTime.toMillis() + " ms");

        // Use Case 2: Loan Tenure Calculation (Period)
        LocalDate loanStartDate = LocalDate.of(2020, 3, 15);
        LocalDate loanEndDate = LocalDate.of(2025, 3, 15);
        Period loanTenure = Period.between(loanStartDate, loanEndDate);

        System.out.println("Loan Tenure: " + loanTenure.getYears() + " Years, " +
                loanTenure.getMonths() + " Months, " + loanTenure.getDays() + " Days");

        // Use Case 3: Fixed Deposit Interest Calculation (ChronoUnit)
        LocalDate depositDate = LocalDate.of(2023, 1, 1);
        LocalDate maturityDate = LocalDate.of(2025, 1, 1);
        long daysBetween = ChronoUnit.DAYS.between(depositDate, maturityDate);

        System.out.println("Fixed Deposit Duration: " + daysBetween + " Days");
    }
}
