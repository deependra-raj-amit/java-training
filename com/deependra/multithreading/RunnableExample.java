package com.deependra.multithreading;

/*Runnable Interface?
The Runnable interface in Java is a functional interface (public interface Runnable { void run(); })
used to define a thread's execution logic without extending Thread. It allows for better object-oriented
design by enabling a class to extend another class while still running as a thread.

Key Points about Runnable:
-->Implemented by classes to define thread logic.
-->Requires passing the Runnable instance to a Thread object.
-->Encourages better design by separating the thread logic from thread execution.
-->Uses run() method to define execution.
-->The start() method must be called on the Thread instance.*/

class RunnableExample implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Runnable running: " + i);
            try {
                Thread.sleep(1000); // Pauses for 1 second
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        RunnableExample runnable = new RunnableExample();
        Thread t1 = new Thread(runnable); // Creating Thread using Runnable
        t1.start(); // Starts the thread
    }
}
