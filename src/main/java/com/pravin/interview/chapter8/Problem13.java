package com.pravin.interview.chapter8;

import java.util.ArrayList;
import java.util.List;

public class Problem13 {



    public static void main(String[] args) {
        StackOfBoxes stackOfBoxes = new StackOfBoxes();
        List<Box>  boxes = new ArrayList<>();
        boxes.add(new Box(10, 10, 10));
        boxes.add(new Box(11, 10, 10));
        boxes.add(new Box(2, 10, 10));
        boxes.add(new Box(13, 10, 10));
        boxes.add(new Box(1, 10, 10));
        boxes.add(new Box(10, 10, 10));
        boxes.add(new Box(13, 10, 10));
        boxes.add(new Box(9, 10, 10));
        boxes.add(new Box(1, 10, 10));
        boxes.add(new Box(4, 10, 10));
        boxes.add(new Box(1, 10, 10));

        int height = stackOfBoxes.createStacks(boxes);

        System.out.println(height);
    }
}
