package com.pravin.interview.ctci.moderate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DivingBoard {

    int count = 0;
    public HashSet<Integer> getAllLengths(int k , int shorter, int longer){
        HashSet<Integer> lengths = new HashSet<>();
        getAllLengthsR(k, 0, shorter, longer, lengths);
        System.out.println(count);
        return lengths;
    }

    public HashSet<Integer> getAllLengthsMemo(int k , int shorter, int longer){
        HashSet<Integer> lengths = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        getAllLengthsR(k, 0, shorter, longer, lengths, visited);
        System.out.println(count);
        return lengths;
    }

    private void getAllLengthsR(int k, int total, int shorter, int longer, HashSet<Integer> lengths, HashSet<String> visited) {

        if (k == 0) {
            lengths.add(total);
            return;
        }

        String key = k + "-"+total;
        if (visited.contains(key)) {
            return;
        }

        count++;
        getAllLengthsR(k-1, total + shorter, shorter, longer, lengths, visited);
        getAllLengthsR(k-1, total + longer, shorter, longer, lengths, visited);
        visited.add(key);
    }

    private void getAllLengthsR(int k, int total, int shorter, int longer, HashSet<Integer> lengths) {

        if (k == 0) {
            lengths.add(total);
            return;
        }
        count++;
        getAllLengthsR(k-1, total + shorter, shorter, longer, lengths);
        getAllLengthsR(k-1, total + longer, shorter, longer, lengths);
    }

}
