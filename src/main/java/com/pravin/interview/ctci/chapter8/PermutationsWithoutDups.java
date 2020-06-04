package com.pravin.interview.ctci.chapter8;

import java.util.ArrayList;
import java.util.List;

public class PermutationsWithoutDups {


    public List<String> permutations1(String str){

        if (str == null) {
            return null;
        }

        List<String> result = new ArrayList<>();

        if(str.length() == 0){
            result.add("");
            return result;
        } else{
            Character first = str.charAt(0);
            String reminder = str.substring(1);
            List<String> morePerms = permutations1(reminder);

            for (String word: morePerms) {
                for (int i = 0; i <= word.length(); i++) {
                    String newWord  =  insertCharAt(word,  first, i);
                    result.add(newWord);
                }
            }

        }


        return result;
    }

    private String insertCharAt(String word, Character first, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start+first+end;
    }

    public List<String> permutations2(String str) {
        List<String> result = new ArrayList<>();
        if (str == null) {
            return null;
        }

        if(str.length() == 0){
            result.add("");
            return result;
        }
        int len = str.length();
        for (int i = 0 ; i < len ; i++) {

            String beforeI = str.substring(0, i);
            String afterI = str.substring(i+1, len);
            List<String> morePerms = permutations2(beforeI + afterI);

            for (String s: morePerms) {
                String ns = str.charAt(i) + s;
                result.add(ns);
            }

        }

        return result;
    }

    public List<String> permutations3(String str) {
        List<String> result = new ArrayList<>();
        if (str == null) {
            return null;
        }
        return perms("", str, result);
    }

    private List<String> perms(String prefix, String str, List<String> result) {

        if (str.length() == 0) {
            result.add(prefix);

        }
         int len = str.length();
        for (int i = 0; i< len; i++) {
            String beforeI = str.substring(0, i);
            String afterI = str.substring(i+1);
            char c = str.charAt(i);
            perms(prefix+c, beforeI+afterI, result);
        }
        return result;
    }
}
