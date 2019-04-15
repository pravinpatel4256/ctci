package com.pravin.interview.sorts;

import java.util.Arrays;

public class MergeSort {

    public void mergeSort(int[] arr) {

        int[] helper = new int[arr.length];
        mergeSort(arr, helper, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int[] helper, int low, int high) {

        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(arr, helper, low, mid);
        mergeSort(arr, helper, mid + 1, high);
        merge(arr, helper, low, mid, high);
    }

    private void merge(int[] arr, int[] helper, int low, int mid, int high) {

        for (int i = low; i <= high; i++) {
            helper[i] = arr[i];
        }

        int helperLeft = low;
        int helperRight = mid + 1;
        int current = low;

        while (helperLeft <= mid && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                arr[current] = helper[helperLeft];
                helperLeft++;
            } else {
                arr[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        int remain = mid - helperLeft;
        for (int i = 0; i <= remain; i++) {
            arr[current + i] = helper[helperLeft + i];
        }
    }


    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] a = new int[]{1, 10, 9, 2, 4, 12, 23};

        mergeSort.mergeSort(a);

        Arrays.stream(a).forEach(System.out::println);
    }
}
