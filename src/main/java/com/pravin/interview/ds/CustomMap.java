package com.pravin.interview.ds;

import java.util.HashMap;

/**
 * Implement HashMap that hold int as key and value. it would have following methods
 *
 * insert
 * get
 * addToKeys ==> add values into all keys
 * addToValues ===> add values into all values
 */
public class CustomMap {

private Entry[] table = new Entry[16];

   static class Entry {
       int key;
       int value;
       Entry next;

       public Entry(int key, int value) {
           this.key = key;
           this.value = value;
       }

       public int getKey() {
           return key;
       }

       public void setValue(int value) {
           this.value = value;
       }

       public int getValue() {
           return value;
       }
   }

    void put(int k, int v ) {

    }


    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
    }
}
