package com.deependra.multithreading;

/*Thread Class in Java?
The Thread class in Java is a built-in class in java.lang package that provides methods to create and
manage threads. It is used for concurrent execution of tasks by extending the Thread class or implementing
Runnable.

Key Points:
-->Defined in java.lang.Thread.
-->Used to create a thread by extending it.
-->Requires overriding the run() method to define execution logic.
-->Uses start() to begin thread execution.
-->Supports methods like sleep(), join(), interrupt(), and yield().
-->Supports multi-threading, improving application performance.*/


class ThreadExample extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread running: " + i);
            try {
                Thread.sleep(1000); // Pauses for 1 second
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        ThreadExample t1 = new ThreadExample();
        t1.start(); // Starts the thread
    }
}
