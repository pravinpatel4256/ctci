package com.pravin.interview.ik;

import java.util.Arrays;

public class MergeSort {

    public void mergeSort(int[] ar){
        int[] aux = new int[ar.length];
        mergeSort(ar, 0, ar.length-1, aux);
    }

    private void mergeSort(int[] ar, int start, int end, int[] aux) {
        if (start >= end){
            return;
        }

        int mid = (start + end)/2;
        mergeSort(ar, start, mid, aux);
        mergeSort(ar, mid+1, end, aux);
        merge(ar, start, end, mid, aux);
    }

    private void merge(int[] ar, int start, int end, int mid, int[] aux) {
        for (int i = start; i <= end; i++) {
            aux[i] = ar[i];
        }

        int left = start;
        int right = mid + 1;
        int index = start;

        while(left <= mid && right <= end) {
            if(aux[left] <= ar[right]) {
                ar[index] = aux[left];
                left++;
            }else {
                ar[index] = aux[right];
                right++;
            }
            index++;
        }
        for (int i = left; i <= mid; i++) {
            ar[index] = aux[i];
            index++;
        }

        for (int i = right; i <= end; i++) {
            ar[index] = aux[i];
            index++;
        }

    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] ar = new int[]{4, 2, 9,0,8,1,3,2,2,8,0,3,2,9,8,11,0};
        mergeSort.mergeSort(ar);
        Arrays.stream(ar).forEach( a -> System.out.print("  "+ a));
    }
}
