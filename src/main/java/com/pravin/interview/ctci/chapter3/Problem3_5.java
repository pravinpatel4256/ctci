package com.pravin.interview.ctci.chapter3;

import java.util.Stack;

public class Problem3_5 {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> tmp = new Stack<>();

    @Override
    public String toString() {
        return "Problem3_5{" +
                "stack=" + stack +
                ", tmp=" + tmp +
                '}';
    }

    public void push(int data) {
        stack.push(data);
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void sort(){
        Stack<Integer> tmp = new Stack<>();

        while (!this.isEmpty()) {

            int temp = this.pop();

            while (!tmp.isEmpty() && tmp.peek() < temp) {
                push(tmp.pop());
            }
            tmp.push(temp);
        }

        while(!tmp.isEmpty()){
            push(tmp.pop());
        }


    }



    public static void main(String[] args) {
        Problem3_5 sortedStack = new Problem3_5();
        sortedStack.push(1);
        sortedStack.push(2);
        sortedStack.push(12);
        sortedStack.push(4);
        sortedStack.push(1);
        sortedStack.push(2);
        sortedStack.push(3);
        System.out.println(sortedStack);
        //SortedStack{stack=[4, 3, 2, 2, 1, 1], tmp=[]}
        sortedStack.sort();

        System.out.println(sortedStack );
        // o/p : 1
    }


}
