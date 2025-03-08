package com.deependra.oops;

class Cat {
    String name;  // Instance variable to store the cat's name

    // Constructor to initialize the Cat object
    Cat(String name) {
        this.name = name;
    }
}

public class ObjectMutationTest {
    public static void main(String[] args) {
        // Creating a new Cat object
        Cat myCat = new Cat("whiskers");

        // Printing the name before calling the method
        System.out.println("Before method call: " + myCat.name);

        // Calling the method that modifies the object's state
        changeCatName(myCat);

        // Printing the name after calling the method
        System.out.println("After method call: " + myCat.name);
    }

    // Mutator method that modifies the name of the Cat object
    public static void changeCatName(Cat cat) {
        cat.name = cat.name.toUpperCase();  // Changing the string reference inside the object
    }
}



/*
5 Key Learnings from This Method:
1. Objects in Java are passed by reference-like behavior – The memory address of the object is copied, so modifying fields inside the method affects the original object.
2. Mutator methods change an object’s state – The changeCatName() method modifies the name field of the passed object, making it uppercase.
3. Strings are immutable, but object fields can change – The String itself doesn't change, but we assign a new String (toUpperCase()) to the name field of the object.
4. Method parameters for objects work like aliases – cat inside changeCatName() refers to the same object as myCat in main(), so modifying cat.name also updates myCat.name.
5. Good practice: Use final keyword for immutability – If you don't want a method to modify an object's state, mark fields as final or use immutable objects.*/
