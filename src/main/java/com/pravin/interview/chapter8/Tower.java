package com.pravin.interview.chapter8;

import java.util.Stack;

public class Tower {

    private Stack<Integer> disks = new Stack<>();
    private int index;

    public Tower(int index){
        this.index = index;
    }

    @Override
    public String toString() {
        return "Tower{" +
                "disks=" + disks +
                ", index=" + index +
                '}';
    }

    public void add(int disk) {
        if (disks.isEmpty() || disk < disks.peek()){
            disks.push(disk);
        }
    }

    public void moveTop(Tower destination){
        destination.add(disks.pop());
    }

    public void moveDisks(int n, Tower destination, Tower buffer){

        if(n > 0){
            moveDisks(n-1, buffer, destination);
            moveTop(destination);
            buffer.moveDisks(n-1, destination, this);
        }
    }
}
