package com.pravin.interview.chapter1;

import java.util.Map;
import java.util.stream.Collectors;

public class UniqueString {

    public boolean isUnique(String str) {


        return str.chars().boxed().collect(Collectors.toMap(k -> (char) k.intValue(), v -> 1, Integer::sum)).values().stream()
                .filter(v -> v > 1).collect(Collectors.toList()).isEmpty();

    }

    public boolean isUniqueChars(String str) {

        if (str == null) {
            return false;
        } else if (str.length() > 128) {
            return false;
        }

        boolean[] charArray = new boolean[128];

        for(int i = 0; i < str.length(); i++){
            char ith = str.charAt(i);
            if(charArray[ith]){
                return false;
            }
            charArray[ith] = true;
        }

        return true;

    }
}
