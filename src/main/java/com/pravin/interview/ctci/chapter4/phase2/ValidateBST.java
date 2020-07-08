package com.pravin.interview.ctci.chapter4.phase2;

import com.pravin.interview.ctci.trees.TreeNode;
import com.pravin.interview.ctci.trees.phase2.CreateBinaryTree;
import io.micrometer.core.instrument.util.JsonUtils;

import java.util.Arrays;

public class ValidateBST {

    public boolean isValidBST(TreeNode treeNode, int size){

        if (treeNode == null) {
            return true;
        }
        int data = treeNode.data;
        int[] array = new int[size];
        int[] index = new int[1];
        copyBST(treeNode, array, index);
        Arrays.stream(array).forEach(p -> System.out.println(p));
        for (int i = 1; i < size ; i++) {
            if (array[i] <= array [i - 1]) return false;
        }

        return true;
    }

    public void copyBST(TreeNode root, int[] array, int[] index){
        if(root == null) return;
        copyBST(root.left, array, index);
        array[index[0]] = root.data;
        index[0]++;
        copyBST(root.right, array, index);
    }

    public static void main(String[] args) {
        CreateBinaryTree createBinaryTree = new CreateBinaryTree();
        int[] array = new int[]{1, 2, 5, 3, 4, 5, 6, 7};
        TreeNode treeNode = createBinaryTree.creatBinaryTree(array);
        boolean isValid = new ValidateBST().isValidBST(treeNode, array.length);
        System.out.println(isValid);

    }

    boolean checkBST(TreeNode treeNode) {
        return checkBST(treeNode, null, null);

    }

    private boolean checkBST(TreeNode treeNode, Integer min, Integer max) {

        if (treeNode == null) return true;

        if ((min != null && treeNode.data <= min) || (max != null && treeNode.data > max))
        return false;

        return checkBST(treeNode.left, min, treeNode.data) && checkBST(treeNode.right, treeNode.data, max);
    }


}

