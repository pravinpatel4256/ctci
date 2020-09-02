package com.pravin.interview.ik;

import java.util.Arrays;

public class TwoSum {

    public boolean findPair(int[] array, int target) {

        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;

        while (left < right ) {

            if (array[left] + array[right] == target) {
                return true;
            }else if ( (array[left] + array[right]) > target) {
                right --;
            }else{
               left++;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        int[] a = {5, 9, 1, 3};
        TwoSum twoSum = new TwoSum();
        System.out.println(twoSum.findPair(a, 7));
    }


}
