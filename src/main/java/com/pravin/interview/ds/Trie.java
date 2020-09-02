package com.pravin.interview.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {


    private class TNode {

        private Map<Character, TNode> children = new HashMap<>();
        private Character ch;

        public TNode (Character ch){
            this.ch = ch;
        }

        public void addChild(Character ch){
            children.putIfAbsent(ch, new TNode(ch));
        }

        public TNode getChild(Character ch){
           return children.getOrDefault(ch, null);
        }

    }

    private TNode root = null;

    public Trie(){
        root = new TNode('*');
    }


    public void add(String str) {
        TNode current = root;
        for (Character ch : str.toCharArray()) {
            current.addChild(ch);
            current = current.getChild(ch);
        }
    }

    public int find(String str){
        TNode current = root;
        for(Character ch : str.toCharArray()){
            TNode child = current.getChild(ch);
            if (child == null) {
                return 0;
            }
            current = child;
        }
        return current.children.size();
    }

    public static void main(String[] args) {
        List<Integer> output = new ArrayList<>();

    }

}
