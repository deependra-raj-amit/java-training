package javabasics;

import java.util.Scanner;

public class RelationalOperators {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Salary Comparison
        System.out.print("Enter salary of Employee 1: ");
        double salary1 = scanner.nextDouble();
        System.out.print("Enter salary of Employee 2: ");
        double salary2 = scanner.nextDouble();

        if (salary1 > salary2) {
            System.out.println("Employee 1 has a higher salary.");
        } else if (salary1 < salary2) {
            System.out.println("Employee 2 has a higher salary.");
        } else {
            System.out.println("Both employees have the same salary.");
        }

        // Finding the Maximum of Three Numbers
        System.out.print("Enter three numbers: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int max = (a > b) ? (a > c ? a : c) : (b > c ? b : c);  // Using '>' relational operator
        System.out.println("Maximum number: " + max);

        scanner.close();
    }
}
