package com.pravin.interview.chapter4;

import com.pravin.interview.trees.TreeNode;

public class Problem2 {


    public TreeNode createBinaryTree(int [] arr){

         return createBinaryTree(arr, 0, arr.length -1);
    }

    private TreeNode createBinaryTree(int[] arr, int start, int end) {

        if (start > end) {
            return null;
        }
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = createBinaryTree(arr, start, mid-1);
        root.right = createBinaryTree(arr, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        int a[] = {1, 2,3 ,4 ,5 ,6, 7, 8, 9};
        System.out.println(problem2.createBinaryTree(a));

    }

}
