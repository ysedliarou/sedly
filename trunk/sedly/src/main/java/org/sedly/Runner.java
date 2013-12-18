package org.sedly;

import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;
import org.lwjgl.util.glu.GLU;
import org.sedly.math.Vector3f;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    private final static Vector3f FRONT = new Vector3f(1, 0, 0);
    private final static Vector3f LEFT = new Vector3f(0, 1, 0);
    private final static Vector3f RIGHT = new Vector3f(0, 0, 1);
    private final static Vector3f BACK = new Vector3f(1, 1, 0);
    private final static Vector3f TOP = new Vector3f(0, 1, 1);
    private final static Vector3f BOTTOM = new Vector3f(1, 0, 1);

    private final static Vector3f LEFT_BOTTOM_FRONT = new Vector3f(-1, -2, 1);
    private final static Vector3f LEFT_BOTTOM_BACK = new Vector3f(-1, -2, -1);

    private final static Vector3f LEFT_TOP_FRONT = new Vector3f(-1, 2, 1);
    private final static Vector3f LEFT_TOP_BACK = new Vector3f(-1, 2, -1);

    private final static Vector3f RIGHT_BOTTOM_FRONT = new Vector3f(1, -2, 1);
    private final static Vector3f RIGHT_BOTTOM_BACK = new Vector3f(1, -2, -1);

    private final static Vector3f RIGHT_TOP_FRONT = new Vector3f(1, 2, 1);
    private final static Vector3f RIGHT_TOP_BACK = new Vector3f(1, 2, -1);

    private static Vector3f[] VERTICES = new Vector3f[] {
            LEFT_BOTTOM_FRONT, LEFT_BOTTOM_BACK,
            LEFT_TOP_FRONT, LEFT_TOP_BACK,
            RIGHT_BOTTOM_FRONT, RIGHT_BOTTOM_BACK,
            RIGHT_TOP_FRONT, RIGHT_TOP_BACK
    };

    private final static Vector3f[] COLORS = new Vector3f[] {
            LEFT, RIGHT, TOP, BOTTOM, FRONT, BACK
    };

    private static int[] INDICES = new int[] {
            0,2,6,4,
            0,1,3,2,
            4,5,7,6,
            1,3,7,5,
            2,3,7,6,
            0,1,5,4
    };

    private final static FloatBuffer VERTICES_BUFFER = BufferUtils.createFloatBuffer(VERTICES.length * 3);

    private final static IntBuffer INDICES_BUFFER = BufferUtils.createIntBuffer(INDICES.length);

    private final static FloatBuffer COLORS_BUFFER = BufferUtils.createFloatBuffer(COLORS.length * 3);

    static {
        for (Vector3f vertex :VERTICES) {
            VERTICES_BUFFER.put(vertex.getX());
            VERTICES_BUFFER.put(vertex.getY());
            VERTICES_BUFFER.put(vertex.getZ());
        }
        VERTICES_BUFFER.flip();

        INDICES_BUFFER.put(INDICES);
        INDICES_BUFFER.flip();

        for (Vector3f color :COLORS) {
            COLORS_BUFFER.put(color.getX());
            COLORS_BUFFER.put(color.getY());
            COLORS_BUFFER.put(color.getZ());
        }
        COLORS_BUFFER.flip();
    }

    private final static int WIDTH = 800;
    private final static int HEIGHT = 800;

    private static void initDisplay() throws LWJGLException {
        Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
        Display.setVSyncEnabled(true);
        Display.create();

        initGraphics();
    }

    private static void initGraphics() {
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GLU.gluPerspective(70, WIDTH / HEIGHT, 0.3f, 1000);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();

        GL11.glEnable(GL11.GL_DEPTH_TEST);
    }

    private static void updateDisplay() {
        Display.update();
        Display.sync(60);
    }

    private static boolean isRunning() {
        return !Display.isCloseRequested();
    }

    private static void loop() {
        GL11.glTranslatef(0, 0, -10);

        int vbo = GL15.glGenBuffers();
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo);
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, VERTICES_BUFFER, GL15.GL_STATIC_DRAW);

        int ibo = GL15.glGenBuffers();
        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, ibo);
        GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, INDICES_BUFFER, GL15.GL_STATIC_DRAW);

        int cbo = GL15.glGenBuffers();
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, cbo);
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, COLORS_BUFFER, GL15.GL_STATIC_DRAW);

        float angle = 45f;
        while (isRunning()) {
            GL11.glPushMatrix();
                GL11.glRotatef(angle, 1, 1, 1);
                draw(vbo, ibo, cbo);
            GL11.glPopMatrix();
            angle += 0.1f;
            updateDisplay();
        }

        GL15.glDeleteBuffers(vbo);
        GL15.glDeleteBuffers(cbo);
        GL15.glDeleteBuffers(ibo);
    }

    private static void draw(int vbo, int ibo, int cbo) {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        GL11.glClearColor(0, 0, 0, 0);

        drawCube(vbo, ibo, cbo);
    }

    private static void drawCube(int vbo, int ibo, int cbo) {
            GL20.glEnableVertexAttribArray(0);

            GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo);
            GL20.glVertexAttribPointer(0, 3, GL11.GL_FLOAT, false, 3 * 4, 0);  // 3 floats per vertex * 4 bytes

            GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, ibo);
            GL11.glDrawElements(GL11.GL_QUADS, INDICES.length, GL11.GL_UNSIGNED_INT, 0);

            GL20.glDisableVertexAttribArray(0);
    }

    private static void cleanUp() {
        Display.destroy();
    }

    public static void main(String[] args) throws LWJGLException {
        initDisplay();
        loop();
        cleanUp();
    }


}
