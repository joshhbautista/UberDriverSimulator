package ui;

import java.awt.Graphics;

public abstract class UIObject {

    protected float x, y;
    protected int width, height;
    protected boolean isHovering = false;

    public UIObject(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }

    public abstract void update();

    public abstract void render(Graphics graphics);

    public abstract void onClick();

    /*
    public void onMouseMove(MouseEvent e) {

    }

    public void onMouseRelease(MouseEvent e) {

    }
    */

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean getisHovering() {
        return isHovering;
    }

    public void setIsHovering(boolean isHovering) {
        this.isHovering = isHovering;
    }

}