package com.pravin.interview.ctci.chapter1;

public class StringRotation {

    public boolean isRotation(String s1, String s2) {
        return isSubString(s2, s1 + s1);
    }

    private boolean isSubString(String s2, String newS) {
        return newS.contains(s2);
    }

    public static void main(String[] args) {
        String s1 = "laikhoftama";
        String s2 = "malaikhofta";
        StringRotation stringRotation = new StringRotation();
        System.out.println(stringRotation.isRotation(s2, s1));
    }
}
