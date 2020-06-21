package com.pravin.interview.ctci.chapter3.phase2;

import com.pravin.interview.ctci.stacks.Stack;

public class ShortedStack {

    Stack<Integer> top = new Stack<>();
    Stack<Integer> tmp = new Stack<>();

    void push(int data) {

        if (top.isEmpty()) {
            top.push(data);
        } else {
            while (!top.isEmpty() && data > top.peek()) {
                tmp.push(top.pop());
            }
            top.push(data);

            while (!tmp.isEmpty()) {
                top.push(tmp.pop());
            }
        }
    }

    @Override
    public String toString() {
        return "ShortedStack{" +
                "top=" + top +
                ", tmp=" + tmp +
                '}';
    }

    int peek() {
        return top.peek();
    }

    int pop() {
        return top.pop();
    }

    public static void main(String[] args) {
        ShortedStack shortedStack = new ShortedStack();
        shortedStack.push(8);
        shortedStack.push(12);
        shortedStack.push(10);
        shortedStack.push(7);
        shortedStack.push(5);
        shortedStack.push(3);
        shortedStack.push(1);
        System.out.println(shortedStack);
        System.out.println(shortedStack.pop());
        System.out.println(shortedStack.pop());
        System.out.println(shortedStack.peek());
    }

}
