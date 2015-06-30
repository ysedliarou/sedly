package org.sedly.math;

public final class MathUtil {

    private MathUtil() {
        super();
    }

    public static float clamp(float val, float min, float max) {
        return Math.max(min, Math.min(max, val));
    }

}
