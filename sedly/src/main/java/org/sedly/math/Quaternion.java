package org.sedly.math;

public class Quaternion {

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

    // --------------- CONSTRUCTORS ---------------

    public Quaternion(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Quaternion(Vector3f axis, float angle) {
        float sinHalfAngle = (float) Math.sin(angle / 2);
        float cosHalfAngle = (float) Math.cos(angle / 2);

        this.x = axis.getX() * sinHalfAngle;
        this.y = axis.getY() * sinHalfAngle;
        this.z = axis.getZ() * sinHalfAngle;
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

    public Quaternion mul(float r) {
        return new Quaternion(x * r, y * r, z * r, w * r);
    }

    public static Quaternion mul(Quaternion q1, Quaternion q2) {
        float w = q1.w * q1.w - q1.x * q2.x - q1.y * q2.y - q1.z * q2.z;
        float x = q1.x * q1.w + q1.w * q2.x + q1.y * q2.z - q1.z * q2.y;
        float y = q1.y * q1.w + q1.w * q2.y + q1.z * q2.x - q1.x * q2.z;
        float z = q1.z * q1.w + q1.w * q2.z + q1.x * q2.y - q1.y * q2.x;

        return new Quaternion(x, y, z, w);
    }

    public Quaternion mul(Quaternion q) {
        return mul(this, q);
    }

    public static Quaternion mul(Quaternion q, Vector3f v) {
        float w = -q.x * v.getX() - q.y * v.getY() - q.z * v.getZ();
        float x = q.w * v.getX() + q.y * v.getZ() - q.z * v.getY();
        float y = q.w * v.getY() + q.z * v.getX() - q.x * v.getZ();
        float z = q.w * v.getZ() + q.x * v.getY() - q.y * v.getX();

        return new Quaternion(x, y, z, w);
    }

    public Quaternion mul(Vector3f v) {
        return mul(this, v);
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

}
