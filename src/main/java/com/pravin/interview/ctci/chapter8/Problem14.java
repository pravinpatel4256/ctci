package com.pravin.interview.ctci.chapter8;

public class Problem14 {

    public static void main(String[] args) {
        BooleanEvalution booleanEvalution = new BooleanEvalution();
        int count = booleanEvalution.countEvalInput("1^0|0|1", false);
        System.out.println(count);
    }
}
