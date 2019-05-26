package com.pravin.interview.hard;

import java.util.Arrays;
import java.util.Random;

public class Problem3 {


        /* pick M elements from original array, using only elements 0 through i (inclusive).*/
        public static int[] pickMRecursively(int[] original, int m, int i) {
            if (i + 1 < m) { // Not enough elements
                return null;
            } else if (i + 1 == m) { // Base case -- copy first m elements into array
                int[] set = new int[m];
                for (int k = 0; k < m; k++) {
                    set[k] = original[k];
                }
                return set;
            } else {
                int[] set = pickMRecursively(original, m, i - 1);
                Random rand = new Random();
                int k = rand.nextInt(i + 1); // Generate random between 0 and i (inclusive)
                if (k < m) {
                    set[k] = original[i];
                }
                return set;
            }
        }

        /* pick M elements from original array.*/
        public static int[] pickMIteratively(int[] original, int m) {
            if (m > original.length) return null;
            int[] subset = new int[m];

            /* Fill in subset array with first part of original array */
            for (int i = 0; i < m ; i++) {
                subset[i] = original[i];
            }

            Random rand = new Random();

            /* Go through rest of original array. */
            for (int i = m; i < original.length; i++) {
                int k = rand.nextInt(i + 1); // Generate random between 0 and i (inclusive)
                if (k < m) {
                    subset[k] = original[i];
                }
            }

            return subset;
        }

        public static void main(String[] args) {
            int[] cards = {110, 111, 112, 113, 112, 115, 116, 117, 18, 119};
            System.out.println(cards);
            int[] set = pickMIteratively(cards, 4);
            Arrays.stream(set).forEach(System.out::println);
        }


}
