package org.sedly.astar.tutorial;

import org.sedly.astar.h.AStarHeuristic;
import org.sedly.astar.h.DiagonalHeuristic;

import java.awt.*;
import java.util.ArrayList;

public class TestAStar {

    private static int mapWith = 159;
    private static int mapHeight = 118;

    private static int startX = 50;
    private static int startY = 12;
    private static int goalX = 110;
    private static int goalY = 75;


    private static int[][] initMap() throws Exception {
        return new int[mapWith][mapHeight];
    }


    public static void main(String[] args) throws Exception {
        StopWatch s = new StopWatch();

        AreaMap map = new AreaMap(mapWith, mapHeight, initMap());

        AStarHeuristic heuristic = new DiagonalHeuristic();

        AStar aStar = new AStar(map, heuristic);

        s.start();
        ArrayList<Point> shortestPath = aStar.calcShortestPath(startX, startY, goalX, goalY);
        s.stop();


        new PrintMap(map, shortestPath);
    }

}
