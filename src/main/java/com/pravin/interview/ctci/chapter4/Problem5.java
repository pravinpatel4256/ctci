package com.pravin.interview.ctci.chapter4;

import com.pravin.interview.ctci.trees.TreeNode;

import java.util.ArrayList;

public class Problem5 {


    public static boolean validateBST(TreeNode treeNode){
        return validateBST(treeNode, null, null);
    }

    static Integer lastData = null;
    private static boolean validateBST(TreeNode treeNode, Integer min, Integer max){

        if (treeNode == null ) {
            return true;
        }

        if ((min != null && treeNode.data <= min) || (max != null && treeNode.data > max)) {
            return false;
        }

        return validateBST(treeNode.left, min, treeNode.data) && validateBST(treeNode.right, treeNode.data, max);

    }


    public static boolean checkBST(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();
        copyBST(root, list);
        System.out.println(list);

        for (int i = 0; i < list.size() - 2; i++) {

            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;

    }

    private static void copyBST(TreeNode root, ArrayList<Integer> list) {

        if (root == null) {
            return;
        }
        copyBST(root.left, list);
        list.add(root.data);
        copyBST(root.right, list);
    }


    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        int[] a = {1,1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        // System.out.println(problem2.createBST(a));


        boolean isValid = checkBST(problem2.createBST(a));
        System.out.println(isValid);

        System.out.println(validateBST(problem2.createBST(a)));

        int[] a1 = {1, 12, 3, 14, 15, 16, 17, 8, 9, 10, 11, 12, 13, 14};
        // System.out.println(problem2.createBST(a));


        boolean isValid2 = checkBST(problem2.createBST(a1));

        System.out.println(isValid2);

        System.out.println(validateBST(problem2.createBST(a1)));
        // printByLevel(problem2.createBST(a));
    }



}
