package com.pravin.interview.ctci.chapter1;

public class Problem1_4 {

    static boolean isPalindrome(String s) {

        String reversString = new StringBuilder(s).reverse().toString();
        return reversString.equals(s);
    }

    public static void main(String[] args) {

        System.out.println(isPalindrome("abcbcba"));
    }
}
