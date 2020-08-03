package com.pravin.interview.ctci.chapter3.phase2;

import com.pravin.interview.ctci.stacks.Stack;

import java.util.ArrayList;
import java.util.List;

public class SetOfStacks {

    private int size;
    private int limit = 3;
    private List<Stack> stacks = new ArrayList<>();

    private Stack getTop(boolean isPush) {

        if (isPush && (stacks.isEmpty() || size % limit == 0)) {
            stacks.add(new Stack());
        }
        return stacks.get(stacks.size() - 1);
    }

    void push(int plate) {

        Stack<Integer> stack = getTop(true);
        stack.push(plate);
        size++;
    }

    int pop() {
        Stack<Integer> stack = getTop(false);
        int data = stack.pop();
        size--;
        if (stack.isEmpty()) {
            stacks.remove(stack);
        }
        return data;
    }

    @Override
    public String toString() {
        return "SetOfStacks{" +
                "size=" + size +
                ", limit=" + limit +
                ", stacks=" + stacks +
                '}';
    }

    int popAt(int index) {
        return sift(index, true);
    }

    public int sift(int index, boolean removeTop) {
        Stack<Integer> stack = stacks.get(index);
        Integer removedItem;
        if (removeTop) {
            removedItem = stack.pop();
        } else {
            removedItem = stack.removeBottom();
        }
        if (stack.isEmpty()) {
            stacks.remove(stack);
        }
        if (stacks.size() > index + 1) {
          Integer v =  sift(index + 1, false);
          stack.push(v);
        }

        return removedItem;
    }

    public static void main(String[] args) {
        SetOfStacks setOfStacks = new SetOfStacks();
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);
        setOfStacks.push(5);
        setOfStacks.push(6);
        setOfStacks.push(7);
        setOfStacks.push(8);
        System.out.println(setOfStacks);

        System.out.println(setOfStacks.popAt(0));

        System.out.println(setOfStacks);

    }


}
