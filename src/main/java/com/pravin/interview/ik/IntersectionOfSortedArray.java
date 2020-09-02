package com.pravin.interview.ik;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfSortedArray {

    public int[] intersection(int[] ar1, int[] ar2) {

        int p1 = 0;
        int p2 = 0;
        Set<Integer> set = new HashSet<>();
        while (p1 < ar1.length && p2 <ar2.length) {

            if (ar1[p1] == ar1[p2]) {
                set.add(ar1[p1]);
                p1++;
                p2++;
            } else if (ar1[p1] > ar2[p2]) {
                p2++;
            }else {
                p1++;
            }

        }
        int[] result = new int[set.size()];
        for (int x : set) {

        }
        return null;
    }

}
