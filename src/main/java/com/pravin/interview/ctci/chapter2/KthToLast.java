package com.pravin.interview.ctci.chapter2;

import com.pravin.interview.ctci.linkedlist.Node;

public class KthToLast {

    int printKthToLast(Node head, int k){
        if (head == null) {
            return 0;
        }
        int index = printKthToLast(head.next, k) + 1;
        System.out.println(head.data);
        if (index == k) {
            System.out.println(String.format("Kth Element form last is %d", head.data));
        }

        return index;
    }


    class Index {
        int val;
    }

    public Node kthFromLast(Node head, int k){
        Index index = new Index();
        return kthToLast(head, k, index);
    }

    Node kthToLast(Node head, int k, Index index){
        if (head == null) {
            return null;
        }
        Node node = kthToLast(head.next, k, index);
        index.val++;
        if (index.val == k) {
            return head;
        }
        return node;
    }

    Node kthToLastItr(Node head, int k){
        Node p1 = head;
        Node p2 = head;

        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }

        while(p1 != null ) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public static void main(String[] args) {
        Node node = new Node(10);
        node.appendNodeToTail(30);
        node.appendNodeToTail(20);
        node.appendNodeToTail(40);
        node.appendNodeToTail(50);
        node.appendNodeToTail(60);
        node.appendNodeToTail(70);
        KthToLast obj = new KthToLast();
        System.out.println(node);
       // int size = obj.printKthToLast(node, 1);
        Node kth = obj.kthFromLast(node, 2);
        System.out.println(kth);

        System.out.println(node);
        kth = obj.kthToLastItr(node, 2);
        System.out.println(kth);

    }
}
