package com.pravin.interview.ctci.chapter2;

import com.pravin.interview.ctci.linkedlist.Node;

public class Collision {

    Node hasCollision(Node node) {
        Node p1 = node;
        Node p2 = node;

        while (p1 != null && p1.next != null) {
            p1 = p1.next.next;
            p2 = p2.next;
            if (p1 == p2) {
                break;
            }
        }

        if (p1 == null || p1.next == null) {
            return null;
        }

        p1 = node;

        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.appendNodeToTail(2);
        node.appendNodeToTail(3);
        Node n = node.next.next;
        Node node1 = new Node(4);
        n.next = node1;
        Node _2 = new Node(5);
        Node _3 = new Node(6);
        Node _4 = new Node(7);
        node1.next = _2;
        _2.next = _3;
        _3.next = _4;
        _4.next = node1;

        Collision collision  = new Collision();
        Node node2 = collision.hasCollision(node);
        System.out.println(node2);
    }

}
