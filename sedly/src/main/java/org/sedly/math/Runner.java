package org.sedly.math;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Runner {

    private final static int WIDTH = 800;
    private final static int HEIGHT = 600;

    private static void initDisplay() throws LWJGLException {
        Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
        Display.create();
        Display.setVSyncEnabled(true);
    }

    private static void cleanUp() throws LWJGLException {
        Display.destroy();
    }

    private static void initGL() {
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, WIDTH, 0, HEIGHT, -1, 1);

        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glClearColor(0, 0, 0, 1);

        // disable 3d
        GL11.glDisable(GL11.GL_DEPTH_TEST);
    }

    private static void draw() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
        GL11.glColor3f(0.25f, 0.75f, 0.5f);

        GL11.glLoadIdentity();

//
//        GL11.glRotatef(45, 0, 0, 1);

        drawRectangle(10, 10, 64, 64);
    }

    private static void drawRectangle(float x, float y, float width, float height) {
        GL11.glPushMatrix(); {
            GL11.glTranslatef(x, y, 0);

            GL11.glBegin(GL11.GL_QUADS); {
                GL11.glVertex2f(0, 0);
                GL11.glVertex2f(0, height);
                GL11.glVertex2f(width, +height);
                GL11.glVertex2f(width, 0);
            } GL11.glEnd();
        } GL11.glPopMatrix();
    }

    private static void updateDisplay() {
        Display.update();
        Display.sync(60);
    }

    private static boolean isRunning() {
        return !Display.isCloseRequested();
    }

    private static void loop() {
        while (isRunning()) {
            draw();
            updateDisplay();
        }
    }

    public static void main(String[] args) throws Exception {
        initDisplay();
        initGL();
        loop();
        cleanUp();
    }

}