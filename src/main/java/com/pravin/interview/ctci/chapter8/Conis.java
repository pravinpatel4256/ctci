package com.pravin.interview.ctci.chapter8;

public class Conis {

    public int makeChanges(int amount) {
        int[] demos = {25, 10, 5, 1};
        int[][] map = new int[amount + 1][demos.length];
        return makeChangesR(amount, demos, 0, map);
    }

    private int makeChangesR(int total, int[] demos, int index, int[][] map) {
        int coin = demos[index];

        if (index >= demos.length - 1) {
            int remaining = total % coin;
            return remaining == 0 ? 1 : 0;
        }
        if (map[total][index] > 0) {
            return map[total][index];

        }
        int ways = 0;


        for (int amount = 0; amount <= total; amount += coin) {
            ways += makeChangesR(total - amount, demos, index + 1, map);
        }
        map[total][index] = ways;
        return ways;

    }
}
