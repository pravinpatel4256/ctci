package com.pravin.interview.chapter3;

import java.util.Stack;

public class StackWithSize  extends Stack<Integer> {


    private int size = 0;
    private final int max_size = 4;

    @Override
    public String toString() {
        return "StackWithSize{" +
                "size=" + size +
                ", max_size=" + max_size +
                '}';
    }

    @Override
    public Integer push(Integer item) {
        size++;
        return super.push(item);
    }

    @Override
    public synchronized Integer pop() {
        size--;
        return super.pop();
    }

    public boolean isFull(){
        return size == max_size;
    }
}
