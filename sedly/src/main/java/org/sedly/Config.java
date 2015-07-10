package org.sedly;

import org.sedly.math.Vector3f;

public final class Config {

    public Config() {
        super();
    }

    public final static Vector3f FRONT = new Vector3f(1, 0, 0);
    public final static Vector3f LEFT = new Vector3f(0, 1, 0);
    public final static Vector3f RIGHT = new Vector3f(0, 0, 1);
    public final static Vector3f BACK = new Vector3f(1, 1, 0);
    public final static Vector3f TOP = new Vector3f(0, 1, 1);
    public final static Vector3f BOTTOM = new Vector3f(1, 0, 1);

    public final static Vector3f LEFT_BOTTOM_FRONT = new Vector3f(-1, -2, 1);
    public final static Vector3f LEFT_BOTTOM_BACK = new Vector3f(-1, -2, -1);

    public final static Vector3f LEFT_TOP_FRONT = new Vector3f(-1, 2, 1);
    public final static Vector3f LEFT_TOP_BACK = new Vector3f(-1, 2, -1);

    public final static Vector3f RIGHT_BOTTOM_FRONT = new Vector3f(1, -2, 1);
    public final static Vector3f RIGHT_BOTTOM_BACK = new Vector3f(1, -2, -1);

    public final static Vector3f RIGHT_TOP_FRONT = new Vector3f(1, 2, 1);
    public final static Vector3f RIGHT_TOP_BACK = new Vector3f(1, 2, -1);

    public static Vector3f[] VERTICES = new Vector3f[] {
            LEFT_BOTTOM_FRONT, LEFT_BOTTOM_BACK,
            LEFT_TOP_FRONT, LEFT_TOP_BACK,
            RIGHT_BOTTOM_FRONT, RIGHT_BOTTOM_BACK,
            RIGHT_TOP_FRONT, RIGHT_TOP_BACK
    };

    public final static Vector3f[] COLORS = new Vector3f[] {
            LEFT, RIGHT, TOP, BOTTOM, FRONT, BACK
    };

    public final static int[] INDICES = new int[] {
            0,2,6,4,
            0,1,3,2,
            4,5,7,6,
            1,3,7,5,
            2,3,7,6,
            0,1,5,4
    };

    public final static String VERTEX_SHADER = "f:\\Tools\\Demo\\sedly\\sedly\\target\\classes\\org\\sedly\\shader\\test.vertex";
    public final static String FRAGMENT_SHADER = "f:\\Tools\\Demo\\sedly\\sedly\\target\\classes\\org\\sedly\\shader\\test.fragment";

}
