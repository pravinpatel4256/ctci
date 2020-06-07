package com.pravin.interview.ctci.chapter4;

import com.pravin.interview.ctci.trees.TreeNode;

public class Problem2 {


    public TreeNode createBST(int[] arr) {

        return createBST(arr, 0, arr.length - 1);
    }

    private TreeNode createBST(int[] arr, int start, int end) {

        //  System.out.println(start + " to " + end);
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = createBST(arr, start, mid - 1);
        root.right = createBST(arr, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        System.out.println(problem2.createBST(a));


        preOrder(problem2.createBST(a));

        // printByLevel(problem2.createBST(a));
    }


    public static void inOrderDisplay(TreeNode node) {
        if (null != node) {
            inOrderDisplay(node.left);
            System.out.println(node.data);
            inOrderDisplay(node.right);
        }
    }


    public static void preOrder(TreeNode node) {
        if (null != node) {
            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

//    public static void printByLevel(TreeNode treeNode){
//
//        ArrayList<LinkedList<TreeNode>> resultList = new ArrayList<>();
//        if (treeNode == null) {
//           return;
//        }
//
//        LinkedList<TreeNode> toVisit = new LinkedList<>();
//
//        toVisit.add(treeNode);
//
//        LinkedList<Integer> root = new LinkedList<>();
//
//        while(!toVisit.isEmpty()){
//            resultList.add(toVisit);
//            LinkedList<TreeNode> parents  =  toVisit;
//            toVisit = new LinkedList<>();
//
//
//            for (TreeNode currentNode : parents) {
//                if (currentNode.left != null) {
//                    toVisit.add(currentNode.left);
//                }
//                if (currentNode.right != null) {
//                    toVisit.add(currentNode.right);
//                }
//            }
//
//
//
//        }
//
//        System.out.println(resultList);
//
//
//    }
}
