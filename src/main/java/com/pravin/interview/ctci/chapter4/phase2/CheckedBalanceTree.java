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

    public static void main(String[] args) {

        CreateBinaryTree createBinaryTree = new CreateBinaryTree();
        TreeNode treeNode = createBinaryTree.creatBinaryTree(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        System.out.println(new CheckedBalanceTree().isBalanced(treeNode));
    }

}
