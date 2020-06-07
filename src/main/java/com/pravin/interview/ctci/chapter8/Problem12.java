package com.pravin.interview.ctci.chapter8;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem12 {

    public static void main(String[] args) {

        EightQueens  eightQueens = new EightQueens();
        ArrayList<Integer[]> arrayList = eightQueens.placeQueens();

        arrayList.forEach(a -> {

            Arrays.stream(a).forEach(c -> System.out.print(c + " "));
            System.out.println();

        });


    }
}
