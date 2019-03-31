package com.pravin.interview.stacks;

public class Stack<T> {

    private static final int MAX_SIZE = 4 ;
    private int size  = 0 ;

    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "StackNode{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }


    private StackNode<T> top;

    @Override
    public String toString() {
        return "Stack{" +
                "top=" + top +
                '}';
    }

    public void push(T data) {
        StackNode<T> stackNode = new StackNode<>(data);
        stackNode.next = top;
        top = stackNode;
        ++size;
    }

    public T pop(){
        if (top == null) {
            throw  new RuntimeException();
        }
        T data = top.data;
        top = top.next;
        --size;
        return data;
    }


    public T peek() {
        if (top == null) {
            throw  new RuntimeException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public boolean isFull(){
        return size == MAX_SIZE;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);

    }
}
