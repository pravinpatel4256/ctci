package com.pravin.interview.chapter4;

import java.util.Random;

public class TreeNodeWithSize {

    private int data;
    private TreeNodeWithSize left;
    private TreeNodeWithSize right;
    private int size;

    @Override
    public String toString() {
        return "TreeNodeWithSize{" +
                "data=" + data +
                ", size=" + size +
                '}';
    }

    public TreeNodeWithSize(int data) {
        this.data = data;
        this.size = 1;
    }

    public void insert(int data) {

        if (data <= this.data) {
            if (left == null)
                left = new TreeNodeWithSize(data);
            else {
                left.insert(data);
            }
        } else {

            if (right == null) {
                right = new TreeNodeWithSize(data);
            } else {
                right.insert(data);
            }

        }
        size++;
    }


    int size() {
        return size;
    }

    public TreeNodeWithSize getRandomNode() {
        int leftSize = (left == null) ? 0 : left.size();
        Random random = new Random();
        int index = random.nextInt(size);
        if (index < leftSize) {
            return left.getRandomNode();
        } else if (index == leftSize) {
            return this;
        }
        return right.getRandomNode();
    }

    public void print() {

        if (left != null) {
            left.print();
        }
        System.out.println(data);
        if (right != null) {
            right.print();
        }
    }

    public static void main(String[] args) {
        TreeNodeWithSize tree = new TreeNodeWithSize(10);
        tree.insert(10);
        tree.insert(12);
        tree.insert(13);
        tree.insert(14);
        tree.insert(16);
        tree.insert(1);
        tree.insert(9);

        tree.print();
        System.out.println( tree.getRandomNode());
    }

}
