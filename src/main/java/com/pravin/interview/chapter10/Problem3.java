package com.pravin.interview.chapter10;

public class Problem3 {

    public static void main(String[] args) {

        SearchRotatedArray searchRotatedArray = new SearchRotatedArray();

        int[] a = {50, 5, 10, 20, 30,40};

        int[] a2 = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};

        int[] a3 = {15, 16, 17, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9, 10, 12};

        System.out.println( searchRotatedArray.search(a, 5));
        System.out.println( searchRotatedArray.search(a2, 4));
        System.out.println( searchRotatedArray.search(a3, 9));
    }
}
