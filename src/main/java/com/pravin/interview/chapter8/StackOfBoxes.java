package com.pravin.interview.chapter8;

import java.util.Collections;
import java.util.List;

public class StackOfBoxes {


    int createStacks(List<Box> boxes) {

        int [] stackMap = new int[boxes.size()];
        Collections.sort(boxes);
        int maxHeight = 0;
        for (int i = 0; i< boxes.size(); i++) {
            int height = createStacksR(boxes, i, stackMap);
            maxHeight = Math.max(height, maxHeight);
        }

        return maxHeight;
    }

    private int createStacksR(List<Box> boxes, int bottomIndex, int[] stackMap) {

        if (bottomIndex < boxes.size() && stackMap[bottomIndex] > 0) {
            return stackMap[bottomIndex];
        }

        Box bottom = boxes.get(bottomIndex);
        int maxHeight = 0;

        for (int i = bottomIndex + 1; i < boxes.size(); i++) {
            if (boxes.get(i).canBeAbove(bottom)) {
                int height = createStacksR(boxes, i, stackMap);
                maxHeight =  Math.max(maxHeight, height);
            }
        }

        maxHeight += bottom.height;
        stackMap[bottomIndex] = maxHeight;
        return maxHeight;
    }


}
