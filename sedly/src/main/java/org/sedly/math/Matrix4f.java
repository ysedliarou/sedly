package org.sedly.math;

public class Matrix4f {

    private static abstract class Operation {

        private float[][] source, target;

        protected float[][] getSource() {
            return source;
        }

        protected float[][] getTarget() {
            return target;
        }

        Operation(float[][] source, float[][] target) {
            this.source = source;
            this.target = target;
        }

        abstract float operate(int i, int j);
    }

    public final static int SIZE = 4;

    public static Matrix4f IDENTITY = new Matrix4f(new float[][] {
                {1,         0,          0,          0},
                {0,         1,          0,          0},
                {0,         0,          1,          0},
                {0,         0,          0,          1}
    });

    private float matrix[][] = new float[SIZE][SIZE];

    public float[][] getMatrix() {
        return copy(new Operation(matrix, null) {
            @Override
            float operate(int i, int j) {
                return getSource()[i][j];
            }
        });
    }

    public float get(int i, int j) {
        return matrix[i][j];
    }

    public Matrix4f(float[][] matrix) {
        this(new Operation(matrix, null) {
            @Override
            float operate(int i, int j) {
                return getSource()[i][j];
            }
        });
    }

    private Matrix4f(Operation operation) {
        this.matrix = copy(operation);
    }

    private static float[][] copy(Operation operation) {
        float[][] target = new float[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                target[i][j] = operation.operate(i, j);
            }
        }
        return target;
    }

    public Matrix4f copy() {
        return new Matrix4f(matrix);
    }

    public static Matrix4f mul(Matrix4f m, final float a) {
        return new Matrix4f(new Operation(m.matrix, null) {
            @Override
            float operate(int i, int j) {
                return getSource()[i][j] * a;
            }
        });
    }

    public Matrix4f mul(final float a) {
        return mul(this, a);
    }

    public static Matrix4f div(Matrix4f m, final float a) {
        return new Matrix4f(new Operation(m.matrix, null) {
            @Override
            float operate(int i, int j) {
                return getSource()[i][j] / a;
            }
        });
    }

    public Matrix4f div(final float a) {
        return div(this, a);
    }

    public static Matrix4f add(Matrix4f m1, Matrix4f m2) {
        return new Matrix4f(new Operation(m1.matrix, m2.matrix) {
            @Override
            float operate(int i, int j) {
                return getSource()[i][j] + getTarget()[i][j];
            }
        });
    }

    public Matrix4f add(final Matrix4f m) {
        return add(this, m);
    }

    public static Matrix4f sub(Matrix4f m1, Matrix4f m2) {
        return new Matrix4f(new Operation(m1.matrix, m2.matrix) {
            @Override
            float operate(int i, int j) {
                return getSource()[i][j] - getTarget()[i][j];
            }
        });
    }

    public Matrix4f sub(final Matrix4f m) {
        return sub(this, m);
    }

    public Matrix4f mul(Matrix4f m) {
        return new Matrix4f(new Operation(matrix, m.matrix) {
            @Override
            float operate(int i, int j) {
                return getSource()[i][0] * getTarget()[0][j]
                        + getSource()[i][1] * getTarget()[1][j]
                        + getSource()[i][2] * getTarget()[2][j]
                        + getSource()[i][3] * getTarget()[3][j];
            }
        });
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                result += " " + matrix[i][j] + " ";
            }
            result += "\n";
        }
        return result;
    }


}
