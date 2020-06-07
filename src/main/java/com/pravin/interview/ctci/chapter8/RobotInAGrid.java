package com.pravin.interview.ctci.chapter8;

import java.util.ArrayList;
import java.util.HashMap;

public class RobotInAGrid {

    public ArrayList<Point> getPathtoHome(boolean[][] maze){

        if (maze == null || maze.length == 0) {
            return null;
        }

        ArrayList<Point> points = new ArrayList<>();
        HashMap<Point, Boolean> cache = new HashMap<>();
        int lastRow = maze.length - 1;
        int lastCol = maze[0].length - 1;

        if (getPathR(maze, lastRow, lastCol, points, cache)) {
            return points;
        }

        return null;


    }

    private boolean getPathR(boolean[][] maze, int r, int c, ArrayList<Point> points, HashMap<Point, Boolean> cache) {
        boolean isNotValid = false;
        if (r < 0 || c < 0 || maze[r][c] == isNotValid) {
            return false;
        }

        Point p = new Point(r,c);

        if (cache.containsKey(p)) {
            return cache.get(p);
        }

        boolean isOrigin = (r == 0) && (c == 0);

        if (isOrigin || getPathR(maze, r-1, c, points, cache) || getPathR(maze, r, c -1, points, cache)) {
            points.add(p);
            cache.put(p, true);
            return true;
        }
        cache.put(p, false);
        return false;
    }


}
