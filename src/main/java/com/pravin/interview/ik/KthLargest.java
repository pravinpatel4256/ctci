package com.pravin.interview.ik;

import java.util.PriorityQueue;
import java.util.Random;

public class KthLargest {

    // PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
    public int kthLargestElement(int[] ar, int k) {

        return helper(ar, k, 0, ar.length - 1);


    }

    private int helper(int[] ar, int k, int start, int end) {
        int pivotIdx = partition(ar, start, end);
        int n = ar.length;
        if (pivotIdx == n - k) {
            return ar[pivotIdx];
        }

        else if(pivotIdx > n- k){
            return helper(ar, k,start, pivotIdx - 1);
        }
        return helper(ar, k, pivotIdx + 1, end);
    }

    private int partition(int[] ar, int start, int end) {
        int pivotIndex = (start + end)/2;

        while( start <= end) {
            if (ar[start] <= ar[pivotIndex]) {
                start++;
            }
            else if (ar[end] > ar[pivotIndex]) {
                end--;
            } else {
                swap(ar, start, end);
                start++;
                end--;

            }
        }

        return pivotIndex;
    }

    private void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {3,2,3,1,2,4,5,5,6};
        KthLargest kthLargest = new KthLargest();
        System.out.println(kthLargest.kthLargestElement(a, 4));
    }
}
