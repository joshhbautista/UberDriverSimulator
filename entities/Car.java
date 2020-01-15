package entities;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;

import main.Game;
import main.Hud;

/**
 * The <code>Car</code> class represents a drivable
 * car/player. A <code>Car</code> is an <code>Entity</code>
 * that has an <em>x-position, y-position, width,</em> and <em>height</em>.
 * 
 * @author Joshua Bautista
 * @version 1/14/2020
 */
public class Car extends Entity {

    /**
     * The <code>Game</code> object to be communicated with.
     */
    private Game game;
    /**
     * How much fuel is left in the car as a double.
     */
    private double fuelLeft;
    /**
     * How much the player has made so far as an int.
     */
    private int moneyMade;
    /**
     * The car image as a BufferedImage.
     */
    private BufferedImage car;
    /**
     * The speed that the car moves on the x-axis.
     */
    private float xMove;
    /**
     * The speed that the car moves on the y-axis.
     */
    private float yMove;

    /**
     * Creates a car with the specified x-position, y-position,
     * width, and height.
     * 
     * @param game the <code>Game</code> object to be communicated with
     * @param xPos the <em>x-position</em> of the car
     * @param yPos the <em>y-position</em> of the car
     * @param width the <em>width</em> of the car
     * @param height the <em>height</em< of the car
     */
    public Car(Game game, float xPos, float yPos, int width, int height) {
        super(xPos, yPos, width, height);
        this.game = game;
        car = game.getAssets().getAudi()[0];
        xMove = 0;
        yMove = 0;

        moneyMade = 0;
        fuelLeft = 100.0;
    }

    /**
     * This method is called every frame. It is used to 
     * continuously check for updates.
     */
    @Override
    public void update(Hud hud) {

        // Car Movement \\
        getInputFromUser();
        move();
        
        // ------------------------- Hud --------------------------- \\
        hud.getMoneyMadeLabel().setText("Money Made: $" + (int) moneyMade);
        hud.getFuelLeftLabel().setText("Fuel Left: " + String.format("%.1f", fuelLeft) + " L");
        hud.getFuelLeftBar().setValue((int) fuelLeft);

        // ------- FuelLeftBar Colours ----- \\
        if (fuelLeft < 50)
            hud.getFuelLeftBar().setForeground(Color.YELLOW);
        if (fuelLeft < 20) {
           hud.getFuelLeftBar().setForeground(Color.RED); 
        }
    }

    /**
     * This method is called every frame. It is used to draw the 
     * car onto the screen according to player keyboard input.
     */
    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(car, (int) super.getXPos(), (int) super.getYPos(), super.getWidth(), super.getHeight(), null);
    }

    /**
     * Moves the car on the x and y axis.
     */
    public void move() {
        moveXPos();
        moveYPos();
    }

    /**
     * Moves the car on the x-axis.
     */
    private void moveXPos() {
        setXPos(getXPos() + xMove);
    }

    /**
     * Moves the car on the y-axis.
     */
    private void moveYPos() {
        setYPos(getYPos() + yMove);
    }

    /**
     * Retrieves the keyboard input from the player/user.
     */
    private void getInputFromUser() {
        xMove = 0;
        yMove = 0;

        if (game.getKeyManager().getIsUpPressed()) {
            car = game.getAssets().getAudi()[0];
            fuelLeft -= 0.01;
            yMove = -1.5f;
        }
        if (game.getKeyManager().getIsDownPressed()) {
            car = game.getAssets().getAudi()[2];
            fuelLeft -= 0.01;
            yMove = 1.5f;
        }
        if (game.getKeyManager().getIsLeftPressed()) {
            car = game.getAssets().getAudi()[3];
            fuelLeft -= 0.01;
            xMove = -1.5f;
        }
        if (game.getKeyManager().getIsRightPressed()) {
            car = game.getAssets().getAudi()[1];
            fuelLeft -= 0.01;
            xMove = 1.5f;
        }
    }

    // ------------------ SETTERS & GETTERS ----------------------- \\

    /**
     * Sets the speed that the car moves on the x-axis.
     * 
     * @param xMove how much the car will move on the x-axis
     */
    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    /**
     * Returns the <code>xMove</code> attribute for this car.
     * 
     * @return the <code>xMove</code> property as a float
     */
    public float getxMove() {
        return xMove;
    }

    /**
     * Sets the speed that the car moves on the y-axis.
     * 
     * @param yMove how much the car will move on the y-axis
     */
    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    /**
     * Returns the <code>yMove</code> attribute for this car.
     * 
     * @return the <code>yMove</code> property as a float
     */
    public float getyMove() {
        return yMove;
    }

    /**
     * Sets how much fuel is left in the car.
     * 
     * @param fuelLeft how much fuel is left
     */
    public void setFuelLeft(double fuelLeft) {
        this.fuelLeft = fuelLeft;
    }

    /**
     * Returns the <code>fuelLeft</code> attribute for this car.
     * 
     * @return the <code>fuelLeft</code> property as a double
     */
    public double getFuelLeft() {
        return fuelLeft;
    }

    /**
     * Adds a specified amount to the <code>moneyMade</code> attribute.
     * 
     * @param moneyMadeToBeAdded amount to be added to the
     * <code>moneyMade</code> property
     */
    public void addMoneyMade(int moneyMadeToBeAdded) {
        moneyMade += moneyMadeToBeAdded;
    }
    
    /**
     * Returns the <code>moneyMade</code> attribute for this car.
     * 
     * @return the <code>moneyMade</code> property as an int
     */
    public int getMoneyMade() {
        return moneyMade;
    }
    
    /**
     * Returns the <code>Rectangle</code> object that represents the
     * bounds of this car.
     * 
     * @return the <code>Rectangle</code> object that represents the bounds
     */
    public Rectangle getCollisionBounds() {
        return new Rectangle((int) super.getXPos() + 42, (int) super.getYPos() + 45, 15, 20);
    }
}