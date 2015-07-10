package org.sedly.render;

import org.lwjgl.BufferUtils;
import org.sedly.math.Vector3f;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;

public class SimpleMesh implements Mesh {

    private int vbo;
    private int ibo;

    private int size;

    public SimpleMesh(Vector3f[] vertices, int[] indices) {
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, createFlippedFloatBuffer(vertices), GL_STATIC_DRAW);

        ibo = glGenBuffers();
        size = indices.length;
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, createFlippedIntBuffer(indices), GL_STATIC_DRAW);

//        int cbo = glGenBuffers();
//        GL15.glBindBuffer(GL_ARRAY_BUFFER, cbo);
//        GL15.glBufferData(GL_ARRAY_BUFFER, colors, GL_STATIC_DRAW);

    }

    public void clear() {
        glDeleteBuffers(vbo);
        glDeleteBuffers(ibo);
    }

    public void draw() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        glClearColor(0, 0, 0, 0);

        glEnableVertexAttribArray(0);

        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 3 * 4, 0);  // 3 floats per vertex * 4 bytes

        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glDrawElements(GL_QUADS, size, GL_UNSIGNED_INT, 0);

        glDisableVertexAttribArray(0);
    }


    private static FloatBuffer createFlippedFloatBuffer(Vector3f[] vertices) {
        FloatBuffer buffer = BufferUtils.createFloatBuffer(vertices.length * 3);

        for (Vector3f vertex : vertices) {
            buffer.put(vertex.getX());
            buffer.put(vertex.getY());
            buffer.put(vertex.getZ());
        }

        buffer.flip();

        return buffer;
    }

    private static IntBuffer createFlippedIntBuffer(int[] indices) {
        IntBuffer buffer = BufferUtils.createIntBuffer(indices.length);

        buffer.put(indices);
        buffer.flip();

        return buffer;
    }

}
