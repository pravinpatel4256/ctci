package com.pravin.interview.chapter8;

public class TripleSteps {

    public int countWays(int steps){
        Integer[] stack = new Integer[steps+1];
        return countWaysR(steps, stack);
    }

    private int countWaysR(int steps, Integer[] stack) {

        if (steps < 0) {
            return 0;
        }
        else if(steps == 0){
            return 1;
        }
        else if (stack[steps] != null) {
            return  stack[steps];
        }
        else  {
            stack[steps] = countWaysR(steps - 1, stack) + countWaysR(steps - 2, stack) +  countWaysR(steps - 3, stack);
            return stack[steps];
        }

    }

}
