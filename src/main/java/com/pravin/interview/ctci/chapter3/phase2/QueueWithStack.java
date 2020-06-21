package com.pravin.interview.ctci.chapter3.phase2;

import com.pravin.interview.ctci.stacks.Stack;

public class QueueWithStack {

    private Stack<Integer> head = new Stack<>();
    private Stack<Integer> tail = new Stack<>();

    void add(int data) {
        head.push(data);
    }

    int remove(){
        if (tail.isEmpty()) {
            moveHeadToTail();
        }
        int data = tail.pop();
        return data;
    }

    int peek(){
        if (tail.isEmpty()) {
            moveHeadToTail();
        }
        int data = tail.peek();
        return data;
    }

    private void moveHeadToTail() {
        while (!head.isEmpty()) {
            tail.push(head.pop());
        }
    }

    public static void main(String[] args) {
        QueueWithStack queueWithStack = new QueueWithStack();
        queueWithStack.add(1);
        queueWithStack.add(2);
        queueWithStack.add(3);
        queueWithStack.add(4);
        queueWithStack.add(5);
        queueWithStack.add(6);

        System.out.println(queueWithStack.peek());
        System.out.println(queueWithStack.remove());
        System.out.println(queueWithStack.remove());
        System.out.println(queueWithStack.remove());
    }
}
