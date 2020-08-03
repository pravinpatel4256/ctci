package com.pravin.interview.ds;


class RockCollection {

    public int makRockPath(int[][] roads) {
        if (roads == null || roads.length == 0) return 0;
        int[][] memo = new int[roads.length][roads[0].length];

        int result = makRockPath(roads, roads.length - 1, 0, memo);
        return result;
    }

    public int makRockPath(int[][] roads, int row, int col, int[][] memo) {

        if (col < 0 || row < 0 || col > roads[0].length - 1) {
            return 0;
        }
        if (memo[row][col] != 0) {
            return memo[row][col];
        }
        int val = roads[row][col];
        int withRow = val + makRockPath(roads, row - 1, col, memo);
        int withColumn = val + makRockPath(roads, row, col + 1, memo);
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

        int result = new RockCollection().makRockPath(arr);
        System.out.println(result);
    }
}
