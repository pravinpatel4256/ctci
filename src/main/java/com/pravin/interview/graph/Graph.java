package com.pravin.interview.graph;


import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/*
Implementation of Depth first search.
 */
public class Graph {

    HashMap<Integer, Node> container = new HashMap<>();

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

    private Node getNode(int id){
        if (container.containsKey(id)) {
            return container.get(id);
        }
        Node src = new Node(id);
        container.put(id, src);
        return src;
    }

    public void addEdge(int s, int d){
        Node src = getNode(s);
        Node dest = getNode(d);
        src.adjacent.add(dest);
    }

    public boolean hasNodeDFS(int src, int dest){
        Node s = getNode(src);
        Node d = getNode(dest);
        HashSet<Integer> visited = new HashSet<>();
        return hasNodeDFS(s, d, visited);
    }

    private boolean hasNodeDFS(Node s, Node d, HashSet<Integer> visited) {

        System.out.println("Searching DFS---"+s.id);

        if (s.id == d.id) {
            return true;
        }

        visited.add(s.id);

        for(Node child: s.adjacent) {

             if (!visited.contains(child.id) && hasNodeDFS(child, d, visited)) {
                 return true;
             }
        }
        System.out.println("Searching END---");
        return false;
    }

    public boolean hasNodeBFS(int src, int dest){
        Node s = getNode(src);
        Node d = getNode(dest);
        return hasNodeBFS(s,d);
    }

    private boolean hasNodeBFS(Node source, Node dest){
        LinkedList<Node> toVisit =  new LinkedList<>();
        toVisit.add(source);
        HashSet<Integer> visited = new HashSet<>();
        while (!toVisit.isEmpty()) {

            Node node = toVisit.remove();
            System.out.println("Searching..."+ node.id);
            if (node == dest) {
                return true;
            }
            visited.add(node.id);
            for (Node child: node.adjacent) {
                if (!visited.contains(child.id)) {
                    toVisit.add(child);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(0, 2);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(5, 6);
        graph.addEdge(4, 7);
        graph.addEdge(7, 9);
        graph.addEdge(9, 11);

        System.out.println( graph.hasNodeBFS(0, 9));
        System.out.println( graph.hasNodeDFS(0, 9));

    }

}
