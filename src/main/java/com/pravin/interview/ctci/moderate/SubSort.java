package com.pravin.interview.ctci.moderate;

public class SubSort {




    public void findUnsortedSequence2(int[] array) {

        if (array == null || array.length == 0) {
            return;
        }

        int endLeft = leftSortedPart(array);
        int startRight = rightSortedPart(array);

        int midMinIndex = startRight;
        int midMaxIndex = endLeft;

        for (int i = endLeft + 1; i < startRight; i++) {
            if (array[i] < array[midMinIndex]) {
                midMinIndex = i;
            }
            if (array[i] > array[midMaxIndex]) {
                midMaxIndex = i;
            }
        }

        System.out.println(midMaxIndex);
        System.out.println(midMinIndex);

        int leftIndex = leftShrink(array, endLeft, midMinIndex);
        int rightIndex = rightShrink(array, startRight, midMaxIndex);
        System.out.println(leftIndex + " -- " + rightIndex);

    }

    private int rightShrink(int[] array, int startRight, int midEnd) {

        int tmp = array[midEnd];
        for (int i = startRight; i < array.length; i++) {
            if ( array[i] >= tmp) {
                return i - 1;
            }
        }

        return array.length - 1;
    }

    private int leftShrink(int[] array, int endLeft, int midStart) {

        int tmp = array[midStart];
        for (int i = endLeft - 1 ; i >= 0; i--) {
            if (array[i] <= tmp) {
                return i + 1;
            }
        }
        return 0;

    }



    private int rightSortedPart(int[] array) {
        for (int i = array.length - 2; i >= 0; i--) {
            if(array[i] > array[i + 1]){
                return i+1;
            }
        }

        return 0;
    }

    private int leftSortedPart(int[] array) {

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return i - 1;
            }
        }
        return array.length - 1;
    }
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
         SubSort subSort = new SubSort();
        subSort.findUnsortedSequence2(array);
    }

}
