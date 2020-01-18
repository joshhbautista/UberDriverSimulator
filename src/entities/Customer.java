package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import javax.swing.JOptionPane;

import main.Game;
import main.Hud;

/**
 * The <code>Customer</code> class represents a customer that 
 * appears in the game. A <code>Customer</code> is an <code>Entity</code>
 * that has a <em>x-position, y-position, width,</em> and <em>height.</em>
 * 
 * @author Joshua Bautista
 * @version 1/14/2020
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
     * The customer's name
     */
    private String name;
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
     * A boolean telling if the customer has been dropped off by the player.
     */
    private boolean hasBeenDroppedOff;

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
    public Customer(Game game, String name, float xPos, float yPos, int width, int height, int fare, BufferedImage fareDisplay, BufferedImage customerImage, int[] destination) {
        super(xPos, yPos, width, height);
        this.game = game;
        this.name = name;
        this.fare = fare;
        this.fareDisplay = fareDisplay;
        this.customerImage = customerImage;
        this.destination = destination;
        isVisible = false;
        hasBeenPickedUp = false;
        hasBeenDroppedOff = false;

        pickUpSpot = new Rectangle(0, 0, 30, 30);
        dropOffSpot = new Rectangle(0, 0, 30, 30);
    }

    /**
     * This method is called every frame and takes care of all 
     * the game updates.
     * 
     * @param hud the <code>Hud</code> object to be communicated with
     */
    @Override
    public void update(Hud hud) {
        // ------------------ If car is on customer pickup symbol ------------------ \\
        if (pickUpSpot.intersects(game.getGamePanel().getCar().getCollisionBounds())) {
            pickedUp();
        }
        // -------------------- If car is at customer destination ------------- \\
        if (dropOffSpot.intersects(game.getGamePanel().getCar().getCollisionBounds())) {
            droppedOff();
            payFare();
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

    /**
     * This method is called every frame and draws
     * all of the customer images to the screen.
     * 
     * @param graphics the <code>Graphics</code> object from the
     * <code>GamePanel</code> JPanel to be drawn on
     */
    @Override
    public void render(Graphics graphics) {
        if (isVisible) {
            graphics.drawImage(customerImage, (int) super.getXPos(), (int) super.getYPos(), super.getWidth(), super.getHeight(), null); // Customer
            graphics.drawImage(fareDisplay, (int) (super.getXPos() + 35), (int) (super.getYPos() - 50), 120, 65, null); // Fare display
            if (!hasBeenPickedUp) {
                graphics.drawImage(game.getAssets().getPickUpSymbol(), (int) getXPos() + 6, (int) getYPos() + 100, 50, 50, null); // Pick up symbol
            }
        }

        if (hasBeenPickedUp) {
            graphics.drawImage(game.getAssets().getDropOffSymbol(), (int) destination[0] - 20, (int) destination[1] - 65, 60, 70, null); // Destination symbol
        }
    }

    /**
     * Simulates the customer getting picked up by the player.
     */
    private void pickedUp() {
        JOptionPane.showMessageDialog(null, name + " has been picked up!", "Uber Driver Simulator", 1);
        game.getKeyManager().resetKeyPresses(); // Reset key presses 
        pickUpSpot.setLocation(0, 0); // Remove pick up bounds
        hasBeenPickedUp = true;
        isVisible = false;
        game.getAssets().getCarDoorsSFX().play(6.0f);
    }

    /**
     * Simulates getting dropped off by the player.
     */
    private void droppedOff() {
        JOptionPane.showMessageDialog(null, name + " has been dropped off!\n\nThey have paid you $" + fare + "!", "Uber Driver Simulator", 1);
        game.getKeyManager().resetKeyPresses(); // Reset key presses
        game.getGamePanel().addNumOfCustomersDriven(1); 
        hasBeenPickedUp = false;
        hasBeenDroppedOff = true;
        dropOffSpot.setLocation(0, 0); // Remove drop off bounds
        game.getAssets().getDropOffSFX().play(-2.0f);
        game.getAssets().getCarDoorsSFX().play(6.0f);
    }

    /**
     * Pays the fare to the driver/player.
     */
    private void payFare() {
        game.getGamePanel().getCar().addMoneyMade(fare);
        if (fare > game.getGamePanel().getHighestFarePaid()) {
            game.getGamePanel().setHighestFarePaid(fare);
        }
    }

    // ------------------ SETTERS & GETTERS ----------------------- \\

    /**
     * Sets if the customer should be visible to the player or not.
     * 
     * @param isVisible a boolean telling if the customer 
     * should be visible or not
     */
    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    /**
     * Returns the <code>isVisible</code> attribute of this customer.
     * 
     * @return a boolean telling if the customer is visible to the player
     */
    public boolean getIsVisible() {
        return isVisible;
    }

    /**
     * Returns the <code>fare</code> attribute of this customer.
     * 
     * @return An int representing how much the customer will pay the driver
     */
    public int getFare() {
        return fare;
    }

    /**
     * Returns the <code>name</code> attribute of this customer.
     * 
     * @return A String representing the name of this customer
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the <code>hasBeenDroppedOff</code> attribute of this customer.
     * 
     * @return A boolean telling if the customer has been dropped off
     */
    public boolean getHasBeenDroppedOff() {
        return hasBeenDroppedOff;
    }
}