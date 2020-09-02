package com.pravin.interview.ds;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class RunningMedian {

        /*
         * Complete the runningMedian function below.
         */

        static class MaxHeapComparator implements Comparator<Integer> {

            public int compare(Integer a, Integer b) {
                return b - a;

            }
        }

        static class MinHeapComparator implements Comparator<Integer> {

            public int compare(Integer a, Integer b) {
                return a - b;

            }

        }

        static double[] runningMedian(int[] a) {
            /*
             * Write your code here.
             */

            class Pair {
                double d;
            }
            PriorityQueue<Integer> maxHeap = new   PriorityQueue<Integer>(new MaxHeapComparator());
            PriorityQueue<Integer> minHeap = new   PriorityQueue<>( (a1, b1) -> a1 -b1);
            double[] meds = new double[a.length];
            int i = 0;
            for (int num : a) {

                if (maxHeap.isEmpty()) {
                    maxHeap.add(num);
                }
                else if (num <= maxHeap.peek()) {

                    int x = maxHeap.peek();
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(num);
                }else {
                    int x = maxHeap.peek();
                    if(minHeap.isEmpty()) {
                        minHeap.add(num);
                    }else {
                        maxHeap.add(minHeap.poll());
                        minHeap.add(num);
                    }
                }




                double max = maxHeap.peek();
                if (!minHeap.isEmpty()) {
                    meds[i]  = (max + minHeap.peek())/2;
                }else{
                    meds[i] = max;
                }
                i++;

            }
            System.out.println(minHeap);
            System.out.println(maxHeap);

            for(double an: meds) {
                System.out.println(an);
            }
            return meds;

        }

    public static void main(String[] args) {
        RunningMedian runningMedian = new RunningMedian();
        int [] ar = {1, 2, 3,4,5,6,7,8,9, 10};
        RunningMedian.runningMedian(ar);
        HashMap<Character, Integer> map = new HashMap<>();
        int[] array = new int[256];
        String s = "Pravinpatelpravin";
        for (char ch : s.toCharArray()) {
            array[ch]++;
        }
        for (int a : array) {
            System.out.print(a + " ");
        }
    }
}
