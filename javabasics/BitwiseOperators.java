package javabasics;

public class BitwiseOperators {
    public static void main(String[] args) {
        int a = 5;  // Binary:  0101
        int b = 3;  // Binary:  0011

        // 1. Bitwise AND (&) - Used in permission flags
        System.out.println("Bitwise AND: " + (a & b)); // 0101 & 0011 = 0001 (1)

        // 2. Bitwise OR (|) - Used to enable specific flags
        System.out.println("Bitwise OR: " + (a | b)); // 0101 | 0011 = 0111 (7)

        // 3. Bitwise XOR (^) - Used in encryption
        System.out.println("Bitwise XOR: " + (a ^ b)); // 0101 ^ 0011 = 0110 (6)

        // 4. Bitwise NOT (~) - Used to find the complement
        System.out.println("Bitwise NOT (~a): " + (~a)); // ~0101 = 1010 (Negative representation)

        // 5. Left Shift (<<) - Used in fast multiplication
        int leftShift = a << 1; // Multiplies by 2
        System.out.println("Left Shift (a << 1): " + leftShift); // 0101 << 1 = 1010 (10)

        // 6. Right Shift (>>) - Used in fast division
        int rightShift = a >> 1; // Divides by 2
        System.out.println("Right Shift (a >> 1): " + rightShift); // 0101 >> 1 = 0010 (2)

        // 7. Unsigned Right Shift (>>>) - Used in binary operations (fills 0 from left)
        int negative = -8; // Binary: 1111 1000 (32-bit representation)
        System.out.println("Signed Right Shift (-8 >> 2): " + (negative >> 2));
        System.out.println("Unsigned Right Shift (-8 >>> 2): " + (negative >>> 2));

        // ---- Real-world Use Cases ----

        // **Use Case 1: Checking Even or Odd using Bitwise AND**
        int num = 10;
        if ((num & 1) == 0) {
            System.out.println(num + " is Even");
        } else {
            System.out.println(num + " is Odd");
        }

        // **Use Case 2: Swapping two numbers without a temp variable (using XOR)**
        int x = 5, y = 10;
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("After Swapping: x = " + x + ", y = " + y);

        // **Use Case 3: Multiply by 2 using Left Shift**
        int value = 4;
        System.out.println("Multiply by 2 using <<: " + (value << 1)); // 4 * 2 = 8

        // **Use Case 4: Divide by 2 using Right Shift**
        System.out.println("Divide by 2 using >>: " + (value >> 1)); // 4 / 2 = 2
    }
}
