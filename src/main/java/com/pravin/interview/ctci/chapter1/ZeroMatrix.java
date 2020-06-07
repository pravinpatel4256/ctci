package com.pravin.interview.ctci.chapter1;

public class ZeroMatrix {



    public void makeZeroMatrixNoExtraSpace(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean zeroInFirst = false;
        boolean zeroInFirstCol = false;

        for (int i = 0; i < m; i ++ ) {
            if(mat[0][i] == 0) {
                zeroInFirst = true;
            }
        }

        for (int i = 0; i < n; i ++ ) {
            if(mat[i][0] == 0) {
                 zeroInFirstCol = true;
            }
        }


        for (int row = 1;  row < m; row++ ) {
            for (int col = 1;  col < n; col ++ ) {

                if (mat[row][col] == 0) {
                    mat[0][col] = 0;
                    mat[col][0] = 0;
                }
            }
        }

        for (int i = 0; i < m; i ++ ) {
            if(mat[0][i] == 0) {
                makeRowZero(mat, i);
            }
        }

        for (int i = 0; i < n; i ++ ) {
            if(mat[i][0] == 0) {
                makeColZero(mat, i);
            }
        }

        if (zeroInFirst) {
            makeRowZero(mat, 0);
        }

        if (zeroInFirstCol) {
            makeColZero(mat, 0);
        }

    }

    public void makeZeroMatrix(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;

        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];

        for (int row = 0;  row < m; row++ ) {
            for (int col = 0;  col < n; col ++ ) {

                if (mat[row][col] == 0) {
                    rows[row] = true;
                    cols[col] = true;
                }
            }
        }

        for (int i = 0; i < m; i ++ ) {
            if(rows[i]) {
                makeRowZero(mat, i);
            }
        }

        for (int i = 0; i < n; i ++ ) {
            if(cols[i]) {
                makeColZero(mat, i);
            }
        }

        dispaly(mat);
    }

    private void makeColZero(int[][] mat, int col) {
        int size = mat.length;
        for (int i= 0 ; i< size; i++) {
            mat[i][col] = 0;
        }
    }

    public void makeRowZero(int[][] mat, int rowNum) {
        int size = mat[0].length;
        for (int i= 0 ; i< size; i++) {
            mat[rowNum][i] = 0;
        }
    }

    private static void dispaly(int[][] ar2) {
        int n = ar2.length;
        for (int i = 0; i < n; ++i) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print((ar2[i][j] < 10 ? "0" : "") + ar2[i][j] + "  ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ZeroMatrix zeroMatrix = new ZeroMatrix();

        int n = 4;
        int data = 0;
        int[][] ar = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ar[i][j] = ++data;
                if(i == 2 && j == 2){
                    ar[i][j] = 0;
                }
            }
        }
        dispaly(ar);
        zeroMatrix.makeZeroMatrixNoExtraSpace(ar);
        dispaly(ar);



    }
}
