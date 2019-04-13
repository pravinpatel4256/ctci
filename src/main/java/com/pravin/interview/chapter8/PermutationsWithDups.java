package com.pravin.interview.chapter8;

import java.util.*;
import java.util.stream.Collectors;

public class PermutationsWithDups {


    public List<String> permutationsBook(String str) {
        if (str == null) return null;

        List<String> result = new ArrayList<>();
        Map<Character, Integer> map =   str.chars().boxed().map(k -> (char)k.intValue()).collect(Collectors.toMap(k -> k, v->1, Integer::sum));


        return permutationsBookR("", map, result, str.length());

    }

    private List<String> permutationsBookR(String prefix, Map<Character, Integer> map, List<String> result, int strLen) {

        if (strLen == 0) {
            result.add(prefix);
            return result;
        }

        for (Character c: map.keySet()) {
           int count = map.get(c);
            if(map.get(c) > 0){
                map.put(c, count - 1);
                permutationsBookR(prefix+ c, map, result, strLen -1);
                map.put(c, count);
            }
        }

        return result;
    }


    public Set<String> permutations(String s){

        if (s == null) return  null;

        Set<String> set = new HashSet<>();
        if (s.length() == 0) {
            set.add("");
            return set;
        }

        Character c = s.charAt(0);
        String reminder = s.substring(1);
        Set<String> words = permutations(reminder);
//        System.out.println(words);
//        System.out.println(set);

        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                String newWord = insertAtChar(word, c, i);
                set.add(newWord);
            }
        }
        return set;
    }

    private String insertAtChar(String word, Character c, int i) {
        String before = word.substring(0, i);
        String after = word.substring(i);
        return before+c+after;

    }

}
