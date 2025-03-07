package javabasics;

public class Loops {
    public static void main(String[] args) {
        // 1. FOR LOOP - Print numbers from 1 to 5
        System.out.println("For Loop:");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\n");

        // 2. WHILE LOOP - Print numbers from 1 to 5
        System.out.println("While Loop:");
        int j = 1;
        while (j <= 5) {
            System.out.print(j + " ");
            j++;
        }
        System.out.println("\n");

        // 3. DO-WHILE LOOP - Print numbers from 1 to 5
        System.out.println("Do-While Loop:");
        int k = 1;
        do {
            System.out.print(k + " ");
            k++;
        } while (k <= 5);
        System.out.println("\n");

        // 4. FOR-EACH LOOP - Iterating over an array
        System.out.println("For-Each Loop:");
        int[] numbers = {10, 20, 30, 40, 50};
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println("\n");

        // 5. NESTED LOOP - Multiplication table for 1 to 3
        System.out.println("Nested Loop (Multiplication Table):");
        for (int x = 1; x <= 3; x++) {
            for (int y = 1; y <= 3; y++) {
                System.out.print(x * y + "\t");
            }
            System.out.println();
        }
        System.out.println();

        // ---- Real-world Use Cases ----

        // **Use Case 1: Finding Sum of First N Natural Numbers using FOR LOOP**
        int n = 10;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println("Sum of first 10 natural numbers: " + sum);

        // **Use Case 2: User Login with Limited Attempts (WHILE LOOP)**
        System.out.println("\nUser Login Simulation:");
        String correctPassword = "java123";
        String enteredPassword = "wrong"; // Simulating wrong password first
        int attempts = 3;
        while (!enteredPassword.equals(correctPassword) && attempts > 0) {
            System.out.println("Incorrect Password. Attempts left: " + (attempts - 1));
            attempts--;
            enteredPassword = "java123"; // Simulating user entering the correct password
        }
        if (enteredPassword.equals(correctPassword)) {
            System.out.println("Login Successful!");
        } else {
            System.out.println("Account Locked!");
        }

        // **Use Case 3: Menu-driven Program using DO-WHILE**
        System.out.println("\nSimple Menu:");
        int option;
        do {
            System.out.println("1. Say Hello");
            System.out.println("2. Say Goodbye");
            System.out.println("3. Exit");
            option = 3; // Simulating user input
            if (option == 1) {
                System.out.println("Hello!");
            } else if (option == 2) {
                System.out.println("Goodbye!");
            }
        } while (option != 3);
        System.out.println("Exited the program.");

        // **Use Case 4: Finding Maximum in an Array using FOR-EACH**
        int max = Integer.MIN_VALUE;
        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        System.out.println("\nMaximum number in array: " + max);
    }
}

