package com.deependra.javabasics;

// Math Class Methods Demonstration
// 1. Math Class: Provides mathematical functions for calculations in Java (java.lang.Math).
// 2. Use Case: Useful in scientific computing, game development, financial calculations, etc.
// 3. Commonly Used Methods (Covered in This Code):
//    - Basic Operations: abs(), sqrt(), cbrt(), pow()
//    - Rounding & Precision: ceil(), floor(), round()
//    - Trigonometric: sin(), cos(), tan(), toDegrees(), toRadians()
//    - Logarithmic & Exponential: log(), log10(), exp()
//    - Min & Max: min(), max()
//    - Random Number Generation: random()

public class MathClassDemo {
    public static void main(String[] args) {
        System.out.println("------ Demonstrating Java Math Class Methods ------\n");

        // -------------------- Basic Operations --------------------

        // 1. Absolute Value: Math.abs(x) - Returns the absolute (positive) value of a number
        System.out.println("Absolute Value of -10: " + Math.abs(-10));

        // 2. Square Root: Math.sqrt(x) - Returns the square root of a number
        System.out.println("Square Root of 25: " + Math.sqrt(25));

        // 3. Cube Root: Math.cbrt(x) - Returns the cube root of a number
        System.out.println("Cube Root of 27: " + Math.cbrt(27));

        // 4. Power: Math.pow(x, y) - Returns x raised to the power of y
        System.out.println("2 raised to the power 5: " + Math.pow(2, 5));

        // -------------------- Rounding & Precision --------------------

        // 5. Ceil: Math.ceil(x) - Rounds up to the nearest whole number
        System.out.println("Ceil of 4.3: " + Math.ceil(4.3));

        // 6. Floor: Math.floor(x) - Rounds down to the nearest whole number
        System.out.println("Floor of 4.8: " + Math.floor(4.8));

        // 7. Round: Math.round(x) - Rounds to the nearest whole number
        System.out.println("Round of 4.5: " + Math.round(4.5));

        // -------------------- Trigonometric Functions --------------------

        // 8. Sine: Math.sin(angle) - Returns the sine of the angle (in radians)
        System.out.println("Sine of 90 degrees: " + Math.sin(Math.toRadians(90)));

        // 9. Cosine: Math.cos(angle) - Returns the cosine of the angle (in radians)
        System.out.println("Cosine of 0 degrees: " + Math.cos(Math.toRadians(0)));

        // 10. Tangent: Math.tan(angle) - Returns the tangent of the angle (in radians)
        System.out.println("Tangent of 45 degrees: " + Math.tan(Math.toRadians(45)));

        // 11. Convert Degrees to Radians: Math.toRadians(degrees)
        System.out.println("180 degrees in Radians: " + Math.toRadians(180));

        // 12. Convert Radians to Degrees: Math.toDegrees(radians)
        System.out.println("π Radians in Degrees: " + Math.toDegrees(Math.PI));

        // -------------------- Logarithmic & Exponential --------------------

        // 13. Natural Logarithm (Base e): Math.log(x) - Returns the natural logarithm of x
        System.out.println("Natural Log of e: " + Math.log(Math.E));

        // 14. Logarithm Base 10: Math.log10(x) - Returns the base-10 logarithm of x
        System.out.println("Log10 of 1000: " + Math.log10(1000));

        // 15. Exponential Function: Math.exp(x) - Returns e^x (e raised to the power x)
        System.out.println("e raised to power 2: " + Math.exp(2));

        // -------------------- Min & Max --------------------

        // 16. Minimum: Math.min(x, y) - Returns the smaller of two numbers
        System.out.println("Minimum of 15 and 9: " + Math.min(15, 9));

        // 17. Maximum: Math.max(x, y) - Returns the larger of two numbers
        System.out.println("Maximum of 15 and 9: " + Math.max(15, 9));

        // -------------------- Random Number Generation --------------------

        // 18. Random: Math.random() - Generates a random number between 0.0 and 1.0
        System.out.println("Random number between 0.0 and 1.0: " + Math.random());

        // Generating a random integer between 1 and 100
        int randomInt = (int) (Math.random() * 100) + 1;
        System.out.println("Random Integer between 1 and 100: " + randomInt);

    }
}
