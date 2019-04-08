package com.pravin.interview.chapter8;

import java.util.Arrays;
import java.util.Random;

public class Problem3 {


    public static void main(String[] args) {
        SortedArraySerachMagicIndex magicIndex = new SortedArraySerachMagicIndex();

        int[] a = new int[5];
        a[0] = -30;
        a[1] = -20;
        a[2] = 0;
        a[3] = 3;
        a[4] = 30;

        System.out.println(magicIndex.magicFast(a));
    }

}
