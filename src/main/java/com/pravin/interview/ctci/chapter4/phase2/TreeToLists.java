package com.pravin.interview.ctci.chapter4.phase2;

import com.pravin.interview.ctci.trees.TreeNode;
import com.pravin.interview.ctci.trees.phase2.CreateBinaryTree;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeToLists {

    public List<LinkedList<TreeNode>> depthList(TreeNode treeNode) {
        List<LinkedList<TreeNode>> lists = new ArrayList<>();
        depthListR(treeNode, lists, 0);
        return lists;
    }

    private void depthListR(TreeNode treeNode, List<LinkedList<TreeNode>> lists, int level) {
        if (treeNode == null) {
            return;
        }
        LinkedList<TreeNode> list = null;
        if (lists.size() == level) {
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(treeNode);
        depthListR(treeNode.left, lists, level + 1);
        depthListR(treeNode.right, lists, level + 1);
    }


    public List<LinkedList<TreeNode>> depthLinkedListBFS(TreeNode treeNode){
        List<LinkedList<TreeNode>> result = new ArrayList<>();

        LinkedList<TreeNode> current = new LinkedList<>();

        if (treeNode != null){
            current.add(treeNode);
        }

        while (!current.isEmpty()) {
            result.add(current);
            LinkedList<TreeNode> presents = current;
            current = new LinkedList<>();

            for (TreeNode node : presents  ) {
                if (node.left != null ) {
                    current.add(node.left);
                }
                if (node.right != null){
                    current.add(node.right);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeToLists treeToLists = new TreeToLists();
        CreateBinaryTree createBinaryTree = new CreateBinaryTree();
        TreeNode treeNode = createBinaryTree.creatBinaryTree(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        List<LinkedList<TreeNode>> lists = treeToLists.depthList(treeNode);
        List<LinkedList<TreeNode>> result = treeToLists.depthList(treeNode);
        System.out.println(lists);
        System.out.println(result);
    }

}
