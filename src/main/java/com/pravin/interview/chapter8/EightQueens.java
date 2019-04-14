package com.pravin.interview.chapter8;

import java.util.ArrayList;

public class EightQueens {

//    debug   with size 4 to understand this program more clearly.∂
//    private static final int boardSize = 4;
    private static final int boardSize = 8;

    public ArrayList<Integer[]> placeQueens(){

        ArrayList<Integer[]> result = new ArrayList<>();
        Integer[] columns = new Integer[boardSize];

        placeQueensR(0, columns, result );
        return result;
    }

    private void placeQueensR(int r, Integer[] cs, ArrayList<Integer[]> result) {

        if (r == boardSize) {
            result.add(cs.clone());
        }
        for (int c = 0; c< boardSize; c++) {

            if (checkPlace(r, c, cs)) {
                cs[r] = c;

                placeQueensR(r+1, cs, result);

            }
        }

    }

    private boolean checkPlace(int r, int c, Integer[] cs) {

        for (int r1 = 0 ; r1 < r; r1++) {

            int prevColumn = cs[r1];
            if (prevColumn == c) {
                return false;
            }

            int colDiff = Math.abs(prevColumn - c);
            int rowDiff = r - r1;

            if (colDiff == rowDiff) {
                return false;
            }

        }

        return true;
    }
}
