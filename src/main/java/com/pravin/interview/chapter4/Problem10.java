package com.pravin.interview.chapter4;

import com.pravin.interview.trees.TreeNode;

public class Problem10 {

    public boolean containsTree(TreeNode t1, TreeNode t2){
        if (t1 == null || t2 == null) {
            return false;
        }
        StringBuilder t1Builder = new StringBuilder();
        StringBuilder t2Builder = new StringBuilder();

        getTreeString(t1, t1Builder);
        getTreeString(t2, t2Builder);

        System.out.println(t1Builder);
        System.out.println(t2Builder);
        return t1Builder.indexOf(t2Builder.toString()) >= 0;
    }

    private void getTreeString(TreeNode t, StringBuilder builder) {

        if (t == null) {
            builder.append("X");
            return;
        }

        builder.append(t.data);
        getTreeString(t.left, builder);
        getTreeString(t.right, builder);
    }

    public boolean containsTree2(TreeNode t1, TreeNode t2){

        if (t2 == null) return true;
        return subTree(t1, t2);
    }

    private boolean subTree(TreeNode t1, TreeNode t2) {

        if (t1 == null) return false;
        else if (t1.data == t2.data && checkSubTree(t1, t2)){
            return true;
        }
        return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }

    private boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null ) {
            return true;
        }
        else if (t1 == null || t2 == null) {
            return false;
        }
        else if (t1.data != t2.data){
            return false;
        }

        return checkSubTree(t1.left,  t2.left) && checkSubTree(t1.right, t2.right);
    }


    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();

        TreeNode  t1 = new TreeNode(7);
        TreeNode  left1 = new TreeNode(3);
        left1.left = new TreeNode(1);
        t1.left = left1;
        t1.right = new TreeNode(4);
        t1.right.right = new TreeNode(9);
        t1.right.right.right = new TreeNode(10);

        TreeNode  t2 = new TreeNode(7);
        //left.left = new TreeNode(1);
        t2.left = new TreeNode(3);
        t2.right = new TreeNode(4);


    // System.out.println(problem2.createBST(a));
        Problem10 problem10 = new Problem10();
        //TreeNode t1 = problem2.createBST(a);
//        TreeNode t2 = problem2.createBST(a2);

        Problem2.preOrder(t1);
        Problem2.preOrder(t2);
        boolean isIt = problem10.containsTree(t1, t2);
        System.out.println(isIt);

        boolean isIt2 = problem10.containsTree2(t1, t2);
        System.out.println(isIt2);

    }
}
