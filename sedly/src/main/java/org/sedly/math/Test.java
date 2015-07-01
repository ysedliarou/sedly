package org.sedly.math;

import static org.sedly.math.Transformation.*;

public class Test {

    public static void main(String[] args) {

        float deg = (float) Math.toRadians(90);
        Quaternion q = new Quaternion(0, 0, (float) Math.sqrt(0.5), (float) Math.sqrt(0.5));

        Matrix4f rot1 = rotationZ(deg);
        System.out.println(rot1.mult(Vector3f.UNIT_Y));

        Matrix4f rot2 = rotation(Vector3f.UNIT_Z, deg);
        System.out.println(rot2.mult(Vector3f.UNIT_Y));

        Matrix4f rot3 = rotation(q);
        System.out.println(rot3.mult(Vector3f.UNIT_Y));

        Matrix4f rot4 = rotationXYZ(0, 0, deg);
        System.out.println(rot4.mult(Vector3f.UNIT_Y));

        System.out.println(Vector3f.UNIT_Z.rotate(Vector3f.UNIT_Y, -1 * deg));

    }

}
