package com.pravin.interview.ctci.chapter8.phase2;

public class MagicNumber {

    public int getMagicNum(int[] array) {
        return getMagicNum(array, 0, array.length - 1);
    }

    private int getMagicNum(int[] array, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end )/2;
        if (array[mid] == mid) {
            return mid;
        }

        if (array[mid] <= mid) {
           return getMagicNum(array, mid + 1, end);
        }
        return getMagicNum(array, start, mid - 1);
    }

    public static void main(String[] args) {
        int[] arr = {-10, -9, -3, 3, 6, 8, 9, 10, 11, 12, 13 };

        MagicNumber magicNumber = new MagicNumber();
        System.out.println(magicNumber.getMagicNum(arr));
    }
}
