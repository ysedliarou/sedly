package org.sedly;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;

public class Runner {

    private static void initDisplay() throws LWJGLException {
        Display.setDisplayMode(new DisplayMode(800, 600));
        Display.setVSyncEnabled(true);
        Display.sync(60);
        Display.create();
        initGraphics();
    }

    private static void updateDisplay() {
        Display.update();
    }

    private static boolean isRunning() {
        return !Display.isCloseRequested();
    }

    private static void initGraphics() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        GL11.glClearColor(0, 0, 0, 0);
        GL11.glFrontFace(GL11.GL_CW);
        GL11.glCullFace(GL11.GL_BACK);
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL32.GL_DEPTH_CLAMP);
    }

    private static void loop() {
        while (isRunning()) {
            updateState();
            draw();
            updateDisplay();
        }
    }

    private static void draw() {

    }

    private static void updateState() {
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
