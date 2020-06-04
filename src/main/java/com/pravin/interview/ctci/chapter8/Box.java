package com.pravin.interview.ctci.chapter8;

public class Box  implements  Comparable<Box> {

     int height;
     int width;
     int depth;

    @Override
    public String toString() {
        return "Box{" +
                "height=" + height +
                '}';
    }

    public Box(int height, int width, int depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    @Override
    public int compareTo(Box o) {
        return o.height - this.height;
    }

    public boolean canBeAbove(Box bottom) {
        return this.height < bottom.height;
    }
}
