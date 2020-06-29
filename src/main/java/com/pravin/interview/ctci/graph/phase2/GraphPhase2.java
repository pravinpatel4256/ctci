package com.pravin.interview.ctci.graph.phase2;

import java.util.*;

public class GraphPhase2 {

    private static class Node {
        int id;
        LinkedList<Node> adjacent = new LinkedList<>();

        public Node(int id){
            this.id  = id;
        }
    }

    private Map<Integer, Node> container = new HashMap<>();

    public void addEdge(int source, int destination){
        Node s = getNode(source);
        Node d = getNode(destination);
        s.adjacent.add(d);
    }

    public Node getNode(int id){
        if(container.containsKey(id)) {
            return container.get(id);
        }
        Node node = new Node(id);
        container.put(id, node);
        return node;
    }

    public boolean isConnectedDFS(int s, int d){
        Node source = getNode(s);
        Node destination = getNode(d);
        Set<Integer> visited = new HashSet<>();

       return searchDFS(source, destination, visited);

    }

    private boolean searchDFS(Node source, Node destination, Set<Integer> visited) {
        if (source == null) return false;
        if (source.id == destination.id) {
            return true;
        }
        visited.add(source.id);

        for (Node n : source.adjacent) {
            if (!visited.contains(n.id)) {
               boolean valid = searchDFS(n, destination, visited);
               if (valid) {
                   return true;
               }
            }
        }
        return false;
    }

    public boolean isConnectedBFS(int s, int d){
        if (s == d) {
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Node source = getNode(s);
        Node destination = getNode(d);
        queue.add(source);
        visited.add(source.id);

        while (!queue.isEmpty()) {
            Node  r = queue.remove();
             if (r != null) {
                 for (Node n : r.adjacent) {
                        if (n.id == d) {
                            return true;
                        }else {
                            if (!visited.contains(n.id)) {
                              visited.add(n.id);
                              queue.add(n);
                            }
                        }
                 }
             }
        }

        return false;

    }

}
