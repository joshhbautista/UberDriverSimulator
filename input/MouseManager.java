package input;

import java.awt.event.*;
import main.*;

public class MouseManager implements MouseListener, MouseMotionListener {

    private boolean leftPressed, rightPressed;
    private int mouseX, mouseY;

    public MouseManager() {
    }

    /**
     * @return the leftPressed
     */
    public boolean isLeftPressed() {
        return leftPressed;
    }

    /**
     * @return the rightPressed
     */
    public boolean isRightPressed() {
        return rightPressed;
    }

    /**
     * @return the mouseX
     */
    public int getMouseX() {
        return mouseX;
    }

    /**
     * @return the mouseY
     */
    public int getMouseY() {
        return mouseY;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            leftPressed = true;
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            rightPressed = true;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            leftPressed = false;
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            rightPressed = false;
        }

    }
    
    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub

    }

   


}