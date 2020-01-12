package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;

import java.awt.Rectangle;

import graphics.Assets;
import main.Game;
import main.Hud;

public class Customer extends Entity {

    private Game game;
    private int fare;
    private BufferedImage fareDisplay, customerImage;
    private int[] destination;
    private boolean hasBeenPickedUp;
    private boolean isVisible;
    private Rectangle pickUpSpot, dropOffSpot;

    public Customer(Game game, float x, float y, int width, int height, int fare, BufferedImage fareDisplay, BufferedImage customerImage, int[] destination) {
        super(x, y, width, height);
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
            pickUpSpot.setLocation((int) getX() + 6 , (int) getY() + 100); // Set pick up bounds
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
            graphics.drawImage(customerImage, (int) super.getX(), (int) super.getY(), super.getWidth(), super.getHeight(), null); // Customer
            graphics.drawImage(fareDisplay, (int) (super.getX() + 35), (int) (super.getY() - 50), 120, 65, null); // Fare display
            if (!hasBeenPickedUp) {
                graphics.drawImage(Assets.pickUpSymbol, (int) getX() + 6, (int) getY() + 100, 50, 50, null); 
            }
        }

        if (hasBeenPickedUp) {
            graphics.drawImage(Assets.dropOffSymbol, (int) destination[0] - 24, (int) destination[1] - 75, 50, 80, null); // Destination symbol
        }
    }

    public void payFare() {
        game.getGamePanel().getCar().addMoneyMade(fare);
    }

    // --- SETTERS & GETTERS --- \\

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public void setHasBeenPickedUp(boolean hasBeenPickedUp) {
        this.hasBeenPickedUp = hasBeenPickedUp;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }
}