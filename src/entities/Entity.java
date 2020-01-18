package entities;

import java.awt.Graphics;

import main.Hud;

/**
 * The <code>Entity</code> class represents an entity in game.
 * All <code>Entity</code> objects in the game will have an
 * x-position, y-position, width, and height. All entities will
 * also have an update and render method that will continuously
 * update itself and draw/render itself to the screen.
 * 
 * @author Joshua Bautista
 * @version 1/14/2020
 */
public abstract class Entity {

    /**
     * A float representing the x-position of the <code>Entity</code>.
     */
    private float xPos;
    /**
     * A float representing the y-position of the <code>Entity</code>.
     */
    private float yPos;
    /**
     * An int representing the width of the <code>Entity</code>.
     */
    private int width;
    /**
     * An int representing the height of the <code>Entity</code>.
     */
    private int height;

    /**
     * Creates a new <code>Entity</code> with the specified x-position,
     * y-position, width, and height.
     * 
     * @param xPos the x-position of the entity
     * @param yPos the y-position of the entity
     * @param width the width of the entity
     * @param height the height of the entity
     */
    public Entity(float xPos, float yPos, int width, int height) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
    }

    /**
     * Returns the <code>xPos</code> property of this entity.
     * 
     * @return a float representing the x-position
     */
    public float getXPos() {
        return xPos;
    }

    /**
     * Sets the x-position of this entity.
     * 
     * @param xPos the x-position 
     */
    public void setXPos(float xPos) {
        this.xPos = xPos;
    }

    /**
     * Returns the <code>yPos</code> property of this entity.
     * 
     * @return a float representing the y-position
     */
    public float getYPos() {
        return yPos;
    }

    /**
     * Sets the y-position of this entity.
     * 
     * @param yPos the y-position
     */
    public void setYPos(float yPos) {
        this.yPos = yPos;
    }

    /**
     * Returns the <code>width</code> property of this entity.
     * 
     * @return an int representing the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets the width of this entity.
     * 
     * @param width the width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Returns the <code>height</code> property of this entity.
     * 
     * @return an int representing the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets the height of this entity.
     * 
     * @param height the height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * This method is called every frame. It is used
     * to update/check for all game changes relating to
     * the entity.
     * 
     * @param hud the <code>Hud</code> object to be 
     * communicated with
     */
    public abstract void update(Hud hud);
    
    /**
     * This method is called every frame. It is used to
     * render/draw all images/objects relating to the 
     * entity.
     * 
     * @param graphics the <code>Graphics</code> object 
     * to be drawn to
     */
    public abstract void render(Graphics graphics);
}