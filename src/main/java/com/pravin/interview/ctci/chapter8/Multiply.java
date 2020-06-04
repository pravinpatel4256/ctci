package com.pravin.interview.ctci.chapter8;

public class Multiply {

    public int multiply(int a, int b){
        int smaller = Math.min(a, b);
        int bigger = Math.max(a,b);
        int[] memo = new int[smaller + 1];
        return multiply(smaller, bigger, memo);

    }

    private int multiply(int smaller, int bigger, int[] memo) {

        if (smaller == 0) {
            return  0;

        }
        else if (smaller == 1) {
            return  bigger;
        }
        else if (memo[smaller] != 0) {
            return  memo[smaller];
        }

        int s = smaller/2;
        int side1 = multiply(s, bigger, memo);

        int side2 = side1;

        if (smaller%2 == 1) {
            side2 = multiply(smaller - s, bigger, memo);
        }

        memo[smaller] = side1 + side2;
        return memo[smaller];
    }


    public int simpleMultiply(int x, int y) {
        if (y == 0) return 0;
        if (y <= 0) return -simpleMultiply(x, -y);
        return x + simpleMultiply(x, y - 1);

    }
}
