package com.pravin.interview.ctci.linkedlist;

public class Node {

    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }

    public void appendNodeToTail(int data){
        Node node = new Node(data);
        Node n = this;
        while(n.next != null){
            n = n.next;
        }
        n.next = node;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }

    public static void main(String[] args) {
        Node n = new Node(1);
        n.appendNodeToTail(2);
        n.appendNodeToTail(3);
        n.appendNodeToTail(4);
        System.out.println(n);
    }
}
