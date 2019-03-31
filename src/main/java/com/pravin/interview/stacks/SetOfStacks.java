package com.pravin.interview.stacks;

import java.util.ArrayList;
import java.util.List;

public class SetOfStacks {

    private List<Stack<Integer>>  stacks = new ArrayList<>();
    private int stackSize = 3;

    @Override
    public String toString() {
        return "SetOfStacks{" +
                "stacks=" + stacks +
                ", stackSize=" + stackSize +
                '}';
    }

    public void push(int data) {

        Stack<Integer> stack = getLastStack();
        if (stack != null && !stack.isFull()) {
             stack.push(data);
        } else {
            Stack<Integer> stack1 = new Stack<>();
            stack1.push(data);
            stacks.add(stack1);
        }
    }

    public int pop(){

        Stack<Integer> stack = getLastStack();
        if (stack == null) {
            throw new RuntimeException();
        }
        int data = stack.pop();

        if(stack.isEmpty()) {
            stacks.remove(stack);
        }

        return data;
    }



    private Stack<Integer> getLastStack() {
        if (stacks.isEmpty()) {
            return null;
        }
       return stacks.get(stacks.size() - 1);
    }

    public static void main(String[] args) {
        SetOfStacks setOfStacks = new SetOfStacks();
        setOfStacks.push(1);
        setOfStacks.push(1);
        setOfStacks.push(1);
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(12);
        setOfStacks.push(2);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(3);
        setOfStacks.push(3);
        setOfStacks.push(3);

        System.out.println(setOfStacks);

        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());

        System.out.println(setOfStacks);
    }
}
