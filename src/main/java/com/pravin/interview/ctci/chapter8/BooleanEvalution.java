package com.pravin.interview.ctci.chapter8;

import java.util.HashMap;
import java.util.Map;

public class BooleanEvalution {

    int countEvalInput(String s, boolean result) {

        Map<String, Integer> memo = new HashMap<>();
        return countEval(s, result, memo);
    }

    private int countEval(String s, boolean result, Map<String, Integer> memo) {

        if (s.length() == 0) return 0;
        if (s.length() == 1) return s.equals("1") == result ? 1 : 0;
        if (memo.containsKey(result + s)) {
            return memo.get(result + s);
        }

        int ways = 0;

        for (int i = 1; i < s.length(); i += 2) {

            char c = s.charAt(i);
            String left = s.substring(0, i);
            String right = s.substring(i + 1);
            int leftTrue = countEval(left, true, memo);
            int leftFalse = countEval(left, false, memo);
            int rightTrue = countEval(right, true, memo);
            int rightFalse = countEval(right, false, memo);

            int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);

            int totalTrue = 0;
            if (c == '^') {
                totalTrue = leftTrue * rightFalse + leftFalse * rightTrue;
            } else if (c == '&') {
                totalTrue = leftTrue * rightTrue;
            } else if (c == '|') {
                totalTrue = leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
            }

            int subWays = result ? totalTrue : total - totalTrue;
            ways += subWays;
        }
        memo.put(result + s, ways);
        return ways;

    }
}
