package com.pravin.interview.chapter4;

import com.pravin.interview.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Problem9 {

    public ArrayList<LinkedList<Integer>>  allSequences(TreeNode treeNode){

        ArrayList<LinkedList<Integer>> result = new ArrayList<>();
        if (treeNode == null) {
           result.add(new LinkedList<>());
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(treeNode.data);


        ArrayList<LinkedList<Integer>> leftSq = allSequences(treeNode.left);
        ArrayList<LinkedList<Integer>> rightSq = allSequences(treeNode.right);

        for (LinkedList<Integer> left: leftSq) {
            for (LinkedList<Integer> right: rightSq) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
                weaveList(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }

        System.out.println("Result::::--->");
        System.out.println(result);
        return result;

    }

    private void weaveList(LinkedList<Integer> first, LinkedList<Integer> second, ArrayList<LinkedList<Integer>> weaved, LinkedList<Integer> prefix) {

        if (first.size() == 0 || second.size() == 0) {
            LinkedList<Integer> results = (LinkedList<Integer>) prefix.clone();
            results.addAll(first);
            results.addAll(second);
            weaved.add(results);
            return;
        }

        int headFirst = first.removeFirst();
        prefix.add(headFirst);
        weaveList(first, second, weaved, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        int headSecond = second.removeFirst();
        prefix.add(headSecond);
        weaveList(first, second, weaved, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);


    }


    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        Problem9  problem = new Problem9();
        int a[] = {1, 2,3 ,4 ,5 ,6, 7, 8, 9,10,11,12, 13, 14};
        //System.out.println(problem2.createBinaryTree(a));


        ArrayList<LinkedList<Integer>> linkedLists =  problem.allSequences(problem2.createBinaryTree(a));

        System.out.println("Final Result::: ==>");
        System.out.println(linkedLists);
        // printByLevel(problem2.createBinaryTree(a));
    }
}
