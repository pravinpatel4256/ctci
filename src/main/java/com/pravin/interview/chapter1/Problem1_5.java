package com.pravin.interview.chapter1;

import java.util.Map;
import java.util.stream.Collectors;

public class Problem1_5 {


    static boolean isOneAway(String s1, String s2){

        if (s1 == null || s2 == null) {
            return false;
        }

        Map<Character, Integer> map = s1.chars().boxed().collect(
                Collectors.toMap( k -> (char) k.intValue(), v -> 1, Integer::sum));

        System.out.println(map);

        s2.chars().boxed().map(k -> (char) k.intValue()).filter(map::containsKey).forEach(ch -> map.put(ch, map.get(ch) - 1));

        System.out.println(map);

        return map.values().stream().mapToInt(i -> i).sum() < 2;
    }

    public static void main(String[] args) {

        String s1 = "pale";
        String s2 = "ple";
        System.out.println(isOneAway(s1,s2));
        System.out.println(isOneAway("pales","pale"));

        System.out.println(isOneAway("pale","bale"));

        System.out.println(isOneAway("pale","bake"));

    }
}
