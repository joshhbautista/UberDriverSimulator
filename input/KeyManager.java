package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    private boolean[] keys;
    private boolean isUpPressed, isDownPressed, isLeftPressed, isRightPressed;

    public KeyManager() {
        // An array representing all keys on the keyboard
        keys = new boolean[256];

        isUpPressed = false;
        isDownPressed = false;
        isLeftPressed = false;
        isRightPressed = false;
    }

    public void update() {
        isUpPressed = keys[KeyEvent.VK_W];
        isDownPressed = keys[KeyEvent.VK_S];
        isLeftPressed = keys[KeyEvent.VK_A];
        isRightPressed = keys[KeyEvent.VK_D];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;

    }

    public boolean getIsUpPressed() {
        return isUpPressed;
        // TODO should it be named getIsUpPressed or isUpPressed?
    }

    public boolean getIsDownPressed() {
        return isDownPressed;
    }

    public boolean getIsLeftPressed() {
        return isLeftPressed;
    }

    public boolean getIsRightPressed() {
        return isRightPressed;
    }
}