package com.pravin.interview.ctci.chapter1;

public class RotateArray {

    public void rotate90(int[][] matrix) {
        int n = matrix.length;
        int test = 0;
        for (int start = 0; start < n/2 ; start++) {
            int rSize = n - 1 - start;


            for (int i = start; i < rSize; i++) {
                int  top = matrix[start][i];
                matrix[start][i] = matrix[rSize - i + test][start]; //top

                matrix[rSize - i + test][start] = matrix[rSize][rSize - i + test]; //left

                matrix[rSize][rSize - i + test] = matrix[ i][rSize];

                matrix[i][rSize] = top;
                dispaly(matrix);
            }
            test ++;
            System.out.println("------------");
        }

    }

    public void rotateLeft90(int[][] matrix) {
        int n = matrix.length;
        int test = 0;
        for (int start = 0; start < n/2 ; start++) {
            int rSize = n - 1 - start;


            for (int i = start; i < rSize; i++) {
                int  top = matrix[start][i];

                //top = right
                matrix[start][i] = matrix[i][rSize];

                //right = bottom
                matrix[i][rSize] = matrix[rSize][rSize - i + test];

                //bottom = left
                matrix[rSize][rSize - i + test] = matrix[rSize - i + test][start];

                //left = top
                matrix[rSize - i + test][start] = top;
                dispaly(matrix);
            }
            test ++;
            System.out.println("------------");
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
        RotateArray rotateArray = new RotateArray();

        int n = 4;
        int data = 0;
        int[][] ar = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ar[i][j] = ++data;
            }
        }
        dispaly(ar);
        rotateArray.rotateLeft90(ar);
        dispaly(ar);
    }

}
