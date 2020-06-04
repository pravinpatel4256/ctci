package com.pravin.interview.ctci.chapter8;

import java.util.List;

public class Problem7 {

    public static void main(String[] args) {

        PermutationsWithoutDups permutaionWithoutDups = new PermutationsWithoutDups();
        //List<String> s = permutaionWithoutDups.permutations1("abc");
//        System.out.println(s);

        //s = permutaionWithoutDups.permutations2("abc");
        //System.out.println(s);


        List<String> s = permutaionWithoutDups.permutations3("abc");
        System.out.println(s);


    }
}
