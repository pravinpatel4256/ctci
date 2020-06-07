package com.pravin.interview.ctci.chapter1;

public class Problem3 {

    public static void main(String[] args) {
        URLfi urLfi = new URLfi();
        String s = "pravin patel how are you.";
        System.out.println( urLfi.urlFi(s + "                ", s.length()));
    }
}
