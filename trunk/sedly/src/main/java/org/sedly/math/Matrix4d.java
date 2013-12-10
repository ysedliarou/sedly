package org.sedly.math;

public class Matrix4d {

    private static abstract class Operation {

        private double[][] source, target;

        protected double[][] getSource() {
            return source;
        }

        protected double[][] getTarget() {
            return target;
        }

        Operation(double[][] source, double[][] target) {
            this.source = source;
            this.target = target;
        }

        abstract double operate(int i, int j);
    }

    public final static int SIZE = 4;

    public static Matrix4d IDENTITY = new Matrix4d(new double[][] {
                {1,         0,          0,          0},
                {0,         1,          0,          0},
                {0,         0,          1,          0},
                {0,         0,          0,          1}
    });

    private double matrix[][] = new double[SIZE][SIZE];

    public double[][] getMatrix() {
        return copy(new Operation(matrix, null) {
            @Override
            double operate(int i, int j) {
                return getSource()[i][j];
            }
        });
    }

    public double get(int i, int j) {
        return matrix[i][j];
    }

    public Matrix4d(double[][] matrix) {
        this(new Operation(matrix, null) {
            @Override
            double operate(int i, int j) {
                return getSource()[i][j];
            }
        });
    }

    private Matrix4d(Operation operation) {
        this.matrix = copy(operation);
    }

    private static double[][] copy(Operation operation) {
        double[][] target = new double[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                target[i][j] = operation.operate(i, j);
            }
        }
        return target;
    }

    public Matrix4d copy() {
        return new Matrix4d(matrix);
    }

    public static Matrix4d mul(Matrix4d m, final double a) {
        return new Matrix4d(new Operation(m.matrix, null) {
            @Override
            double operate(int i, int j) {
                return getSource()[i][j] * a;
            }
        });
    }

    public Matrix4d mul(final double a) {
        return mul(this, a);
    }

    public static Matrix4d div(Matrix4d m, final double a) {
        return new Matrix4d(new Operation(m.matrix, null) {
            @Override
            double operate(int i, int j) {
                return getSource()[i][j] / a;
            }
        });
    }

    public Matrix4d div(final double a) {
        return div(this, a);
    }

    public static Matrix4d add(Matrix4d m1, Matrix4d m2) {
        return new Matrix4d(new Operation(m1.matrix, m2.matrix) {
            @Override
            double operate(int i, int j) {
                return getSource()[i][j] + getTarget()[i][j];
            }
        });
    }

    public Matrix4d add(final Matrix4d m) {
        return add(this, m);
    }

    public static Matrix4d sub(Matrix4d m1, Matrix4d m2) {
        return new Matrix4d(new Operation(m1.matrix, m2.matrix) {
            @Override
            double operate(int i, int j) {
                return getSource()[i][j] - getTarget()[i][j];
            }
        });
    }

    public Matrix4d sub(final Matrix4d m) {
        return sub(this, m);
    }

    public Matrix4d mul(Matrix4d m) {
        return new Matrix4d(new Operation(matrix, m.matrix) {
            @Override
            double operate(int i, int j) {
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
