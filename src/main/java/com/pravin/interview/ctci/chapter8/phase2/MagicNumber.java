package com.pravin.interview.ctci.chapter8.phase2;

public class MagicNumber {

    public int getMagicNum(int[] array) {
        return getMagicNum(array, 0, array.length - 1);
    }

    private int getMagicNum(int[] array, int start, int end) {
        if (start > end) {
            return Integer.MIN_VALUE;
        }

        int mid = (start + end )/2;
        if (array[mid] == mid) {
            return mid;
        }


        int left =  getMagicNum(array, mid + 1, end);
        if (left != Integer.MIN_VALUE) {
            return left;
        }
        return getMagicNum(array, start, mid - 1);
    }

    public int getMagicNumWithDuplicate(int[] array) {
        return getMagicNumWithDuplicate(array, 0, array.length - 1);
    }

    private int getMagicNumWithDuplicate(int[] array, int start, int end) {
        if (start > end) {
            return Integer.MIN_VALUE;
        }
        int mid = (start + end)/2;
        if (array[mid] == mid) {
            return mid;
        }

        int midVal = Math.min(array[mid], array[mid- 1]);

        return 0;
    }


    public static void main(String[] args) {
        int[] arr = {-10, -9, -3, 3, 6, 8, 9, 10, 11, 12, 13 };
        MagicNumber magicNumber = new MagicNumber();
        System.out.println(magicNumber.getMagicNum(arr));
    }
}
