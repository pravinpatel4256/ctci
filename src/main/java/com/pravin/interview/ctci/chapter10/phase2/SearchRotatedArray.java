package com.pravin.interview.ctci.chapter10.phase2;

public class SearchRotatedArray {

    int search(int[] array, int left, int right, int x) {

        if (left > right) {
            return -1;
        }
        int mid = (left + right)/ 2;
        if (array[mid] == x){
            return mid;
        }
        if (array[left] < array[mid]) {

            if (x >= array[left] && x < array[mid]) {
                return search(array, left, mid-1, x);
            }else{
                return search(array, mid + 1, right, x);
            }
        }
        else if (array[mid] < array[right]) {
            if (x > array[mid] && x <= array[right]) {
                return search(array, mid + 1, right, x);
            }else {
                return search(array, left, mid - 1, x);
            }
        }
        else if (array[left] == array[mid]) {

            if (array[left] != array[right]) {
                return search(array, mid + 1, right, x);
            }
            int result = search(array, left, mid - 1, x);
            if (result == -1) {
                return search(array, mid+1, right, x);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchRotatedArray searchRotatedArray = new SearchRotatedArray();
        int[] ar = new int[]{15, 16, 17, 20, 22, 25, 1,2 ,3 ,4,5};
        int r = searchRotatedArray.search(ar, 0, ar.length - 1, 22  );
        System.out.println(r);
    }

}
