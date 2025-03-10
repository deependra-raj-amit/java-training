package com.deependra.javabasics;

class Student {
    private String name;
    private int studentID;

    // Static variable (shared by all instances)
    private static int idCounter = 1000; // Starting student ID

    // Constructor
    public Student(String name) {
        this.name = name;
        this.studentID = idCounter; // Assign the current value of idCounter
        idCounter++; // Increment for the next student
    }

    // Method to display student details
    public void displayStudentInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Student ID: " + studentID);
    }
}


public class StaticExample {
    public static void main(String[] args) {
        // Registering students
        Student s1 = new Student("Deependra");
        Student s2 = new Student("Aman");
        Student s3 = new Student("Rahul");

        // Display student details
        s1.displayStudentInfo();
        System.out.println();
        s2.displayStudentInfo();
        System.out.println();
        s3.displayStudentInfo();
    }
}
