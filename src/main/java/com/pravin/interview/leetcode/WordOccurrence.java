package com.pravin.interview.leetcode;

public class WordOccurrence {

    public static int count(String str, String target) {
        return (str.length() - str.replace(target, "").length())/target.length();
    }

    public static void main(String[] args) {
        String str = "helloslkhellodjladfjhello";
        String findStr = "hello";
        System.out.println(count(str, findStr));
    }
}
