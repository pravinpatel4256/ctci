package com.pravin.interview.ctci.chapter10;

import java.util.Arrays;

public class Problem1 {

    public static void main(String[] args) {
        SortedMerge sortedMerge = new SortedMerge();
        int a[] = {2, 5, 8, 9, 10, 12, 19, 0, 0, 0, 0, 0};
        int b[] = { 1, 3, 4, 6,7};
        sortedMerge.sortAndMerge(a, b, 6,5);

        Arrays.stream(a).forEach(aa -> System.out.print(" "+aa));


    }
}
