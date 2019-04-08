package com.pravin.interview.chapter4;

public class Problem11 {
    public static void main(String[] args) {
        TreeNodeWithSize tree = new TreeNodeWithSize(10);
        tree.insert(10);
        tree.insert(11);
        tree.insert(12);
        tree.insert(13);
        tree.insert(15);
        tree.insert(14);
        tree.insert(19);
        tree.insert(1);
        tree.insert(9);

        Double pow = Math.pow(10, 3);
        pow.intValue();
        System.out.println(pow.intValue());
        tree.print();
        System.out.println( tree.getRandomNode());
    }

}
