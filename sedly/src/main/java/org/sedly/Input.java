package org.sedly;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.sedly.math.Vector3f;

public class Input {
    public static final int NUM_KEYCODES = 256;
    public static final int NUM_MOUSEBUTTONS = 5;

    private static boolean[] lastBoardKeys = new boolean[NUM_KEYCODES];
    private static boolean[] lastMouseKeys = new boolean[NUM_MOUSEBUTTONS];

    public static void update() {
        for(int i = 0; i < NUM_KEYCODES; i++) {
            lastBoardKeys[i] = getKey(i);
        }

        for(int i = 0; i < NUM_MOUSEBUTTONS; i++) {
            lastMouseKeys[i] = getMouse(i);
        }
    }

    public static boolean getKey(int keyCode)
    {
        return Keyboard.isKeyDown(keyCode);
    }

    public static boolean getKeyDown(int keyCode)
    {
        return getKey(keyCode) && !lastBoardKeys[keyCode];
    }

    public static boolean getKeyUp(int keyCode)
    {
        return !getKey(keyCode) && lastBoardKeys[keyCode];
    }

    public static boolean getMouse(int mouseButton)
    {
        return Mouse.isButtonDown(mouseButton);
    }

    public static boolean getMouseDown(int mouseButton)
    {
        return getMouse(mouseButton) && !lastMouseKeys[mouseButton];
    }

    public static boolean getMouseUp(int mouseButton)
    {
        return !getMouse(mouseButton) && lastMouseKeys[mouseButton];
    }

    public static Vector3f getMousePosition()
    {
        return new Vector3f(Mouse.getX(), Mouse.getY(), 0);
    }

    public static void setMousePosition(Vector3f pos)
    {
        Mouse.setCursorPosition((int)pos.getX(), (int)pos.getY());
    }

    public static void setCursor(boolean enabled)
    {
        Mouse.setGrabbed(!enabled);
    }
}
