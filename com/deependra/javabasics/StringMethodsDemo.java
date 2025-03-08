package com.deependra.javabasics;

public class StringMethodsDemo {
    public static void main(String[] args) {
        String str = "  Java Programming is Powerful  ";
        String str2 = "java programming is powerful";

        // 1. length()
        System.out.println("Length: " + str.length());

        // 2. charAt()
        System.out.println("Character at index 5: " + str.charAt(5));

        // 3. substring()
        System.out.println("Substring (5 to 16): " + str.substring(5, 16));

        // 4. contains()
        System.out.println("Contains 'Powerful'? " + str.contains("Powerful"));

        // 5. compareTo() (Lexicographical comparison)
        System.out.println("CompareTo (case-sensitive): " + str.compareTo(str2));
        System.out.println("CompareToIgnoreCase: " + str.compareToIgnoreCase(str2));

        // 6. equals() & equalsIgnoreCase()
        System.out.println("Equals: " + str.equals(str2));
        System.out.println("Equals Ignore Case: " + str.equalsIgnoreCase(str2));

        // 7. toUpperCase() & toLowerCase()
        System.out.println("Uppercase: " + str.toUpperCase());
        System.out.println("Lowercase: " + str.toLowerCase());

        // 8. trim() (Removes leading & trailing spaces)
        System.out.println("Trimmed String: '" + str.trim() + "'");

        // 9. replace() (Replace 'Powerful' with 'Awesome')
        System.out.println("Replaced String: " + str.replace("Powerful", "Awesome"));

        // 10. split() (Split string into words)
        String[] words = str.trim().split(" ");
        System.out.println("Words after split:");
        for (String word : words) {
            System.out.println(word);
        }

        // 11. indexOf() (Finds first occurrence of a word)
        System.out.println("Index of 'Programming': " + str.indexOf("Programming"));
        System.out.println("Index of 'X' (not found case): " + str.indexOf("X"));
    }
}
