package org.sedly;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.*;
import org.lwjgl.util.glu.GLU;

public class Runner {

    private final static int WIDTH = 800;
    private final static int HEIGHT = 800;

    private static void init() throws LWJGLException {
        Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
        Display.setVSyncEnabled(true);
        Display.create();

        Keyboard.create();
        Mouse.create();

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
        while (isRunning()) {

            Input.update();

            System.out.println(Input.getKey(Keyboard.KEY_SPACE));

            updateDisplay();
        }
    }


    private static void cleanUp() {
        Display.destroy();
        Keyboard.destroy();
        Mouse.destroy();
    }

    public static void main(String[] args) throws LWJGLException {
        init();
        loop();
        cleanUp();
    }


}
