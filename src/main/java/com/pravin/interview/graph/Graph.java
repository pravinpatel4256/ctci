package com.pravin.interview.graph;


import java.util.HashSet;
import java.util.LinkedList;

/*
Implementation of Depth first search.
 */
public class Graph {

    public static class Node {

        private int id;
        private LinkedList<Node> adjacent = new LinkedList<>();

        private Node(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +
                    ", adjacent=" + adjacent +
                    '}';
        }


    }


    public boolean hasNodeDFS(int src, int dest){
        Node s = new Node(src);
        Node d = new Node(dest);
        HashSet<Integer> visited = new HashSet<>();
        return hasNodeDFS(s, d, visited);
    }

    private boolean hasNodeDFS(Node s, Node d, HashSet<Integer> visited) {

        if (visited.contains(s.id)) {
            return false;
        }

        if (s.id == d.id) {
           return true;
        }
        visited.add(s.id);

        for(Node child: s.adjacent) {
             if (hasNodeDFS(child, d, visited)) {
                 return true;
             }
        }
        return false;
    }

    public boolean hasNodeBFS(int src, int dest){
        Node s = new Node(src);
        Node d = new Node(dest);
        return hasNodeBFS(s,d);
    }

    private boolean hasNodeBFS(Node source, Node dest){
        LinkedList<Node> toVisit =  new LinkedList<>();
        toVisit.add(source);
        HashSet<Integer> visited = new HashSet<>();
        while (!toVisit.isEmpty()) {
            Node node = toVisit.remove();
            if (node == dest) {
                return true;
            }
            visited.add(source.id);
            for (Node child: source.adjacent) {
                if (!visited.contains(child.id)) {
                    toVisit.add(child);
                }
            }
        }

        return false;
    }


}
