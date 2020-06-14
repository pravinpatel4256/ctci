package com.pravin.interview.ctci.chapter2;

import com.pravin.interview.ctci.linkedlist.Node;

import java.util.*;
import java.util.stream.Collectors;

public class Problem1 {


    Node removeDuplicates(Node head) {
        Set<Integer> memo = new HashSet<>();
        memo.add(head.data);
        while (head.next != null) {
            if (memo.contains(head.next.data)) {
                head.next = head.next.next;
            } else {
                memo.add(head.next.data);
                head = head.next;
            }
        }
        return head;
    }


    void removeDuplicatesWithPrevious(Node current) {
        Node previous = null;
        Set<Integer> memo = new HashSet<>();
        while (current != null) {
            if (memo.contains(current.data)) {
                previous.next = current.next;
            } else {
                memo.add(current.data);
                previous = current;
            }
            current = current.next;
        }
    }

    void dupsWithNoBuffer(Node head) {
        Node previous = null;
        Node faster = null;

        while (head != null) {
            int data = head.data;
            faster = head;
            while(faster.next != null ) {
                if( faster.next.data == data) {
                    faster.next = faster.next.next;
                }else {
                    faster = faster.next;
                }
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        final Node node = new Node(1);
        node.appendNodeToTail(2);
        node.appendNodeToTail(2);
        node.appendNodeToTail(3);
        node.appendNodeToTail(3);
        node.appendNodeToTail(4);
        Problem1 problem1 = new Problem1();
        System.out.println(node);
        //problem1.removeDuplicates(node);
        problem1.dupsWithNoBuffer(node);
        System.out.println(node);
    }


}
