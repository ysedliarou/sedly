package org.sedly.render;

import org.sedly.math.Vector3f;

public class Vertex {

    // --------------- PROPERTIES ---------------

    private Vector3f position;

    // --------------- GETTERS ---------------

    public Vector3f getPosition() {
        return position;
    }

    // --------------- CONSTRUCTORS ---------------

    public Vertex(Vector3f position) {
        this.position = position;
    }

}
