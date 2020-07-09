package com.pravin.interview.ctci.chapter4.phase2.projects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Project {

    private List<Project> children = new ArrayList<>();
    HashMap<String, Project> map = new HashMap<>();
    String name;
    int dependencies = 0;

    public Project(String name) {
        this.name = name;
    }

    public void addNeighbour(Project node){

        if ( !map.containsKey(node.name)) {
            map.put(node.name, node);
            children.add(node);
            dependencies++;
        }
    }

    public int getDependencies() {
        return dependencies;
    }

    public int decrementDependencies(){
        return dependencies--;
    }

}
