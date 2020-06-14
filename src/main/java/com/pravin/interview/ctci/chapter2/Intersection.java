package com.pravin.interview.ctci.chapter2;

import com.pravin.interview.ctci.linkedlist.Node;

public class Intersection {

    class Result {
     Node tail;
     int size;

        public Result(Node tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }
    public Node isIntersecting(Node node1, Node node2) {

        Result r1 = lengthAndTail(node1);
        Result r2 = lengthAndTail(node2);

        if (r1 == null || r2 == null || r2.tail != r1.tail) {
            return null;
        }


        if (r1.size > r2.size) {
            node1 = forward(node1, r1.size - r2.size);
        } else if (r1.size  < r2.size ) {
            node2 = forward(node2, r2.size - r1.size);
        }

        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }

    private Node forward(Node node, int steps) {
        int count = 0;
        while (node != null && steps != count) {
            count++;
            node = node.next;
        }
        return node;
    }

    private Result lengthAndTail(Node node) {
       if(node == null) {
           return null;
       }

        int size = 1;
        while (node.next != null) {
            size++;
            node = node.next;
        }
        return new Result(node, size );
    }


    public static void main(String[] args) {
        Node node1 = new Node(10);
        node1.appendNodeToTail(20);
        node1.appendNodeToTail(30);
        node1.appendNodeToTail(40);
        node1.appendNodeToTail(50);
        node1.appendNodeToTail(60);

        Node node2 = new Node(11);
        node2.appendNodeToTail(22);
        node2.appendNodeToTail(33);
        node2.appendNodeToTail(44);
        node2.next.next.next.next = node1.next.next;

        System.out.println(node1);
        System.out.println(node2);

        Intersection intersection = new Intersection();
        Node intersectionNode = intersection.isIntersecting(node1, node2);
        System.out.println(intersectionNode);
    }

}
