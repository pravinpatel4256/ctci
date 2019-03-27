package com.pravin.interview.arrays;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class ArrayManipulation {

    static long arrayManipulation(int n, int[][] queries) {

        int a[] = IntStream.generate(() -> 0).limit(n).toArray();
        int len = queries.length;

        for (int i = 0; i <= len -1 ; ++i) {
            for(int j = queries[i][0] - 1;  j < queries[i][1]; ++j){
                a[j] = a[j] + queries[i][2];
            }
        }

        //  Arrays.stream(a).mapToObj(x ->x+" ").forEach(System.out::print);
        OptionalInt op = Arrays.stream(a).max();
        if (op.isPresent()) {
            return op.getAsInt();
        }
        return 0;
    }
}
