package com.pravin.interview.ctci.chapter4.phase2;

import com.pravin.interview.ctci.chapter4.Problem2;
import com.pravin.interview.ctci.trees.TreeNode;
import com.pravin.interview.ctci.trees.phase2.CreateBinaryTree;

public class CommonAncestor {

    public TreeNode findCommonAncestor(TreeNode root, TreeNode p, TreeNode q){

        if ( !covers(root, p) || !covers(root, q)) {
            return null;
        }

        return helper(root, p , q);
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        boolean pIsLeft = covers(root.left, p);
        boolean qIsLeft = covers(root.right, q);
        if (pIsLeft != qIsLeft) {
           return root;
        }
        TreeNode side = pIsLeft ? root.left : root.right;

        return helper(side, p, q);
    }

    private boolean covers(TreeNode root, TreeNode node) {
            if (root == null) {
                return false;
            }
            if (root == node) {
                return true;
            }
            return covers(root.right, node) || covers(root.left, node);
    }


    public TreeNode findAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (root==null) {
            return null;
        }
        if (root == p && root == q) {
            return root;
        }

        TreeNode x = findAncestor(root.left , p , q);
        if (x != null && p!=x && q != x) {
            return x;
        }

        TreeNode y = findAncestor(root.right, p, q);
        if (y != null && y != p && y != q) {
            return y;
        }

        if (x!= null && y != null) {
            return root;
        }else if ( p == root || q == root) {
            return root;
        }
        return x == null ? y : x;
    }


    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        int[] array = new int[]{5, 10, 15, 20, 25,50,60,65,70,80,90};
        TreeNode treeNode = problem2.createBST(array);
        CommonAncestor commonAncestor = new CommonAncestor();
        TreeNode common = commonAncestor.findAncestor(treeNode, treeNode.left.right, treeNode.left.left);
        System.out.println(common);

        TreeNode easy = commonAncestor.findCommonAncestor(treeNode, treeNode.left.right, treeNode.left.left);
        System.out.println(common);
    }
}
