package com.pravin.interview.chapter1;

public class Problem2 {

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        System.out.println(  permutation.isPermutation("god", "dog"));
        System.out.println(  permutation.isPermutation("abc", "bca"));
        System.out.println(  permutation.isPermutationIgnoringCase("Teen", "neet"));
        System.out.println(  permutation.isPermutationIgnoringCase("Neel", "Leeq"));


        System.out.println(  permutation.isPermutationWithoutSort("god", "dog"));
        System.out.println(  permutation.isPermutationWithoutSort("abc", "bca"));
        System.out.println(  permutation.isPermutationWithoutSort("Teen", "neet"));
        System.out.println(  permutation.isPermutationWithoutSort("Neel", "Leeq"));
    }
}
