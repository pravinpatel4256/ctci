package com.pravin.interview.ctci.chapter2;

import com.pravin.interview.ctci.linkedlist.Node;

public class DeleteMiddleNode {

    public boolean deleteMiddle(Node head){
        if(head == null || head.next == null) {
            return false;
        }
        Node next = head.next;
        head.data = next.data;
        head.next = next.next;
        return true;
    }

    public static void main(String[] args) {
        DeleteMiddleNode middleNode = new DeleteMiddleNode();
        Node node = new Node(10);
        node.appendNodeToTail(20);
        node.appendNodeToTail(50);
        node.appendNodeToTail(60);
        middleNode.deleteMiddle(node);
        System.out.println(node);
    }
}
