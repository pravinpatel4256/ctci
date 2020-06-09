package com.pravin.interview.ctci.chapter2;

import com.pravin.interview.ctci.linkedlist.Node;

import java.util.*;
import java.util.stream.Collectors;

public class Problem1 {


    Node removeDuplicates(Node head) {
        Integer i = 1;
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


    void removeDuplicatesWithPrevious(Node head) {
        Node previous = null;
        Set<Integer> memo = new HashSet<>();
        while (head != null) {
            if (memo.contains(head.data)) {
                previous.next = head.next;
            } else {
                memo.add(head.data);
                previous = head;
            }
            head = head.next;
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
        Node node = new Node(1);
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
