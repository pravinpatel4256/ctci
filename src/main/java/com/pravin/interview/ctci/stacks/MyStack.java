package com.pravin.interview.ctci.stacks;

public class MyStack {

    private static class StackNode<Integer> {
        private Integer data;
        private StackNode<Integer> next;

        public StackNode(Integer data) {
            this.data = data;
        }
    }

    private StackNode<Integer> top;
    private int size = 0;

    public void push(Integer data){
        StackNode<Integer> node = new StackNode<>(data);
        node.next = top;
        top = node;
        size++;
    }

    public Integer pop(){
        if(top == null) throw new IllegalStateException();
        size--;
        StackNode<Integer> data = top;
        top = top.next;
        return data.data;
    }

    public Integer peek(){
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
        MyStack myStack = new MyStack();
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
        System.out.println(myStack.peek() );
    }
}
