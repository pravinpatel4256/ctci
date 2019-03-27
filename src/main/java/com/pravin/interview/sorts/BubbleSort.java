package com.pravin.interview.sorts;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BubbleSort {


    static int[] sort(int[] arr){

        Arrays.stream(arr).peek(x -> System.out.print(" ")).forEach(System.out::print);

        System.out.println();
        System.out.println(" ------");
        int comp = arr[0];
        int tmp = 0;

        for (int i = 0; i< arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {

                if (arr[j] > arr[j+1]){
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j + 1] = tmp;
                }
                
            }
            
        }

        return arr;
    }

    public static void main(String[] args) {

        int[] a = {-1, -4, 0, 99, 101, 9, 0, 1, 4, 1 ,2, 4, 8, 2, 3999};
//
//        Arrays.stream(sort(a)).peek(x -> System.out.print(" ")).forEach(System.out::print);
//
//        Arrays.stream(a).mapToObj(x -> x+" ").forEach(System.out::print);

        int ap [] = IntStream.generate(() -> 0).limit(10).toArray();
      Arrays.stream(ap).mapToObj(x -> x + " ").forEach(System.out::print);
        int i = Arrays.stream(a).max().getAsInt();

        System.out.println(i);
    }
}
