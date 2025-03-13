package com.deependra.collectionframework;

/*
Definition of LinkedHashMap in Java
A LinkedHashMap in Java is a part of the java.util package that extends HashMap and maintains the
insertion order of elements. It stores key-value pairs like HashMap but uses a doubly linked list to
preserve the order in which elements were inserted.

Key Points of LinkedHashMap:
-Maintains Insertion Order – Unlike HashMap, it preserves the order in which keys were added.
-Uses a Doubly Linked List – Internally, it links entries in the sequence they were inserted.
-Provides Fast Access (O(1) on Average) – Just like HashMap, it offers constant-time operations for put, get, and remove.
-Allows One null Key and Multiple null Values – Similar to HashMap.
-Not Thread-Safe – Requires Collections.synchronizedMap() or ConcurrentHashMap for multi-threading.
-Supports Access-Order Mode – Can be configured to reorder elements based on recent access (accessOrder = true), useful for LRU (Least Recently Used) caching.
*/

import java.util.LinkedHashMap;
import java.util.Map;


/*
Banking System - LRU Cache for Recent Logins using LinkedHashMap
This program demonstrates how LinkedHashMap can be used to implement an LRU Cache
to store the most recent logins in a banking application.
*/

class RecentLoginCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    // Constructor to initialize the LRU cache with a fixed capacity
    public RecentLoginCache(int capacity) {
        super(capacity, 0.75f, true); // Access order is set to true for LRU behavior
        this.capacity = capacity;
    }

    // Overriding method to remove the oldest entry when cache limit is reached
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}

public class LinkedHashMapExample {
    public static void main(String[] args) {
        // Creating an LRU Cache for storing recent logins (max 3 recent logins)
        RecentLoginCache<Integer, String> recentLogins = new RecentLoginCache<>(3);

        // Simulating user logins (UserID -> Username)
        recentLogins.put(101, "Alice");
        recentLogins.put(102, "Bob");
        recentLogins.put(103, "Charlie");

        // Display current cache
        System.out.println("Recent Logins: " + recentLogins);

        // New login (removes least recently used entry)
        recentLogins.put(104, "David");  // This will remove Alice (LRU)

        System.out.println("After New Login: " + recentLogins);

        // Accessing an older entry (making it recently used)
        recentLogins.get(102);

        // New login (removes least recently used entry)
        recentLogins.put(105, "Eve");  // This will remove Charlie (LRU)

        System.out.println("Final Logins: " + recentLogins);
    }
}
