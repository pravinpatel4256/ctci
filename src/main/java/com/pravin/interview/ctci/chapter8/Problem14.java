package com.pravin.interview.ctci.chapter8;

import java.util.HashMap;
import java.util.Map;

public class Problem14 {

    public static void main(String[] args) {
       /* BooleanEvalution booleanEvalution = new BooleanEvalution();
        int count = booleanEvalution.countEvalInput("1^0|0|1", false);
        System.out.println(count);*/

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1  + map.getOrDefault(1, 0));
        map.put(1, 1  + map.getOrDefault(1, 0));
        System.out.println(map.get(1));
    }
}
