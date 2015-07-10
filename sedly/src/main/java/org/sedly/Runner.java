package org.sedly;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;
import org.lwjgl.util.glu.GLU;
import org.sedly.render.Mesh;
import org.sedly.render.SimpleMesh;
import org.sedly.shader.Shader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.sedly.Config.*;

public class Runner {

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

    private static void loop() throws IOException {
        GL11.glTranslatef(0, 0, -10);

        Mesh mesh = new SimpleMesh(VERTICES, INDICES);

        Shader shader = new Shader();
        shader.addFragmentShader(new String(Files.readAllBytes(Paths.get(Config.FRAGMENT_SHADER))));
//        shader.addVertexShader(new String(Files.readAllBytes(Paths.get(Config.VERTEX_SHADER))));
        shader.compile();


        float angle = 45f;
        while (isRunning()) {
            GL11.glPushMatrix();
                GL11.glRotatef(angle, 1, 1, 1);

                shader.bind();
                mesh.draw();

            GL11.glPopMatrix();
            angle += 0.1f;
            updateDisplay();
        }

        mesh.clear();
    }

    private static void cleanUp() {
        Display.destroy();
    }

    public static void main(String[] args) throws LWJGLException, IOException {
        initDisplay();
        loop();
        cleanUp();
    }


}
