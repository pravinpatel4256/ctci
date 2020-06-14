package com.pravin.interview.ctci.chapter2;

import com.pravin.interview.ctci.linkedlist.Node;

public class LLSum {

    public Node addLL(Node n1, Node n2){
        int carry = 0;
        Node node = new Node(0);
        return sumR(n1, n2, carry);
    }

    private Node sumR(Node n1, Node n2, int carry) {

        if(n1 == null && n2 == null) {
            return null;
        }

        int data1 = 0;
        int data2 = 0;
        Node n1Next = null;
        Node n2Next = null;

        if (n1 != null) {
            data1 = n1.data;
            n1Next = n1.next;
        }

        if (n2 != null) {
            data2 = n2.data;
            n2Next = n2.next;
        }

        int sum = carry + data1 + data2 ;
        Node n = new Node(sum%10);
        n.next = sumR(n1Next, n2Next, sum/10);
        return n;
    }

    public Node addForwardLL(Node n1, Node n2) {

       Node r1 = reverse(n1);
       Node r2 = reverse(n2);

       Node sum = addLL(r1, r2);
       Node result = reverse(sum);
       return result;
    }

    Node reverse(Node node) {
        Node current = node;
        Node prev = null;
        Node next = null;
        while (current != null ) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }


    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.appendNodeToTail(2);
        n1.appendNodeToTail(3);
        n1.appendNodeToTail(4);

        Node n2 = new Node(1);
        n2.appendNodeToTail(1);
         LLSum llSum = new LLSum();
        Node sum = llSum.addForwardLL(n1, n2);

        System.out.println(sum);

    }

}
