package com.pravin.interview.ctci.chapter10.phase2;

public class FindHighestInHalfSortedArray {

    int search(int[] ar, int left, int right) {

        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (ar[mid - 1] < ar[mid] && ar[mid] > ar[mid + 1]) {
            return ar[mid];
        }

        if (ar[mid] > ar[left]) {
            return search(ar, mid + 1, right);
        }
        return search(ar, left, mid);
    }

    public static void main(String[] args) {
        FindHighestInHalfSortedArray highest = new FindHighestInHalfSortedArray();
        int[] ar = new int[] {1,2,4,6,8,9,10,23,5,4,3,2,1};
        int r = highest.search(ar, 0, ar.length - 1);
        System.out.println(r);
    }
}

