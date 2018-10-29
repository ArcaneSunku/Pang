package arcanesunku;

import java.awt.event.*;

public class InputHandler implements KeyListener, MouseListener, MouseMotionListener {

    public static boolean[] keys;
    private static boolean[] justPressed, cantPress;
    private static boolean[] buttons = new boolean[5];

    private static int mouseX, mouseY;

    public InputHandler() {
        keys = new boolean[256];
        justPressed = new boolean[keys.length];
        cantPress = new boolean[keys.length];
    }

    public void update() {
        for (int i = 0; i < keys.length; i++) {
            if (cantPress[i] && !keys[i]) {
                cantPress[i] = false;
            } else if (justPressed[i]) {
                cantPress[i] = true;
                justPressed[i] = false;
            }

            if (!cantPress[i] && keys[i]) {
                justPressed[i] = true;
            }
        }
    }

    // GETTERS

    public static int getMouseX() {
        return mouseX;
    }

    public static int getMouseY() {
        return mouseY;
    }

    public static boolean isKeyPressed(int keyCode) {
        return keys[keyCode];
    }

    public static boolean isLeftPressed() {
        return buttons[1];
    }

    public static boolean isRightPressed() {
        return buttons[3];
    }

    public static boolean keyJustPressed(int keyCode) {
        if (keyCode <= 0 || keyCode >= keys.length)
            return false;

        return justPressed[keyCode];
    }

    // Inherited

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
            return;

        keys[e.getKeyCode()] = true;
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
            return;

        keys[e.getKeyCode()] = false;
    }

    public void keyTyped(KeyEvent e) {
    }

    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    public void mouseClicked(MouseEvent e) {
        // Might handle item pickups
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1)
            buttons[1] = true;


        if (e.getButton() == MouseEvent.BUTTON3)
            buttons[3] = true;
    }

    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1)
            buttons[1] = false;


        if (e.getButton() == MouseEvent.BUTTON3)
            buttons[3] = false;
    }


}
