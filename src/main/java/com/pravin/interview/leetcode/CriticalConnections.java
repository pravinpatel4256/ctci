package com.pravin.interview.leetcode;

import javafx.util.Pair;

import java.util.*;

public class CriticalConnections {

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> results = new ArrayList<>();

        List<Integer>[] graph = new ArrayList[n];
        boolean[] visited = new boolean[n];
        int[] lowLinkValues = new int[n];

        int time = 0;

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (List<Integer> c : connections) {
            int a = c.get(0);
            int b = c.get(1);

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, i, results, graph, visited, lowLinkValues, time);
            }
        }

        return results;
    }

    public void dfs(int u, int parent, List<List<Integer>> results, List<Integer>[] graph, boolean[] visited, int[] lowLinkValues, int time) {
        time++;
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{1, 2});
        visited[u] = true;
        lowLinkValues[u] = time;
        int discovered = time;

        for (Integer cv : graph[u]) {
            if (!visited[cv]) {
                dfs(cv, u, results, graph, visited, lowLinkValues, time);

                if (lowLinkValues[cv] > discovered) {
                    results.add(Arrays.asList(u, cv));
                }
            }

            if (cv != parent) {
                lowLinkValues[u] = Math.min(lowLinkValues[cv], lowLinkValues[u]);
            }
        }
    }
}
