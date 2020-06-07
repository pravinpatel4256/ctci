package com.pravin.interview.ctci.chapter2;

import java.util.*;
import java.util.stream.Collectors;

public class Problem1 {


   static Queue removeDuplicates(LinkedList<Integer> linkedList) {
         Integer i = 1;
         linkedList = linkedList.stream().distinct().collect(Collectors.toCollection(LinkedList::new));

         

//         List<Integer> integers= Arrays.asList(1,2,53,66,55,99,6989,99,33);
        // Map<Integer, Integer> map2 = linkedList.stream().distinct().collect(Collectors.toMap(Integer::intValue, Integer::intValue));
         System.out.println(linkedList);

        return linkedList;
    }


    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.addAll(Arrays.asList(2, 3, 4, 5, 5, 5 , 5 , 5));

        linkedList.add(5);

        linkedList.forEach(System.out::print);

        removeDuplicates(linkedList);
    }
}
