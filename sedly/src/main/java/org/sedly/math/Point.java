package org.sedly.math;

import java.text.MessageFormat;

public class Point {

    public final static Point ZERO = new Point(0, 0, 0);

    private double x;

    private double y;

    private double z;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point(Point v) {
        this(v.x, v.y, v.z);
    }

    public static double lengthSquared(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x)
                + (p1.y - p2.y) * (p1.y - p2.y)
                + (p1.z - p2.z) * (p1.z - p2.z);
    }

    public static double length(Point p1, Point p2) {
        return Math.sqrt(lengthSquared(p1, p2));
    }

    public double lengthSquared(Point p) {
        return lengthSquared(this, p);
    }

    public double length(Point p) {
        return length(this, p);
    }

    @Override
    public String toString() {
        return MessageFormat.format("Point[x={0},y={1},z={2}]", x, y, z);
    }
}
