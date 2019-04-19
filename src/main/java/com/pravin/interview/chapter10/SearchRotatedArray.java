package com.pravin.interview.chapter10;

public class SearchRotatedArray {

    public int search(int[] a, int x) {
        return search(a, 0, a.length - 1, x);
    }

    private int search(int[] a, int left, int right, int x) {

        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;

        if (x == a[mid]) {
            return x;
        }

        if (a[left] < a[mid]) {

            if (x >= a[left] && x < a[mid]) {
                return search(a, left, mid - 1, x);
            }
            return search(a, mid + 1, right, x);
        }

        if (a[left] > a[mid]) {
            if (x > a[mid] && x <= a[right]) {
                return search(a, mid + 1, right, x);
            }
            return search(a, left, mid-1,x);
        }

        if (a[left] == a[mid]) {
            if(a[left] != a[right]){
                return search(a, mid + 1 , right, x);
            }else {
                int result = search(a, left, mid -1 , x);
                if(result == -1){
                    result = search(a, mid + 1, right, x);
                }
                return result;
            }
        }

        return -1;
    }
}
