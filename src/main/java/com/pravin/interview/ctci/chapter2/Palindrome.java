package com.pravin.interview.ctci.chapter2;

import com.pravin.interview.ctci.linkedlist.Node;

import java.util.Stack;


public class Palindrome {

    public boolean isPalindrome(Node node) {
        Node p1 = node;
        Node p2 = node;
        Stack<Integer> stack = new Stack<>();

        while (p1 != null && p1.next != null) {
            p1 = p1.next.next;
            stack.push(p2.data);
            p2 = p2.next;
        }

        if (p1 != null) {
            p2 = p2.next;
        }
        while (p2 != null) {
            if (stack.isEmpty()) {
                return false;
            } else if (p2.data != stack.pop()) {
                return false;
            }
            p2 = p2.next;
        }
        return true;
    }

    public boolean reverseAndCompare(Node node) {
        Node reverse = reverseAndClone(node);
        while (node != null) {
            if (node.data != reverse.data) {
                return false;
            }
            node = node.next;
            reverse = reverse.next;
        }
        return true;
    }

    //reverse code is there in LLSum class
    Node reverseAndClone(Node node) {

        Node head = node;
        Node reverse = null;

        while (head != null) {
            Node n = new Node(head.data);
            n.next = reverse;
            reverse = n;
            head = head.next;
        }

        return reverse;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.appendNodeToTail(2);
        node.appendNodeToTail(3);
        node.appendNodeToTail(2);
        node.appendNodeToTail(2);
        node.appendNodeToTail(2);
        node.appendNodeToTail(1);
        Palindrome palindrome = new Palindrome();
        boolean isPlain = palindrome.isPalindrome(node);
        boolean isPalindrome = palindrome.reverseAndCompare(node);
        System.out.println(isPlain);
        System.out.println(isPalindrome);
    }
}
