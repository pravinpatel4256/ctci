package com.pravin.interview.ctci.chapter8;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem4 {


    public static void main(String[] args) {
        PowerSet powerSet = new PowerSet();
        System.out.println(powerSet.powerIt(new ArrayList<Integer>(Arrays.asList(1,2,3))));
    }
}
