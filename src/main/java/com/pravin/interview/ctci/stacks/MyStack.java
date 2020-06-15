package com.pravin.interview.ctci.stacks;

public class MyStack<T> {

    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;
    private int size = 0;

    public void push(T data){
        StackNode<T> node = new StackNode<T>(data);
        node.next = top;
        top = node;
        size++;
    }

    public T pop(){
        if(top == null) throw new IllegalStateException();
        size--;
        StackNode<T> data = top;
        top = top.next;
        return data.data;
    }

    public T peek(){
        if(top == null) throw new IllegalStateException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }


    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        System.out.println(myStack.size());
        System.out.println(myStack.peek() );
        System.out.println(myStack.pop() );
        System.out.println(myStack.peek() );
        System.out.println(myStack.size());
        System.out.println(myStack.pop() );
        System.out.println(myStack.pop() );

    }
}
