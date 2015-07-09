package org.sedly.render;

import java.util.List;

public abstract class Mesh {

    private List<Vertex> vertices;

    public List<Vertex> getVertices() {
        return vertices;
    }

    protected Mesh(List<Vertex> vertices) {
        this.vertices = vertices;
    }

}
