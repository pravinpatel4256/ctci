package com.pravin.interview.ctci.chapter4.phase2;

import com.pravin.interview.ctci.trees.TreeNode;
import com.pravin.interview.ctci.trees.phase2.CreateBinaryTree;

import java.util.LinkedList;
import java.util.List;

public class CheckedBalanceTree {

    int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int diff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(diff) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }


    int checkHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int leftHeight = checkHeight(root.left);
        System.out.println(String.format("leftHeight = %d of node: %d ", leftHeight, root.data));
        if (leftHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int rightHeight = checkHeight(root.right);
        System.out.println(String.format("rightHeight = %d of node: %d ", rightHeight, root.data));
        if (rightHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        int diff = leftHeight - rightHeight;
        if (Math.abs(diff) > 1) {
            return Integer.MIN_VALUE;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanceOptimal(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    public static void main(String[] args) {

        CreateBinaryTree createBinaryTree = new CreateBinaryTree();
        TreeNode treeNode = createBinaryTree.creatBinaryTree(new int[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println(new CheckedBalanceTree().isBalanced(treeNode));
        System.out.println(new CheckedBalanceTree().isBalanceOptimal(treeNode));
    }

}