package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;

import java.awt.Rectangle;

import graphics.Assets;
import main.Game;
import main.Hud;

/**
 * The <code>Customer</code> class represents a customer that 
 * appears in the game. A <code>Customer</code> is an <code>Entity</code>
 * that has a <em>x-position, y-position, width,</em> and <em>height.</em>
 */
public class Customer extends Entity {

    /**
     * The <code>Game</code> object to be communicated with.
     */
    private Game game;
    /**
     * The amount of money the customer is willing to pay as an int.
     */
    private int fare;
    /**
     * The fare display image as a BufferedImage. 
     */
    private BufferedImage fareDisplay;
    /**
     * The customer image as a BufferedImage.
     */
    private BufferedImage customerImage;
    /**
     * The destination the customer wants to be dropped off at as an int array.
     */
    private int[] destination;
    /**
     * A boolean telling if the customer has been picked up or not.
     */
    private boolean hasBeenPickedUp;
    /**
     * A boolean telling if the customer should be visible to the player or not.
     */
    private boolean isVisible;
    /**
     * The <code>Rectangle</code> object that represents the pick up spot bounds.
     */
    private Rectangle pickUpSpot;
    /**
     * The <code>Rectangle</code> object that represents the drop off spot bounds.
     */
    private Rectangle dropOffSpot;

    /**
     * Creates a <code>Customer</code> with the following attributes.
     * 
     * @param game the <code>Game</code> object to be communicated with
     * @param xPos the <em>x-position</em> of the customer
     * @param yPos the <em>y-position</em> of the customer
     * @param width the <em>width</em> of the customer
     * @param height the <em>height</em> of the customer
     * @param fare how much the customer will pay upon successful delivery
     * @param fareDisplay the fare display image
     * @param customerImage the customer image
     * @param destination the destination the customer wants to be dropped off at
     */
    public Customer(Game game, float xPos, float yPos, int width, int height, int fare, BufferedImage fareDisplay, BufferedImage customerImage, int[] destination) {
        super(xPos, yPos, width, height);
        this.game = game;
        this.fare = fare;
        this.fareDisplay = fareDisplay;
        this.customerImage = customerImage;
        this.destination = destination;
        isVisible = false;
        hasBeenPickedUp = false;

        pickUpSpot = new Rectangle(0, 0, 30, 30); 
        dropOffSpot = new Rectangle(0, 0, 30, 30);
    }

    @Override
    public void update(Hud hud) {

        // ------------------ If car is near customer ------------------ \\
        if (pickUpSpot.intersects(game.getGamePanel().getCar().getCollisionBounds())) {
            JOptionPane.showMessageDialog(null, "You have picked up a customer.", "Uber Driver Simulator", 1);
            game.getKeyManager().resetKeyPresses(); // Reset key presses 
            pickUpSpot.setLocation(0, 0); // Remove pick up bounds
            hasBeenPickedUp = true;
            isVisible = false;
            Assets.carDoorsSFX.play(6.0f);
        }
        // -------------------- If car is at customer destination ------------- \\
        if (dropOffSpot.intersects(game.getGamePanel().getCar().getCollisionBounds())) {
            JOptionPane.showMessageDialog(null, "You dropped off a customer!\nYou have earned $" + fare + "!", "Uber Driver Simulator", 1);
            game.getKeyManager().resetKeyPresses(); // Reset key presses
            payFare();
            game.getGamePanel().setNumOfCustomersDriven(game.getGamePanel().getNumOfCustomersDriven() + 1); // TODO do this or make a addNumOfCustomersDriven?
            hasBeenPickedUp = false;
            dropOffSpot.setLocation(0, 0); // Remove drop off bounds
            Assets.dropOffSFX.play(1);
            Assets.carDoorsSFX.play(6.0f);
        }
        // -------------------- If the customer is shown to user ----------------  \\
        if (isVisible) {
            pickUpSpot.setLocation((int) getXPos() + 6 , (int) getYPos() + 100); // Set pick up bounds
        }
        // -------------------- If the customer has been picked up ------------------ \\
        if (hasBeenPickedUp) {
            pickUpSpot.setLocation(0, 0); // Remove pick up bounds
            dropOffSpot.setLocation((int) destination[0], (int) destination[1]); // Set drop off bounds at destination
        }
    }

    @Override
    public void render(Graphics graphics) {
        if (isVisible) {
            graphics.drawImage(customerImage, (int) super.getXPos(), (int) super.getYPos(), super.getWidth(), super.getHeight(), null); // Customer
            graphics.drawImage(fareDisplay, (int) (super.getXPos() + 35), (int) (super.getYPos() - 50), 120, 65, null); // Fare display
            if (!hasBeenPickedUp) {
                graphics.drawImage(Assets.pickUpSymbol, (int) getXPos() + 6, (int) getYPos() + 100, 50, 50, null); 
            }
        }

        if (hasBeenPickedUp) {
            graphics.drawImage(Assets.dropOffSymbol, (int) destination[0] - 20, (int) destination[1] - 65, 60, 70, null); // Destination symbol
        }
    }

    /**
     * Pays the fare to the driver/player.
     */
    public void payFare() {
        game.getGamePanel().getCar().addMoneyMade(fare);
    }

    // --- SETTERS & GETTERS --- \\

    /**
     * Returns the <code>fare</code> attribute of this customer.
     * 
     * @return the <code>fare</code> property as an int
     */
    public int getFare() {
        return fare;
    }

    /**
     * Sets how much the customer is willing to pay the driver/player.
     * 
     * @param fare how much the customer is willing to pay the driver/player
     */
    public void setFare(int fare) {
        this.fare = fare;
    }

    /**
     * Sets if the customer has been picked up or not.
     * 
     * @param hasBeenPickedUp a boolean telling if the customer
     * has been picked up or not
     */
    public void setHasBeenPickedUp(boolean hasBeenPickedUp) {
        this.hasBeenPickedUp = hasBeenPickedUp;
    }

    /**
     * Sets if the customer should be visible to the player or not.
     * 
     * @param isVisible a boolean telling if the customer 
     * should be visible or not
     */
    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }
}