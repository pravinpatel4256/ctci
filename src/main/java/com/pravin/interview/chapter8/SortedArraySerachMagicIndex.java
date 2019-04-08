package com.pravin.interview.chapter8;

public class SortedArraySerachMagicIndex {

    public int magicFast(int[] ar){
        if(ar == null || ar.length == 0) {
            return -1;
        }
        return magicFastR(ar, 0, ar.length - 1);


    }

    private int magicFastR(int[] ar, int start, int end) {

        if (end < start) {
            return -1;
        }

        int mid = (start + end)/2;
        int midVal = ar[mid];
        if (midVal == mid) {
            return mid;
        }

        if (mid < midVal) {

            int leftIndex = Math.min(mid - 1, midVal);
            return magicFastR(ar, start, leftIndex);

        }else {
            int rightIndex = Math.max(mid + 1, midVal);
            return magicFastR(ar, rightIndex, end);
        }

    }
}
