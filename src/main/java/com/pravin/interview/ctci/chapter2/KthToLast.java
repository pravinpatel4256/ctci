package com.pravin.interview.ctci.chapter2;

import com.pravin.interview.ctci.linkedlist.Node;

import javax.swing.plaf.synth.SynthOptionPaneUI;

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




    public static void main(String[] args) {
        Node node = new Node(10);
        node.appendNodeToTail(30);
        node.appendNodeToTail(20);
        node.appendNodeToTail(40);
        node.appendNodeToTail(50);
        node.appendNodeToTail(60);
        node.appendNodeToTail(70);
        KthToLast obj = new KthToLast();
        int size = obj.printKthToLast(node, 1);
        Node kth = obj.kthFromLast(node, 2);
        System.out.println(size);
        System.out.println(kth);

    }
}
