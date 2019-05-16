package com.pravin.interview.chapter3;

import java.util.ArrayList;
import java.util.List;

public class SetOfStacks {

    List<StackWithSize> stacks = new ArrayList<>();

    @Override
    public String toString() {
        return "SetOfStacks{" +
                "stacks=" + stacks +
                '}';
    }

    public void push(int data){

        StackWithSize stack = getLastStack();

        if (stack!= null && !stack.isFull()) {
            stack.push(data);
        }else {
            StackWithSize stackWithSize = new StackWithSize();
            stackWithSize.push(data);
            stacks.add(stackWithSize);
        }
    }

    public int pop() {
        StackWithSize stackWithSize = getLastStack();

        int data = stackWithSize.pop();

        if (stackWithSize.isEmpty()) {
            stacks.remove(stackWithSize);
        }

        return data;
    }

    private StackWithSize getLastStack() {

        if (stacks.isEmpty()){
            return null;
        }else {
            return stacks.get(stacks.size() - 1);
        }
    }


    public static void main(String[] args) {
        SetOfStacks setOfStacks = new SetOfStacks();
        setOfStacks.push(1);
        setOfStacks.push(1);
        setOfStacks.push(1);setOfStacks.push(1);

        setOfStacks.push(1);setOfStacks.push(1);

        setOfStacks.push(11);setOfStacks.push(12);

        setOfStacks.push(3);setOfStacks.push(3);

        setOfStacks.push(1);setOfStacks.push(4);

        setOfStacks.push(1);setOfStacks.push(7);

        setOfStacks.push(1);setOfStacks.push(7);
        setOfStacks.push(1);setOfStacks.push(8);

        System.out.println(setOfStacks);

        setOfStacks.pop();setOfStacks.pop();


        System.out.println(setOfStacks);


    }

}
