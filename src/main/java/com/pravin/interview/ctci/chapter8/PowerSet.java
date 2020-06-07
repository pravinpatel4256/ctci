package com.pravin.interview.ctci.chapter8;

import java.util.ArrayList;

public class PowerSet {

    public ArrayList<ArrayList<Integer>> powerIt(ArrayList<Integer> set){


        if (set == null ) {
            return null;
        }
        return powerItR(set, 0);

    }

    private ArrayList<ArrayList<Integer>> powerItR(ArrayList<Integer> set, int i) {

        ArrayList<ArrayList<Integer>> allSubSets ;

        if (set.size() == i) {
            allSubSets = new ArrayList<>();
            allSubSets.add(new ArrayList<Integer>());
        }else {
            allSubSets = powerItR(set, i+1);
            int item = set.get(i);

            ArrayList<ArrayList<Integer>> moreSubSet =  new ArrayList<>();
            for(ArrayList<Integer> subset : allSubSets){
                ArrayList<Integer> newSubSet = new ArrayList<>();
                newSubSet.addAll(subset);
                newSubSet.add(item);
                moreSubSet.add(newSubSet);

            }
            allSubSets.addAll(moreSubSet);
        }

        return allSubSets;
    }
}
