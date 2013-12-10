package org.sedly.math;

import java.text.MessageFormat;

public class Vector3d {

    public final static Vector3d ZERO = new Vector3d(0, 0, 0);

    public final static Vector3d UNIT = new Vector3d(1, 1, 1);

    public final static Vector3d UNIT_X = new Vector3d(1, 0, 0);
    public final static Vector3d UNIT_Y = new Vector3d(0, 1, 0);
    public final static Vector3d UNIT_Z = new Vector3d(0, 0, 1);

    private final double x, y, z;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public Vector3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3d(Vector3d v) {
        this(v.x, v.y, v.z);
    }

    public static Vector3d add(Vector3d v1, Vector3d v2) {
        return new Vector3d(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
    }

    public Vector3d add(Vector3d v) {
        return add(this, v);
    }

    public static Vector3d sub(Vector3d v1, Vector3d v2) {
        return new Vector3d(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z);
    }

    public Vector3d sub(Vector3d v) {
        return sub(this, v);
    }

    public static Vector3d mul(Vector3d v, double a) {
        return new Vector3d(v.x * a, v.y * a,v.z * a);
    }

    public Vector3d mul(double a) {
        return mul(this, a);
    }

    public static Vector3d div(Vector3d v, double a) {
        return new Vector3d(v.x / a, v.y / a, v.z / a);
    }

    public Vector3d div(double a) {
        return mul(this, a);
    }

    public double lengthSquared() {
        return x * x + y * y;
    }

    public double length() {
        return Math.sqrt(lengthSquared());
    }

    public static double dot(Vector3d v1, Vector3d v2) {
        return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
    }

    public double dot(Vector3d v) {
        return dot(this, v);
    }

    public static Vector3d cross(Vector3d v1, Vector3d v2) {
        double x = v1.y * v2.z - v1.z * v2.y;
        double y = v1.z * v2.x - v1.x * v2.z;
        double z = v1.x * v2.y - v1.y * v2.x;
        return new Vector3d(x, y, z);
    }

    public Vector3d cross(Vector3d v) {
        return cross(this, v);
    }

    public Vector3d normal() {
        return div(this, length());
    }

    @Override
    public String toString() {
        return MessageFormat.format("Vector3d[x={0},y={1},z={2}]", x, y, z);
    }
}
