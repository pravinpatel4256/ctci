package com.pravin.interview.stacks;

public class StackWithMin {


    private static class MinStack{

        int data ;
        int min;
        MinStack next;

        public MinStack(int data, int min){

            this.data = data;
            this.min = min;

        }

        @Override
        public String toString() {
            return "MinStack{" +
                    "data=" + data +
                    ", min=" + min +
                    ", next=" + next +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "StackWithMin{" +
                "top=" + top +
                '}';
    }

    private MinStack  top ;


    public void push(int data){

        int min = Math.min(data, min());
        MinStack minStack = new MinStack(data, min);
        minStack.next = top;
        top = minStack;

    }

    public int min(){

        if (top == null){
            return Integer.MAX_VALUE;
        } else{
           return top.min;
        }
    }

    public int pop(){

        if (top == null) {
            throw new RuntimeException();
        }

        int data = top.data;
        top = top.next;
        return data;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public int peek() {
        if (top == null) {
            throw new RuntimeException();
        }

        return top.data;
    }

    public static void main(String[] args) {
        StackWithMin stackWithMin = new StackWithMin();
        stackWithMin.push(10);
        System.out.println(stackWithMin);
        System.out.println(stackWithMin.min());

        stackWithMin.push(10);
        stackWithMin.push(20);
        stackWithMin.push(0);
        stackWithMin.push(30);
        stackWithMin.push(0);
        System.out.println(stackWithMin);
        System.out.println(stackWithMin.min());

        stackWithMin.pop();
        stackWithMin.pop();
        System.out.println(stackWithMin.min());



    }
}
