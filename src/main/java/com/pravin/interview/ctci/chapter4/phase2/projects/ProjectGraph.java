package com.pravin.interview.ctci.chapter4.phase2.projects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectGraph {

    List<Project> nodes = new ArrayList<>();
    Map<String,  Project> map = new HashMap<>();

    public Project getOrCreateNode(String name){
        if (!map.containsKey(name)) {
            Project project = new Project(name);
            map.put(name, project);
        }
        return map.get(name);
    }

}
