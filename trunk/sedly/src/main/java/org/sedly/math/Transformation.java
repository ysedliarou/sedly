package org.sedly.math;

public class Transformation {

    private Vector3d translation;

    private Vector3d scale;

    public static Matrix4d translation(Vector3d v) {
        return new Matrix4d(new double[][] {
                {1,         0,          0,          v.getX()},
                {0,         1,          0,          v.getY()},
                {0,         0,          1,          v.getZ()},
                {0,         0,          0,          1}
        });
    }

    public Matrix4d translation() {
        return translation(translation);
    }

    public static Matrix4d scale(Vector3d v) {
        return new Matrix4d(new double[][] {
                {v.getX(),  0,          0,          0},
                {0,         v.getY(),   0,          0},
                {0,         0,          v.getZ(),   0},
                {0,         0,          0,          1}
        });
    }

    public Matrix4d scale() {
        return scale(scale);
    }

    public static Matrix4d rotationX(double alpha) {
        final double cos = Math.cos(alpha), sin = Math.sin(alpha);
        return new Matrix4d(new double[][] {
                {1,         0,          0,          0},
                {0,         cos,        -sin,       0},
                {0,         sin,        cos,        0},
                {0,         0,          0,          1}
        });
    }

    public static Matrix4d rotationY(double beta) {
        final double cos = Math.cos(beta), sin = Math.sin(beta);
        return new Matrix4d(new double[][] {
                {cos,       0,          sin,        0},
                {0,         1,          0,          0},
                {-sin,      0,          cos,        0},
                {0,         0,          0,          1}
        });
    }

    public static Matrix4d rotationZ(double gamma) {
        final double cos = Math.cos(gamma), sin = Math.sin(gamma);
        return new Matrix4d(new double[][] {
                {cos,       -sin,       0,          0},
                {sin,       cos,        0,          0},
                {0,         0,          1,          0},
                {0,         0,          0,          1}
        });
    }

}
