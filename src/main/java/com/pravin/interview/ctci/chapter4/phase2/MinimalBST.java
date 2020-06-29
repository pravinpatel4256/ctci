package com.pravin.interview.ctci.chapter4.phase2;

import com.pravin.interview.ctci.chapter4.Problem2;
import com.pravin.interview.ctci.trees.TreeNode;
import sun.awt.windows.WPrinterJob;

import javax.validation.constraints.Min;

public class MinimalBST {

    public TreeNode  minimalTree(int[] array){

        return minimalTreeR(array, 0, array.length - 1);
    }

    private TreeNode minimalTreeR(int[] array, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end )/2;
        TreeNode  root = new TreeNode(array[mid]);
        root.left = minimalTreeR(array, start, mid - 1);
        root.right = minimalTreeR(array, mid + 1, end);
        return root;
    }

    public void printTree(TreeNode treeNode){
        if (treeNode != null){
            printTree(treeNode.left);
            System.out.println(treeNode.data);
            printTree(treeNode.right);
        }
    }


    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        MinimalBST minimalBST = new MinimalBST();
        TreeNode treeNode = minimalBST.minimalTree(a);
        minimalBST.printTree(treeNode);

    }
}
