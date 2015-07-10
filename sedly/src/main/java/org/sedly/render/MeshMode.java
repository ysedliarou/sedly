package org.sedly.render;

public enum MeshMode {

    POINTS(1),

    LINES(2),

    TRIANGLES(3);

    private int vertices;

    MeshMode(int vertices) {
        this.vertices = vertices;
    }

}
