package com.pravin.interview.chapter1;

import java.util.Map;
import java.util.stream.Collectors;

public class Problem1_5 {


    static boolean isOneAway(String s1, String s2){

        if (s1 == null || s2 == null) {
            return false;
        }

            Map<Character, Integer> map = s1.chars().boxed().map(k -> (char)k.intValue()).collect(
                Collectors.toMap( k -> k, v -> 1, Integer::sum));

        System.out.println(map);


        Map<Character, Integer> map2 = s2.chars().boxed().map(k -> (char)k.intValue()).collect(
                Collectors.toMap( k -> k, v -> 1, Integer::sum));

        System.out.println(map2);

        s2.chars().boxed().map(k -> (char) k.intValue()).forEach(ch -> map.merge(ch, 1, (a, b)-> Integer.sum(a, -1*b)));

        System.out.println(map);

        int sum = map.values().stream().mapToInt(Math::abs).sum();

        if (sum == 2) {

        }

        System.out.println(sum);
        return sum < 2;
    }

    public static void main(String[] args) {

        String s1 = "pale";
        String s2 = "ple";
        System.out.println(isOneAway(s1,s2));
        System.out.println(isOneAway("pales","pale"));
        System.out.println(isOneAway("pale","bale"));
        System.out.println(isOneAway("pale","bake"));
        System.out.println(isOneAway("aaaa","aaaa aaabv"));

    }
}
