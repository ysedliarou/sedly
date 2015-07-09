package org.sedly.astar;

import java.awt.*;

public class Node {

    private Point point;
    private boolean obstacle;

    public Node(Point point, boolean obstacle) {
        this.point = point;
        this.obstacle = obstacle;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public boolean isObstacle() {
        return obstacle;
    }

    public void setObstacle(boolean obstacle) {
        this.obstacle = obstacle;
    }
}
