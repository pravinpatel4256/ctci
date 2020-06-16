package com.pravin.interview.ctci.chapter3.phase2;

import com.pravin.interview.ctci.stacks.Stack;

public class StackWithMin {

    private static class StackNode {
        int data;
        StackNode next;

        public StackNode(int data) {
            this.data = data;
        }
    }

    private StackNode top;
    private Stack<Integer> minStack = new Stack<>();

    public void push(int data){

        int min = Math.min(data, min());
        StackNode  node = new StackNode(data);
        if (min != min()) {
            minStack.push(min);
        }
        node.next = top;
        top = node;
    }

    public int min () {
        if (minStack.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return minStack.peek();
    }

    int pop() {
        if (top == null) {
            throw new RuntimeException();
        }
        int data = top.data;
        int min = Math.min(data, min());
        if (min == min()) {
            minStack.pop();
        }
        top = top.next;
        return data;
    }

    int peek() {
        if (top == null) {
            throw new RuntimeException();
        }
        return top.data;
    }

    public static void main(String[] args) {
        StackWithMin stackWithMin = new StackWithMin();
        stackWithMin.push(10);
        stackWithMin.push(29);
        stackWithMin.push(1);
        stackWithMin.push(22);

        System.out.println(stackWithMin.min());
        System.out.println(stackWithMin.pop());
        System.out.println(stackWithMin.pop());
        System.out.println(stackWithMin.min());
        System.out.println(stackWithMin.pop());

    }

};




