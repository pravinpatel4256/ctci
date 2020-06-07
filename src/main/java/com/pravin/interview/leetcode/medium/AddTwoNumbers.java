package com.pravin.interview.leetcode.medium;

import com.pravin.interview.leetcode.ListNode;

class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int reminder = 0;
        ListNode result = new ListNode();
        result = sum(l1, l2, 0);
        return result;

    }


    ListNode sum(ListNode l1, ListNode l2, int reminder) {
        ListNode result = null;

        if (l1 == null && l2 == null) {
            if (reminder > 0) {
                return new ListNode(reminder);
            }

        } else {
            int tmp = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            int s = reminder + tmp;
            result = new ListNode(s % 10, sum((l1 != null ? l1.next : null), (l2 != null ? l2.next : null), s / 10));

        }
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3, new ListNode(4, new ListNode(2, null)));
        ListNode l2 = new ListNode(4, new ListNode(6, new ListNode(5, null)));
        AddTwoNumbers obj = new AddTwoNumbers();
        System.out.println(obj.addTwoNumbers(l1, l2));
    }
}