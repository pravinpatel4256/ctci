package com.pravin.interview.ctci.moderate.phase2;

import com.pravin.interview.ctci.moderate.Range;

public class SubSort {

    public Range subSort(int[] array) {

        int leftEnd = findLeftEnd(array);

        if (leftEnd == array.length - 1) {
            return null;
        }
        int rightStart = findRightStart(array);


        int minIdx = rightStart;
        int maxIdx = leftEnd;

        for (int i = leftEnd + 1; i < rightStart; i++) {
            if (array[i] < array[minIdx]) {
                minIdx = i;
            }
            if (array[i] > array[maxIdx]) {
                maxIdx = i;
            }
        }

        System.out.println(minIdx);
        System.out.println(maxIdx);

        int leftIndex = shrinkLeft(array, leftEnd, minIdx);
        int rightIndex = shrinkRight(array, rightStart, maxIdx);

        return new Range(leftIndex, rightIndex);
    }

    private int findLeftEnd(int[] array) {
        for (int i = 0; i < array.length - 2; i++) {

            if (array[i] > array[i + 1]) {
                return i;
            }
        }
        return array.length - 1;
    }

    private int findRightStart(int[] array) {

        for (int i = array.length - 1; i >= 1; i--) {
            if (array[i] < array[i - 1]) {
                return i;
            }
        }
        return 0;
    }


    private int shrinkRight(int[] array, int rightStart, int maxIdx) {
        for (int i = rightStart; i < array.length; i++) {
            if (array[i] > array[maxIdx]) {
                return i - 1;
            }
        }
        return maxIdx;

    }

    private int shrinkLeft(int[] array, int leftEnd, int minIdx) {
        System.out.println(array[minIdx]);
        for (int i = leftEnd; i >= 0; i--) {
            if (array[i] < array[minIdx]) {
                return i + 1;
            }
        }
        return minIdx;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        SubSort subSort = new SubSort();
        Range r = subSort.subSort(array);
        System.out.println(r);
    }
}
