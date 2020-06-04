package com.pravin.interview.ctci.chapter8;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problem6 {

    public static void main(String[] args) {

        int n = 10;
        Tower[] towers = new Tower[3];
        IntStream.range(0, 3).forEach(i -> towers[i] = new Tower(i));

        IntStream.range(n, 0).forEach(System.out::println);
        IntStream.range(0, n).map( i -> n - i - 1).forEach( disk -> towers[0].add(disk));


        Stream.of(towers).forEach(System.out::println);
        towers[0].moveDisks(n, towers[2], towers[1]);
        Stream.of(towers).forEach(System.out::println);
    }
}
