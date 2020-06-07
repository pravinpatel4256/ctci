package com.pravin.interview.ctci.chapter4;

import com.pravin.interview.ctci.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Problem3 {

    public static void printByLevel(TreeNode treeNode){

        ArrayList<LinkedList<TreeNode>> resultList = new ArrayList<>();
        if (treeNode == null) {
            return;
        }

        LinkedList<TreeNode> toVisit = new LinkedList<>();

        toVisit.add(treeNode);


        while(!toVisit.isEmpty()){
            resultList.add(toVisit);
            LinkedList<TreeNode> parents  =  toVisit;
            toVisit = new LinkedList<>();


            for (TreeNode currentNode : parents) {
                if (currentNode.left != null) {
                    toVisit.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    toVisit.add(currentNode.right);
                }
            }



        }

        System.out.println(resultList);


    }
}
