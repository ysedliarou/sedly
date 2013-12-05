package org.sedly.math;

import java.text.MessageFormat;

public class Point3d {

    public final static Point3d ZERO = new Point3d(0, 0, 0);

    private final double x;

    private final double y;

    private final double z;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public Point3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point3d(Point3d v) {
        this(v.x, v.y, v.z);
    }

    public static double lengthSquared(Point3d p1, Point3d p2) {
        return (p1.x - p2.x) * (p1.x - p2.x)
                + (p1.y - p2.y) * (p1.y - p2.y)
                + (p1.z - p2.z) * (p1.z - p2.z);
    }

    public static double length(Point3d p1, Point3d p2) {
        return Math.sqrt(lengthSquared(p1, p2));
    }

    public double lengthSquared(Point3d p) {
        return lengthSquared(this, p);
    }

    public double length(Point3d p) {
        return length(this, p);
    }

    @Override
    public String toString() {
        return MessageFormat.format("Point3d[x={0},y={1},z={2}]", x, y, z);
    }
}
