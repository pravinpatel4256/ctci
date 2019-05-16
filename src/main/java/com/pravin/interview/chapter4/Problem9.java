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

        System.out.println("first = [" + first + "], second = [" + second + "], weaved = [" + weaved + "], prefix = [" + prefix + "]");

        if (first.size() == 0 || second.size() == 0) {
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            weaved.add(result);
            System.out.println("----");
            return;
        }

        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveList(first, second, weaved, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaveList(first, second, weaved, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);


    }


    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        Problem9  problem = new Problem9();
        int a[] = {1, 2,3,4};
        //System.out.println(problem2.createBST(a));


        ArrayList<LinkedList<Integer>> linkedLists =  problem.allSequences(problem2.createBST(a));

        System.out.println("Final Result::: ==>");
        System.out.println(linkedLists);
        // printByLevel(problem2.createBST(a));
    }
}
