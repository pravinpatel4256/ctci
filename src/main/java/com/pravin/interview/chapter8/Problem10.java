package com.pravin.interview.chapter8;

public class Problem10 {


    public static void main(String[] args) {
        PaintFill paintFill = new PaintFill();

        PaintFill.Colors[][] screen = new PaintFill.Colors[10][10];
        for (int i = 0 ; i < 10; i++) {
            for (int j = 0 ; j < 10 ; j++) {
                screen[i][j] = PaintFill.Colors.Green;
            }
        }

        for (int k = 0 ; k < 10; k++) {
            for (int j = 0 ; j < 10 ; j++) {
                System.out.print(screen[k][j] + " ");
            }
            System.out.println();
        }

        screen =  paintFill.paintScreen(screen, 5, 5, PaintFill.Colors.Red );


        for (int k = 0 ; k < 10; k++) {
            for (int j = 0 ; j < 10 ; j++) {
                System.out.print(screen[k][j] + " ");
            }
            System.out.println();
        }
    }
}
