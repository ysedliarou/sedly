package org.sedly.math;

import java.text.MessageFormat;

public class Vector3f {

    public final static Vector3f ZERO = new Vector3f(0, 0, 0);

    public final static Vector3f UNIT = new Vector3f(1, 1, 1);

    public final static Vector3f UNIT_X = new Vector3f(1, 0, 0);
    public final static Vector3f UNIT_Y = new Vector3f(0, 1, 0);
    public final static Vector3f UNIT_Z = new Vector3f(0, 0, 1);

    private final float x, y, z;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3f(Vector3f v) {
        this(v.x, v.y, v.z);
    }

    public static Vector3f add(Vector3f v1, Vector3f v2) {
        return new Vector3f(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
    }

    public Vector3f add(Vector3f v) {
        return add(this, v);
    }

    public static Vector3f sub(Vector3f v1, Vector3f v2) {
        return new Vector3f(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z);
    }

    public Vector3f sub(Vector3f v) {
        return sub(this, v);
    }

    public static Vector3f mul(Vector3f v, float a) {
        return new Vector3f(v.x * a, v.y * a,v.z * a);
    }

    public Vector3f mul(float a) {
        return mul(this, a);
    }

    public static Vector3f div(Vector3f v, float a) {
        return new Vector3f(v.x / a, v.y / a, v.z / a);
    }

    public Vector3f div(float a) {
        return mul(this, a);
    }

    public float lengthSquared() {
        return x * x + y * y;
    }

    public float length() {
        return (float) Math.sqrt(lengthSquared());
    }

    public static float dot(Vector3f v1, Vector3f v2) {
        return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
    }

    public float dot(Vector3f v) {
        return dot(this, v);
    }

    public static Vector3f cross(Vector3f v1, Vector3f v2) {
        float x = v1.y * v2.z - v1.z * v2.y;
        float y = v1.z * v2.x - v1.x * v2.z;
        float z = v1.x * v2.y - v1.y * v2.x;
        return new Vector3f(x, y, z);
    }

    public Vector3f cross(Vector3f v) {
        return cross(this, v);
    }

    public Vector3f normal() {
        return div(this, length());
    }

    @Override
    public String toString() {
        return MessageFormat.format("Vector3f[x={0},y={1},z={2}]", x, y, z);
    }
}
