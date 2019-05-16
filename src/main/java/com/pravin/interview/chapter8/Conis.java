package com.pravin.interview.chapter8;

public class Conis {

    public int makeChanges(int amount){
        int[] demos = {25, 10, 5, 1};
        int[][] map = new int[amount + 1][demos.length];
        return makeChangesR(amount, demos, 0, map);
    }

    private int makeChangesR(int amount, int[] demos, int index, int[][] map) {

        if(index >= demos.length - 1){
             return 1;
         }
        if (map[amount][index] > 0){
            return map [amount][index];

        }
        int ways = 0;
        int demosAmount = demos[index];

        for(int i = 0; i*demosAmount <= amount; i++ ){
            int remainingAmount = amount - demosAmount*i ;
            ways+= makeChangesR(remainingAmount, demos, index+1, map);
        }
        map[amount][index] = ways;
        return ways;

    }
}
