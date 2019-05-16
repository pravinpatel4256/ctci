package com.pravin.interview.chapter1;

public class Problem5 {

    public static void main(String[] args) {

        OneEditAway  oneEditAway = new OneEditAway();
        String s1 = "pale";
        String s2 = "ple";
        System.out.println(oneEditAway.isOneEditAway(s1,s2));
        System.out.println(oneEditAway.isOneEditAway("pales","pale"));
        System.out.println(oneEditAway.isOneEditAway("pale","palep"));
        System.out.println(oneEditAway.isOneEditAway("pale","pake"));
        System.out.println(oneEditAway.isOneEditAway("aaaa","aaaa aaabv"));

    }
}
