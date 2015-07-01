package org.sedly.math;


public class Matrix4f {

    private static abstract class Operation {

        float[][] source, target;

        Operation(float[][] source, float[][] target) {
            this.source = source;
            this.target = target;
        }

        abstract float operate(int i, int j);
    }

    // --------------- CONSTANTS ---------------

    public final static int SIZE = 4;

    public final static Matrix4f IDENTITY = new Matrix4f(new float[][] {
                {1,         0,          0,          0},
                {0,         1,          0,          0},
                {0,         0,          1,          0},
                {0,         0,          0,          1}
    });

    // --------------- PROPERTIES ---------------

    private final float matrix[][];

    // --------------- GETTERS ---------------

    public float[][] getMatrix() {
        return fill(createGetOperation(matrix));
    }

    // --------------- CONSTRUCTORS ---------------

    public Matrix4f(float[][] matrix) {
        this(createGetOperation(matrix));
    }

    private Matrix4f(Operation operation) {
        this.matrix = fill(operation);
    }

    // --------------- METHODS ---------------

    private static Operation createGetOperation(float[][] matrix) {
        return new Operation(matrix, null) {
            @Override
            float operate(int i, int j) {
                return this.source[i][j];
            }
        };
    }

    public float get(int i, int j) {
        return matrix[i][j];
    }

    private static float[][] fill(Operation operation) {
        float[][] target = new float[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                target[i][j] = operation.operate(i, j);
            }
        }
        return target;
    }

    public Matrix4f duplicate() {
        return new Matrix4f(matrix);
    }

    public static Matrix4f mult(Matrix4f m, final float a) {
        return new Matrix4f(new Operation(m.matrix, null) {
            @Override
            float operate(int i, int j) {
                return this.source[i][j] * a;
            }
        });
    }

    public Matrix4f mult(final float a) {
        return mult(this, a);
    }

    public static Matrix4f div(Matrix4f m, final float a) {
        return new Matrix4f(new Operation(m.matrix, null) {
            @Override
            float operate(int i, int j) {
                return this.source[i][j] / a;
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
                return this.source[i][j] + this.target[i][j];
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
                return this.source[i][j] - this.target[i][j];
            }
        });
    }

    public Matrix4f sub(final Matrix4f m) {
        return sub(this, m);
    }

    public Matrix4f mult(Matrix4f m) {
        return new Matrix4f(new Operation(matrix, m.matrix) {
            @Override
            float operate(int i, int j) {
                return this.source[i][0] * this.target[0][j]
                        + this.source[i][1] * this.target[1][j]
                        + this.source[i][2] * this.target[2][j]
                        + this.source[i][3] * this.target[3][j];
            }
        });
    }

    public Vector3f mult(Vector3f v) {
        float x = matrix[0][0] * v.getX() + matrix[0][1] * v.getY() + matrix[0][2] * v.getZ() + matrix[0][3];
        float y = matrix[1][0] * v.getX() + matrix[1][1] * v.getY() + matrix[1][2] * v.getZ() + matrix[1][3];
        float z = matrix[2][0] * v.getX() + matrix[2][1] * v.getY() + matrix[2][2] * v.getZ() + matrix[2][3];
        return new Vector3f(x, y, z);
    }

    public Matrix4f negate() {
        return mult(this, -1);
    }

    // --------------- COMMON ---------------

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                builder.append(" " + matrix[i][j] + " ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

}
