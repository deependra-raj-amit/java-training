package javabasics;

public class ArrayDemo {
    public static void main(String[] args) {
        // 1. ONE-DIMENSIONAL ARRAY
        System.out.println("🔹 One-Dimensional Array:");
        int[] numbers = {10, 20, 30, 40, 50};

        // Traversing using for-loop
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        // Traversing using for-each loop
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println("\n");

        // **Use Case 1: Finding the Maximum Element**
        int max = numbers[0];
        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        System.out.println("Maximum element in 1D Array: " + max);
        System.out.println();


        // 2. TWO-DIMENSIONAL ARRAY
        System.out.println("🔹 Two-Dimensional Array:");
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Traversing 2D Array
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // **Use Case 2: Finding Sum of All Elements in 2D Array**
        int sum = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                sum += element;
            }
        }
        System.out.println("Sum of all elements in 2D Array: " + sum);
        System.out.println();


        // 3. JAGGED ARRAY (Different column sizes for each row)
        System.out.println("🔹 Jagged Array:");
        int[][] jaggedArray = new int[3][];
        jaggedArray[0] = new int[]{1, 2};         // Row 1 has 2 elements
        jaggedArray[1] = new int[]{3, 4, 5};      // Row 2 has 3 elements
        jaggedArray[2] = new int[]{6, 7, 8, 9};   // Row 3 has 4 elements

        // Traversing Jagged Array
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.print(jaggedArray[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // **Use Case 3: Finding Row with Maximum Sum in Jagged Array**
        int maxRowSum = 0, maxRowIndex = -1;
        for (int i = 0; i < jaggedArray.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < jaggedArray[i].length; j++) {
                rowSum += jaggedArray[i][j];
            }
            if (rowSum > maxRowSum) {
                maxRowSum = rowSum;
                maxRowIndex = i;
            }
        }
        System.out.println("Row with maximum sum is Row " + (maxRowIndex + 1) + " with sum " + maxRowSum);
    }
}

