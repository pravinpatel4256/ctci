package com.pravin.interview.ctci.chapter4;

import com.pravin.interview.ctci.trees.TreeNode;

public class Problem4 {

    public int getHeight(TreeNode treeNode) {
        if (treeNode == null) {
            return -1;
        }

        int lh = getHeight(treeNode.left);


        System.out.println(lh);

        int rh = getHeight(treeNode.right);
        System.out.println(lh);

        if (Math.abs(lh - rh) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(lh, rh) + 1;
        }
    }

    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        System.out.println(Integer.MIN_VALUE);
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        Problem4 problem4
                = new Problem4();
        System.out.println(problem4.getHeight(problem2.createBST(a)));

    }
}
