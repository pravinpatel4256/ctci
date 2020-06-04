package com.pravin.interview.ctci.chapter10;

public class SortedMerge {

    public void sortAndMerge(int[] a, int[] b, int lastA, int lastB) {
        int idxA = lastA -1;
        int idxB = lastB -1;
        int mergedIdx = lastA + lastB -1;

        while(idxB >= 0){

            if (idxA >= 0 && a[idxA] > b[idxB]) {
                a[mergedIdx] = a[idxA];
                idxA--;
            }else {
                a[mergedIdx] = b[idxB];
                idxB--;
            }

            mergedIdx--;
        }

    }
}
