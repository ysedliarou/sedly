package org.sedly;

import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;
import org.lwjgl.util.glu.GLU;
import org.sedly.math.Vector3f;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

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

    private final static Vector3f[] VERTICES = new Vector3f[] {
            LEFT_BOTTOM_FRONT, LEFT_BOTTOM_BACK,
            LEFT_TOP_FRONT, LEFT_TOP_BACK,
            RIGHT_BOTTOM_FRONT, RIGHT_BOTTOM_BACK,
            RIGHT_TOP_FRONT, RIGHT_TOP_BACK
    };

    private final static Vector3f[] COLORS = new Vector3f[] {
            LEFT, RIGHT, TOP, BOTTOM, FRONT, BACK
    };

    private final static int[] INDICES = new int[] {
            0,2,6,4,
            0,1,3,2,
            4,5,7,6,
            1,3,7,5,
            2,3,7,6,
            0,1,5,4
    };

    private final static FloatBuffer VERTICES_BUFFER = BufferUtils.createFloatBuffer(VERTICES.length * 3);

    private final static IntBuffer INDICES_BUFFER = BufferUtils.createIntBuffer(INDICES.length);

    static {
        for (Vector3f vertex :VERTICES) {
            VERTICES_BUFFER.put(vertex.getX());
            VERTICES_BUFFER.put(vertex.getY());
            VERTICES_BUFFER.put(vertex.getZ());
        }
        VERTICES_BUFFER.flip();

        INDICES_BUFFER.put(INDICES);
        INDICES_BUFFER.flip();
    }

    private final static int WIDTH = 800;
    private final static int HEIGHT = 800;

    private static void initDisplay() throws LWJGLException {
        Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
        Display.setVSyncEnabled(true);
        Display.sync(60);
        Display.create();
    }

    private static void updateDisplay() {
        Display.update();
    }

    private static boolean isRunning() {
        return !Display.isCloseRequested();
    }

    private static void loop() {
        float angle = 0;
        while (isRunning()) {
            draw(angle);
            updateDisplay();
            angle += 0.05;
        }
    }

    private static void draw(float angle) {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        GL11.glClearColor(0, 0, 0, 0);

        GL11.glEnable(GL11.GL_DEPTH_TEST);

        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GLU.gluPerspective(70, WIDTH / HEIGHT, 0.3f, 1000);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();

        drawCube(angle);
    }

    private static void drawCube(float angle) {

        GL11.glTranslatef(0, 0, -10);
        GL11.glRotatef(angle, 1, 1, 1);

        int vbo = GL15.glGenBuffers();
        int ibo = GL15.glGenBuffers();

        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo);
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, VERTICES_BUFFER, GL15.GL_STATIC_DRAW);

        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, ibo);
        GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, INDICES_BUFFER, GL15.GL_STATIC_DRAW);

        GL20.glEnableVertexAttribArray(0);

        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo);
        GL20.glVertexAttribPointer(0, 3, GL11.GL_FLOAT, false, 3 * 4, 0);

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
