package org.sedly.astar;

import org.sedly.astar.h.AStarHeuristic;

import java.awt.Point;
import java.util.*;

public class AStar {

    private Node[][] map;
    private AStarHeuristic heuristic;

    private Deque<Node> open = new LinkedList<>();
    private List<Node> closed = new ArrayList<>();


    public AStar(Node[][] map, AStarHeuristic heuristic) {
        this.map = map;
        this.heuristic = heuristic;
    }

    public List<Point> search(Point start, Point end) {

        Node nEnd = map[end.x][end.y];
        if (nEnd.isObstacle()) {
            return null;
        }

        Node nStart = map[start.x][start.y];

        open.add(nStart);

        Node cameFrom = null;

        while (!open.isEmpty()) {

            Node current = open.getFirst();

            if (current.equals(nEnd)) {
//                return reconstructPath();
            }

        }


        return null;
    }

    private List<Point> reconstructPath(Node cameFrom, Node current) {
        List<Point> path = new LinkedList<>();
        path.add(current.getPoint());

        return null;
    }


}
