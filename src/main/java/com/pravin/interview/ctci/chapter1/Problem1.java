package com.pravin.interview.ctci.chapter1;

public class Problem1 {

    public static void main(String[] args) {
        UniqueString uniqueString = new UniqueString();
        System.out.println( uniqueString.isUniqueChars("Hello how are you"));
        System.out.println( uniqueString.isUniqueChars("ABC"));

        System.out.println( uniqueString.isUniqueChars("Pravin"));
        System.out.println( uniqueString.isUniqueChars("book"));

    }
}
