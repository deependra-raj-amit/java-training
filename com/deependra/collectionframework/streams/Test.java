package com.deependra.collectionframework.streams;

import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        Stream.iterate(0, x -> x+1)
                .forEach(System.out::println);
    }
}
