package com.pravin.interview.chapter1;

public class Problem1_7 {


    static int[][] rotate(int[][] ar, int n){

        System.out.println("Rotating metrics");

        System.out.println();

        System.out.println();


        int[][] ar2 = new int[n][n];


        for (int i = 0; i < n; i++ ) {
            int count = n-i-1;
            for (int j = 0; j< n; j++){
                int temp = ar[i][j];
                ar2[j][count] = temp;
            }


        }

        dispaly(n, ar2);

        return  null;
    }

    static void rotateM(int[][] ar) {


    }

    private static void dispaly(int n, int[][] ar2) {
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < n ; j++) {
                System.out.print((ar2[i][j] < 10? "0": "" )+ ar2[i][j] + "  ");
            }
        }
    }

    public static void main(String[] args) {

        int n = 4;
        int data = 0;
        int[][] ar = new int[n][n];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n ; j++) {
               ar[i][j] = ++data;
            }
        }

        dispaly(n, ar);

        rotate(ar, n);
    }
}
