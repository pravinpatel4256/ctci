package com.pravin.interview.ctci.chapter8;

import java.util.HashSet;
import java.util.Set;

public class Parentheses {

    public Set<String> generateParans(int len){

        Set<String> result = new HashSet<>();
        if (len == 0) {
            result.add("");
            // return result;
        }else {

            Set<String> prevParans = generateParans(len - 1);
            for (String s: prevParans) {
                for (int i = 0 ; i < s.length(); i++) {
                    if (s.charAt(i) == '(') {
                        String ns = insertParanAtI(s, i);
                        result.add(ns);
                    }
                }
                result.add("()" + s);
            }

        }

        return result;

    }

    private String insertParanAtI(String s, int i) {
        String before = s.substring(0, i+1);
        String after = s.substring(i+1);
        return  before + "()" + after;
    }
}
