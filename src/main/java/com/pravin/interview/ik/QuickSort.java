package com.pravin.interview.ik;

public class QuickSort {


    public void sort(int[] ar){
        helper(ar, 0, ar.length -1);
    }

    public void helper(int[] ar, int start, int end){
        if (start >= end) {
            return;
        }
        int pivotIndex = (start  + end)/2;
        swap(ar, start, pivotIndex);
        int pivot = ar[start];
        int smaller = start;
        for (int bigger = start + 1; bigger <= end; bigger++) {
            if (ar[bigger] < pivot) {
                smaller++;
                swap(ar, bigger, smaller);
            }
        }
        swap(ar, smaller, start);
        helper(ar, start, smaller -1);
        helper(ar, smaller + 1, end);

    }

    public void swap(int[] ar, int idx1, int idx2) {
        int tmp = ar[idx2];
        ar[idx2] = ar[idx1];
        ar[idx1] = tmp;
    }


    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] ar = new int[]{4, 2, 9,0,8,1,3,2,2,8,0,3,2,9,8,11,0};
        quickSort.sort(ar);
        for (int a : ar) {
            System.out.print(a);
            System.out.print(", ");
        }
    }
}
