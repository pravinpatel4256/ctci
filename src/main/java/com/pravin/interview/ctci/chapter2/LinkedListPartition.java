package com.pravin.interview.ctci.chapter2;

import com.pravin.interview.ctci.linkedlist.Node;

public class LinkedListPartition {
    
    Node partition(Node node, int pivot){
        
        if (node == null) {
            return null;
        }

        Node before = null;
        Node after = null;

        Node _before = null, _after = null;

        while (node != null ) {
            Node next = node.next;
            node.next = null;

            if (node.data < pivot) {
                if (before != null ) {
                    before.next = node;
                     before = node;
                }else {
                    _before = node;
                    before = _before;
                }
            } else {
                if (after != null ) {
                    after.next = node;
                    after = node;
                }else {
                    _after = node;
                    after = _after;
                }
            }
            node = next;
        }

        before.next = _after;

        return _before;
    }

    public Node partitionOptimal(Node node, int pivot){

        Node head = node;
        Node tail = node;

        while (node != null) {
            Node next = node.next;
            if (pivot > node.data) {
                node.next = head;
                head = node;
            }else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;
        return head;
    }


    public static void main(String[] args) {
        Node node = new Node(3);
        node.appendNodeToTail(5);
        node.appendNodeToTail(8);
        node.appendNodeToTail(5);
        node.appendNodeToTail(10);
        node.appendNodeToTail(2);
        node.appendNodeToTail(1);
        LinkedListPartition partition = new LinkedListPartition();
        Node result = partition.partitionOptimal(node, 5);
        System.out.println(result);
    }
}
