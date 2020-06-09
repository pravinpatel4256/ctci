package com.pravin.interview.ctci.linkedlist;

public class Node {

    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }

    public void appendNodeToTail(int data) {
        Node node = new Node(data);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = node;
    }

    public Node deleteNode(Node head, int data) {
        if (head.data == data) {
            Node tmp = head;
            head = head.next;
            tmp.next = null;
            return head;
        }
        while (head.next != null) {
            if (head.next.data == data) {
                head.next = head.next.next;
                return head;
            } else {
                head = head.next;
            }
        }
        return head;
    }

    public Node rearrangeList(Node head){

        Node fast = head;
        Node slow = head;

        while (fast != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;

        Node _new =  head;
        Node fastNext, slowNext;
        while(slow != null){

            Node currentFast = new Node(fast.data);
            Node currentSlow = new Node(slow.data);


            slowNext = slow.next;
            fastNext = fast.next;

            if(_new == null ) {
                _new = currentFast;
                _new.next = currentSlow;
                _new = _new.next;
            }else {
                _new.next = currentFast;
                _new.next.next = currentSlow;
                _new = _new.next;
            }

            slow = slowNext;
            fast = fastNext;
        }
        return _new;
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
        n.appendNodeToTail(11);
        n.appendNodeToTail(22);
        n.appendNodeToTail(33);
        n.appendNodeToTail(44);

        Node rn = n.rearrangeList(n);
       System.out.println(rn);
        /* System.out.println(n);
        Node n2 = n.deleteNode(n, 2);
        System.out.println(n2);
        Node n3 = n.deleteNode(n, 1);
        System.out.println(n3);*/
    }
}
