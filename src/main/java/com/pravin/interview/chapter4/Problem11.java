package com.pravin.interview.chapter4;

public class Problem11 {
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
