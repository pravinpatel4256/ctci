package com.pravin.interview.chapter4;

import com.pravin.interview.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Problem2 {


    public TreeNode     createBinaryTree(int [] arr){

         return createBinaryTree(arr, 0, arr.length -1);
    }

    private TreeNode createBinaryTree(int[] arr, int start, int end) {

      //  System.out.println(start + " to " + end);
        if (end < start){
            return null;
        }
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = createBinaryTree(arr, start, mid-1);
        root.right = createBinaryTree(arr, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        int a[] = {1, 2,3 ,4 ,5 ,6, 7, 8, 9,10,11,12, 13, 14};
        System.out.println(problem2.createBinaryTree(a));


        preOrder(problem2.createBinaryTree(a));

       // printByLevel(problem2.createBinaryTree(a));
    }


    public static void inOrderDisplay(TreeNode node){
         if(null != node){
             inOrderDisplay(node.left);
             System.out.println(node.data);
             inOrderDisplay(node.right);
         }
    }


    public static void preOrder(TreeNode node){
        if(null != node){
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
