package com.pravin.interview.ctci.chapter1;

import java.util.Arrays;

public class Permutation {

    boolean isPermutation(String a, String b) {
        if (a == null || b == null || a.length() != b.length()) {
            return false;
        }
        return sortedString(a).equalsIgnoreCase(sortedString(b));
    }

    boolean isPermutationIgnoringCase(String a, String b) {
        if (a == null || b == null || a.length() != b.length()) {
            return false;
        }
        return sortedString(a.toLowerCase()).equalsIgnoreCase(sortedString(b.toLowerCase()));
    }

    private String sortedString(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }

    public boolean isPermutationWithoutSort(String a, String b){

        int[] charCounter = new int[128];
        char[] aa = a.toCharArray();
        for (char c : aa) {
            charCounter[c]++;
        }

        for (int i = 0; i < b.length(); i++) {
            char ith = b.charAt(i);
            charCounter[ith]--;
            if (charCounter[ith] < 0) {
                return false;
            }
        }

        return true;
    }

}
