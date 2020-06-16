package com.pravin.interview.ctci.chapter3.phase2;

public class FixedMultiStack {

    int stacks = 3;
    int capacity;
    int values[];
    int sizes[];

    public FixedMultiStack(int capacity) {
        this.capacity = capacity;
        values = new int[stacks * capacity];
        sizes = new int[stacks];
    }

    public void push(int stackId, int data) {
        if (isFull(stackId)) {
            throw new RuntimeException();
        }
        sizes[stackId]++;
        int index = topOfStack(stackId);
        values[index] = data;
    }

    private boolean isFull(int stackId) {
        return sizes[stackId] >= capacity;
    }

    public int pop(int stackId) {
        if (isEmpty(stackId)) {
            throw new RuntimeException();
        }
        sizes[stackId]--;
        int idx = topOfStack(stackId);
        int data = values[idx];
        values[idx] = 0;
        return data;
    }

    private boolean isEmpty(int stackId) {
        return sizes[stackId] == 0;
    }

    public int peek(int stackId) {
        int idx = topOfStack(stackId);
        return values[idx];
    }

    private int topOfStack(int stackId) {
        int offset = stackId * capacity;
        int top = offset + sizes[stackId]  - 1;
        return  top;
    }

    public static void main(String[] args) {
        FixedMultiStack stack = new FixedMultiStack(10);
        stack.push(1, 10);
        stack.push(1, 10);
        stack.push(2, 20);
        stack.push(2, 20);
        stack.push(0, 30);

        System.out.println(stack.peek(1));
        System.out.println(stack.peek(2));
        System.out.println(stack.peek(0));

    }
}
