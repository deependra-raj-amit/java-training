package com.deependra.collectionframework.streams;

/*
Lambda Expression
-->A Lambda Expression is a short way to implement functional interfaces in Java. It provides a concise
   syntax to define anonymous functions.
-->Syntax=> (parameter) -> expression   or  (parameter) -> { statements }

Key Points:
-->Used to implement functional interfaces (interfaces with a single abstract method).
-->Removes boilerplate code (no need for class or method definitions).
-->Improves readability and maintainability.
-->Works with streams, collections, and functional interfaces (Function, Predicate, Consumer, etc.).

===============================================================================================================

Predicate
-->A Predicate is a built-in functional interface (java.util.function.Predicate<T>) that tests a condition
   on an input and returns true or false.
-->Syntax==> Predicate<T> predicate = (T t) -> boolean_expression;

 Key Points:
-->Used for filtering data based on conditions.
-->Returns boolean (true or false).
-->Works with Streams, Collections, and Filtering operations.

Methods of Predicates:
    Method	                Description
    test(T t)	            Tests the condition on input T and returns true or false
    and(Predicate other)	Combines two predicates (&& condition)
    or(Predicate other)	    Combines two predicates (`
    negate()	            Negates the result (!condition)
    not(Predicate<T> p)	    Returns a predicate that negates the given predicate (alternative to negate()).
                            (Available from Java 11)
    isEqual(Object target)	Returns a predicate that tests if the input is equal to the given object.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class BankAccount {
    String accountHolder;
    double balance;

    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return accountHolder + " - ₹" + balance;
    }
}

public class LambdaPredicateExample {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new BankAccount("Donald", 15000));
        accounts.add(new BankAccount("Peter", 8000));
        accounts.add(new BankAccount("John", 12000));
        accounts.add(new BankAccount("David", 5000));
        accounts.add(new BankAccount("Harley", 10000));

        // Predicate to check if balance is greater than ₹10,000
        Predicate<BankAccount> highBalance = acc -> acc.balance > 10000;

        // Filtering high-balance accounts using Lambda & Predicate
        accounts.stream()
                .filter(highBalance)  // Using Predicate
                .forEach(System.out::println);  // Print accounts with balance > ₹10,000
    }
}

