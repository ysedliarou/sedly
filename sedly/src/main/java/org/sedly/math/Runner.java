package org.sedly.math;


import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Runner {

    private final static int WIDTH = 800;
    private final static int HEIGHT = 600;

    private boolean running = false;


    public static void main(String[] args) throws Exception {

        Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
        Display.create();

        while (!Display.isCloseRequested()) {
            Display.update();
        }

        Display.destroy();
    }

}