package com.pravin.interview.ctci.trees.phase2;

import com.pravin.interview.ctci.trees.TreeNode;

public class CreateBinaryTree {

    public TreeNode creatBinaryTree(int[] array){

        if (array != null) {
            return creatBinaryTree(array, 0, array.length - 1);
        }

        return null;
    }

    private TreeNode creatBinaryTree(int[] array, int start, int end) {

        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(array[mid]);
        root.left = creatBinaryTree(array, start , mid - 1);
        root.right = creatBinaryTree(array, mid+ 1, end);
        return root;
    }

    public static void main(String[] args) {
        CreateBinaryTree createBinaryTree = new CreateBinaryTree();
        TreeNode treeNode = createBinaryTree.creatBinaryTree(new int[]{1, 2, 4, 5, 6, 7, 8});
        System.out.println(treeNode);
    }
}
