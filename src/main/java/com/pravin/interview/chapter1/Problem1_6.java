package com.pravin.interview.chapter1;

import java.util.Map;
import java.util.stream.Collectors;

public class Problem1_6 {


    static String copress(String s1){

        Map<Character, Integer> map = s1.chars().boxed().collect(Collectors.toMap(
                k-> (char) k.intValue(), v->1, Integer::sum
        ));

        StringBuilder b = new StringBuilder();
        map.entrySet().stream().map(e -> e.getKey().toString() + e.getValue()).forEach(b::append);
        System.out.println(b);


        return s1.length() == b.length()? s1:b.toString();
    }

    public static void main(String[] args) {

        System.out.println(copress("prrraaaavvvin"));
    }
}
