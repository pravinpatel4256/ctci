package com.pravin.interview.ctci.chapter8;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem2 {

    public static void main(String[] args) {
        RobotInAGrid  robot = new RobotInAGrid();

        int n = 3;
        boolean[][] maze = new boolean[n][n];
        for (int i = 0; i< n; i++) {
            boolean[] mazeCol = new boolean[n];
            Arrays.fill(mazeCol, true);
            maze[i] = mazeCol;
        }
        maze[0][2] = false;
        //maze[1][1] = false;

        ArrayList<Point> paths = robot.getPathtoHome(maze);
        System.out.println(paths);
    }
}
