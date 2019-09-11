package org.sedly.math;

import java.text.MessageFormat;

public class Quaternion {

    // --------------- CONSTANTS ---------------

    public final static Quaternion UNIT = new Quaternion(0, 0, 0, 1);

    // --------------- PROPERTIES ---------------

    private float x, y, z, w;

    // --------------- GETTERS ---------------

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public float getW() {
        return w;
    }

    public Vector3f getDirection() {
        return new Vector3f(x, y, z);
    }

    // --------------- CONSTRUCTORS ---------------

    private Quaternion(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Quaternion(Vector3f axis, float angle) {
        Vector3f normal = axis.normalize();
        float sinHalfAngle = (float) Math.sin(angle / 2);
        float cosHalfAngle = (float) Math.cos(angle / 2);

        this.x = normal.getX() * sinHalfAngle;
        this.y = normal.getY() * sinHalfAngle;
        this.z = normal.getZ() * sinHalfAngle;
        this.w = cosHalfAngle;
    }

    // --------------- METHODS ---------------

    public float length() {
        return (float) Math.sqrt(x * x + y * y + z * z + w * w);
    }

    public Quaternion normalize() {
        float length = length();
        return new Quaternion(x / length, y / length, z / length, w / length);
    }

    public Quaternion conjugate() {
        return new Quaternion(-x, -y, -z, w);
    }

    public static float dot(Quaternion q1, Quaternion q2) {
        return q1.x * q2.x + q1.y * q2.y + q1.z * q2.z + q1.w * q2.w;
    }

    public float dot(Quaternion q) {
        return dot(this, q);
    }

    public Quaternion mult(float r) {
        return new Quaternion(x * r, y * r, z * r, w * r);
    }

    public static Quaternion mult(Quaternion q1, Quaternion q2) {
        float x = q1.x * q2.w + q1.y * q2.z - q1.z * q2.y + q1.w * q2.x;
        float y = -q1.x * q2.z + q1.y * q2.w + q1.z * q2.x + q1.w * q2.y;
        float z = q1.x * q2.y - q1.y * q2.x + q1.z * q2.w + q1.w * q2.z;
        float w = -q1.x * q2.x - q1.y * q2.y - q1.z * q2.z + q1.w * q2.w;

        return new Quaternion(x, y, z, w);
    }

    public Quaternion mult(Quaternion q) {
        return mult(this, q);
    }

    public static Quaternion mult(Quaternion q, Vector3f v) {
        float w = -q.x * v.getX() - q.y * v.getY() - q.z * v.getZ();
        float x = q.w * v.getX() + q.y * v.getZ() - q.z * v.getY();
        float y = q.w * v.getY() + q.z * v.getX() - q.x * v.getZ();
        float z = q.w * v.getZ() + q.x * v.getY() - q.y * v.getX();

        return new Quaternion(x, y, z, w);
    }

    public Quaternion mult(Vector3f v) {
        return mult(this, v);
    }

    public static Quaternion sub(Quaternion q1, Quaternion q2) {
        return new Quaternion(q1.x - q2.x, q1.y - q2.y, q1.z - q2.z, q1.w - q2.w);
    }

    public Quaternion sub(Quaternion q) {
        return sub(this, q);
    }

    public static Quaternion add(Quaternion q1, Quaternion q2) {
        return new Quaternion(q1.x + q2.x, q1.y + q2.y, q1.z + q2.z, q1.w + q2.w);
    }

    public Quaternion add(Quaternion q) {
        return add(this, q);
    }

    public Vector3f forward() {
        return Vector3f.UNIT_Z.rotate(this);
    }

    public Vector3f backward() {
        return Vector3f.UNIT_Z.negate().rotate(this);
    }

    public Vector3f up() {
        return Vector3f.UNIT_Y.rotate(this);
    }

    public Vector3f down() {
        return Vector3f.UNIT_Y.negate().rotate(this);
    }

    public Vector3f right() {
        return Vector3f.UNIT_X.rotate(this);
    }

    public Vector3f left() {
        return Vector3f.UNIT_X.negate().rotate(this);
    }

    // --------------- COMMON ---------------

    @Override
    public String toString() {
        return MessageFormat.format("Quaternion[x={0},y={1},z={2},w={3}]", x, y, z, w);
    }

}
