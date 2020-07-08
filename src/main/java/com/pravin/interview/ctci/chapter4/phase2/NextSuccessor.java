package com.pravin.interview.ctci.chapter4.phase2;

public class NextSuccessor {

    static class TreeNodeWithParent {
        int data;
        TreeNodeWithParent left;
        TreeNodeWithParent right;
        TreeNodeWithParent parent;

        public TreeNodeWithParent(int data) {
            this.data = data;
        }
    }


    TreeNodeWithParent successor(TreeNodeWithParent node) {

        if (node == null) {
            return null;
        }

        if (node.right != null) {
            return leftMostNode(node.right);
        }

        TreeNodeWithParent q = node;
        TreeNodeWithParent x = q.parent;

        while (x != null && x.left != q) {
            q = x;
            x = x.parent;
        }
        return x;
    }

    private TreeNodeWithParent leftMostNode(TreeNodeWithParent node) {
        if (node == null) {
            return null;
        }

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }
}
