package org.sedly.math;

import java.text.MessageFormat;

public class Vector {

    public static Vector ZERO = new Vector(Point.ZERO);

    public static Vector I = new Vector(1, 0, 0);
    public static Vector J = new Vector(0, 1, 0);
    public static Vector K = new Vector(0, 0, 1);

    public static Vector IJK = new Vector(1, 1, 1);

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

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector(Vector v) {
        this(v.x, v.y, v.z);
    }

    public Vector(Point v) {
        this(v.getX(), v.getY(), v.getZ());
    }

    public static Vector add(Vector v1, Vector v2) {
        return new Vector(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
    }

    public Vector add(Vector v) {
        return add(this, v);
    }

    public static Vector sub(Vector v1, Vector v2) {
        return new Vector(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z);
    }

    public Vector sub(Vector v) {
        return sub(this, v);
    }

    public static Vector mul(Vector v, double a) {
        return new Vector(v.x * a, v.y * a,v.z * a);
    }

    public Vector mul(double a) {
        return mul(this, a);
    }

    public static Vector div(Vector v, double a) {
        return new Vector(v.x / a, v.y / a, v.z / a);
    }

    public Vector div(double a) {
        return mul(this, a);
    }

    public double lengthSquared() {
        return x * x + y * y;
    }

    public double length() {
        return Math.sqrt(lengthSquared());
    }

    public static double dot(Vector v1, Vector v2) {
        return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
    }

    public double dot(Vector v) {
        return dot(this, v);
    }

    public static Vector cross(Vector v1, Vector v2) {
        double x = v1.y * v2.z - v1.z * v2.y;
        double y = v1.z * v2.x - v1.x * v2.z;
        double z = v1.x * v2.y - v1.y * v2.x;
        return new Vector(x, y, z);
    }

    public Vector cross(Vector v) {
        return cross(this, v);
    }

    public Vector normal() {
        return div(this, length());
    }

    @Override
    public String toString() {
        return MessageFormat.format("Vector[x={0},y={1},z={2}]", x, y, z);
    }
}
