package com.pravin.interview.ctci.chapter10;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GroupAnagrams {


    public void group(String[] arr) {



        Map<String, List<String>> map = Stream.of(arr).collect(Collectors.toMap(this::sortString, v ->
                {List<String> a = new ArrayList<>(); a.add(v); return a;},
                (a, b) -> { a.addAll(b); return a;}));
        System.out.println(map);

        List<String>  strings = new ArrayList<>();
        int[] tmp = new int[1];
        map.keySet().forEach(key -> map.get(key).forEach(v -> { arr[tmp[0] ] = v; tmp[0]++; }));

        IntStream.range(0, arr.length).forEach(i -> {
            System.out.print(arr[i]);
            System.out.print(", ");
        });

    }

    private String sortString(String s){
        char[] ar = s.toCharArray();
        Arrays.sort(ar);
        return new String(ar);
    }




    public static void main(String[] args) {

        GroupAnagrams groupAnagrams = new GroupAnagrams();
        groupAnagrams.group(new String[]{"hello", "olleh", "hoell" , "pravin", "abc", "cba", "cab", "pqr", "olelh", "ravinp", "pravni"});

        String[] s = new String[]{"hello", "olleh", "hoell" , "pravin", "abc", "cba", "cab", "pqr", "olelh", "ravinp", "pravni"};

        System.out.println();
        Arrays.sort(s, new AnagramsCompare());
        IntStream.range(0 , s.length).forEach(i -> System.out.print(s[i] + " ,") );
    }
}

class AnagramsCompare implements Comparator<String> {

    private String sortString(String s){
        char[] ar = s.toCharArray();
        Arrays.sort(ar);
        return new String(ar);
    }

    @Override
    public int compare(String o1, String o2) {
        return sortString(o1).compareTo(sortString(o2));
    }

}
