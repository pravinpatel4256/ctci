package com.pravin.interview.ctci.moderate;

public class TrainlingZeroOfFactorial {

    Integer factorial(int n) {

        if (n == 0) {
            return 1;
        }

        return n * factorial(n - 1);

    }

    public static void main(String[] args) {
        TrainlingZeroOfFactorial zero = new TrainlingZeroOfFactorial();
        System.out.println(zero.factorial(10));
    }
}
