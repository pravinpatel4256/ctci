package com.pravin.interview.ds;


import java.util.ArrayList;
import java.util.List;

class RockCollection {

    public int getPath(int[][] roads) {
        if (roads == null || roads.length == 0) return 0;
        int[][] memo = new int[roads.length][roads[0].length];

        int result = getPath(roads, roads.length - 1, 0, memo);
        return result;
    }

    public int getPath(int[][] roads, int row, int col, int[][] memo) {

        List<Point> points1 = new ArrayList<>();
        if (col < 0 || row < 0 || col > roads[0].length - 1) {
            return 0;
        }
        if (memo[row][col] != 0) {
            return memo[row][col];
        }
        int val = roads[row][col];
        int withRow = val + getPath(roads, row - 1, col, memo);
        int withColumn = val + getPath(roads, row, col + 1, memo);
        memo[row][col] = Math.max(withColumn, withRow);

        return memo[row][col];
    }

    public static void main(String[] args) {
        int[][] arr = {
                {0, 10, 0, 0, 0},
                {0, 0, 0, 0, 5},
                {0, 0, 0, 0, 0},
                {9, 0, 0, 0, 0}
        };

        int result = new RockCollection().getPath(arr);
        System.out.println(result);
    }
}
