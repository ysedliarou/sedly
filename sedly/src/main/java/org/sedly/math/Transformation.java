package org.sedly.math;

public class Transformation {

    // --------------- PROPERTIES ---------------

    private Vector3f translation = Vector3f.ZERO;

    private Vector3f scale = Vector3f.UNIT;

    private Quaternion rotation = Quaternion.UNIT;

    // --------------- GETTERS ---------------

    public Vector3f getTranslation() {
        return translation;
    }

    public Vector3f getScale() {
        return scale;
    }

    public Quaternion getRotation() {
        return rotation;
    }

    // --------------- CONSTRUCTORS ---------------

    // --------------- METHODS ---------------

    public static Matrix4f translation(Vector3f v) {
        return new Matrix4f(new float[][] {
                {1,         0,          0,          v.getX()},
                {0,         1,          0,          v.getY()},
                {0,         0,          1,          v.getZ()},
                {0,         0,          0,          1}
        });
    }

    public static Matrix4f scale(Vector3f v) {
        return new Matrix4f(new float[][] {
                {v.getX(),  0,          0,          0},
                {0,         v.getY(),   0,          0},
                {0,         0,          v.getZ(),   0},
                {0,         0,          0,          1}
        });
    }

    public static Matrix4f rotationX(float angle) {
        final float cos = (float) Math.cos(angle), sin = (float) Math.sin(angle);
        return new Matrix4f(new float[][] {
                {1,         0,          0,          0},
                {0,         cos,        -sin,       0},
                {0,         sin,        cos,        0},
                {0,         0,          0,          1}
        });
    }

    public static Matrix4f rotationY(float angle) {
        final float cos = (float) Math.cos(angle), sin = (float) Math.sin(angle);
        return new Matrix4f(new float[][] {
                {cos,       0,          sin,        0},
                {0,         1,          0,          0},
                {-sin,      0,          cos,        0},
                {0,         0,          0,          1}
        });
    }

    public static Matrix4f rotationZ(float angle) {
        final float cos = (float) Math.cos(angle), sin = (float) Math.sin(angle);
        return new Matrix4f(new float[][] {
                {cos,       -sin,       0,          0},
                {sin,       cos,        0,          0},
                {0,         0,          1,          0},
                {0,         0,          0,          1}
        });
    }

    public static Matrix4f rotationXYZ(float alpha, float beta, float gamma) {
        return rotationZ(alpha).mul(rotationX(beta)).mul(rotationZ(gamma));
    }

    public static Matrix4f rotation(Vector3f axis, float angle) {
        final float cos = (float) Math.cos(angle), sin = (float) Math.sin(angle);
        return new Matrix4f(new float[][] {
                {cos + (1-cos) * axis.getX() * axis.getX(),                 (1 - cos) * axis.getX() * axis.getY() - sin * axis.getZ(),  (1-cos) * axis.getX() * axis.getY() + sin * axis.getY(),    0},
                {(1-cos) * axis.getY() * axis.getX() + sin * axis.getZ(),   cos + (1-cos) * axis.getY() * axis.getY(),                  (1-cos) * axis.getY() * axis.getZ() + sin * axis.getX(),    0},
                {(1-cos) * axis.getX() * axis.getZ() - sin * axis.getY(),   (1-cos) * axis.getZ() * axis.getY() + sin * axis.getX(),    cos + (1-cos) * axis.getZ() * axis.getZ(),                  0},
                {0,                                                         0,                                                          0,                                                          1}
        });
    }


    public static Matrix4f rotation(Quaternion q) {
        return new Matrix4f(new float[][] {
                {1-2*q.getY()*q.getY()-2*q.getZ()*q.getZ(),     2*q.getX()*q.getY()-2*q.getZ()*q.getW(),        2*q.getX()*q.getZ()+2*q.getY()*q.getW(),            0},
                {2*q.getX()*q.getY()+2*q.getZ()*q.getW(),       1-2*q.getX()*q.getX()-2*q.getZ()*q.getZ(),      2*q.getY()*q.getZ()+2*q.getX()*q.getW(),            0},
                {2*q.getX()*q.getZ()+2*q.getY()*q.getW(),       2*q.getY()*q.getZ()+2*q.getX()*q.getW(),        1-2*q.getX()*q.getX()-2*q.getY()*q.getY(),          0},
                {0,                                             0,                                              0,                                                  1}
        });
    }


    public static void main(String[] args) {
        System.out.println(Vector3f.UNIT_Z.rotate(new Quaternion(1,0,0,0)));
    }

}
