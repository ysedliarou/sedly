package org.sedly.math;

public class Transformation {

    private Vector3f translation = Vector3f.ZERO;

    private Vector3f scale = Vector3f.UNIT;

    public Vector3f getTranslation() {
        return translation;
    }

    public Vector3f getScale() {
        return scale;
    }

    public static Matrix4f translation(Vector3f v) {
        return new Matrix4f(new float[][] {
                {1,         0,          0,          v.getX()},
                {0,         1,          0,          v.getY()},
                {0,         0,          1,          v.getZ()},
                {0,         0,          0,          1}
        });
    }

    public Matrix4f translation() {
        return translation(translation);
    }

    public static Matrix4f scale(Vector3f v) {
        return new Matrix4f(new float[][] {
                {v.getX(),  0,          0,          0},
                {0,         v.getY(),   0,          0},
                {0,         0,          v.getZ(),   0},
                {0,         0,          0,          1}
        });
    }

    public Matrix4f scale() {
        return scale(scale);
    }

    public static Matrix4f rotationX(float alpha) {
        final float cos = (float) Math.cos(alpha), sin = (float) Math.sin(alpha);
        return new Matrix4f(new float[][] {
                {1,         0,          0,          0},
                {0,         cos,        -sin,       0},
                {0,         sin,        cos,        0},
                {0,         0,          0,          1}
        });
    }

    public static Matrix4f rotationY(float beta) {
        final float cos = (float) Math.cos(beta), sin = (float) Math.sin(beta);
        return new Matrix4f(new float[][] {
                {cos,       0,          sin,        0},
                {0,         1,          0,          0},
                {-sin,      0,          cos,        0},
                {0,         0,          0,          1}
        });
    }

    public static Matrix4f rotationZ(float gamma) {
        final float cos = (float) Math.cos(gamma), sin = (float) Math.sin(gamma);
        return new Matrix4f(new float[][] {
                {cos,       -sin,       0,          0},
                {sin,       cos,        0,          0},
                {0,         0,          1,          0},
                {0,         0,          0,          1}
        });
    }

    public static Matrix4f rotationXYZ(float theta) {
        return rotationZ(theta).mul(rotationY(theta).mul(rotationX(theta)));
    }

}
