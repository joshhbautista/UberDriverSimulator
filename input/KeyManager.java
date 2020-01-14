package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The <code>KeyManager</code> class handles all keyboard input 
 * by the user.
 * 
 * @author Joshua Bautista
 * @version 1/14/2020
 */
public class KeyManager implements KeyListener {

    /**
     * A boolean array representing all 256 keys on the keyboard.
     */
    private boolean[] keys;
    /**
     * A boolean telling if the certain key is pressed.
     */
    private boolean isUpPressed, isDownPressed, isLeftPressed, isRightPressed;

    /**
     * Initializes the <code>keys</code> boolean array.
     */
    public KeyManager() {
        // An array representing all keys on the keyboard
        keys = new boolean[256];

        isUpPressed = false;
        isDownPressed = false;
        isLeftPressed = false;
        isRightPressed = false;
    }

    /**
     * This method is called every frame and continuously checks 
     * if a key is pressed and stores the correct boolean in the 
     * <code>keys</code> array.
     */
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

    /**
     * Resets the <code>keys</code> boolean array
     * to all false. (needed due to bug - key input
     * becomes "stuck" when JOptionPane pops up)
     */
    public void resetKeyPresses() {
        keys[KeyEvent.VK_W] = false;
        keys[KeyEvent.VK_S] = false;
        keys[KeyEvent.VK_A] = false;
        keys[KeyEvent.VK_D] = false;
    }

    /**
     * Returns the <code>isUpPressed</code> boolean.
     * 
     * @return a boolean telling if the user pressed up
     */
    public boolean getIsUpPressed() {
        return isUpPressed;
    }

    /**
     * Returns the <code>isDownPressed</code> boolean.
     * 
     * @return a boolean telling if the user pressed down
     */
    public boolean getIsDownPressed() {
        return isDownPressed;
    }

    /**
     * Returns the <code>isLeftPressed</code> boolean.
     * 
     * @return a boolean telling if the user pressed left
     */
    public boolean getIsLeftPressed() {
        return isLeftPressed;
    }

    /**
     * Returns the <code>isRightPressed</code> boolean.
     * 
     * @return a boolean telling if the user pressed right
     */
    public boolean getIsRightPressed() {
        return isRightPressed;
    }
}
