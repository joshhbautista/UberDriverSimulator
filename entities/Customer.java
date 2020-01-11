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
    private double fare;
    private BufferedImage fareDisplay;
    private int[] destination;
    private boolean hasTimeExpired;
    private boolean hasBeenPickedUp;
    private boolean isVisible;
    private Rectangle pickUpSpot, dropOffSpot;

    public Customer(Game game, float x, float y, int width, int height, double fare, BufferedImage fareDisplay, int[] destination) {
        super(x, y, width, height);
        this.game = game;
        this.fare = fare;
        this.fareDisplay = fareDisplay;
        this.destination = destination;
        isVisible = false;
        hasBeenPickedUp = false;

        pickUpSpot = new Rectangle(0, 0, 30, 30); // move this when picked up
        dropOffSpot = new Rectangle(0, 0, 30, 30);
    }

    @Override
    public void update(Hud hud) {
        if (pickUpSpot.intersects(game.getGamePanel().getCar().getCollisionBounds())) {
            int userOption = JOptionPane.showConfirmDialog(null, "Do you want to pick up this customer?", "Uber Driver Simulator", 2);
            if (userOption == 0) {
                pickUpSpot.setLocation(0, 0);
                hasBeenPickedUp = true;
                isVisible = false;
            }
        }
        if (dropOffSpot.intersects(game.getGamePanel().getCar().getCollisionBounds())) {
            JOptionPane.showMessageDialog(null, "You have earned $" + fare + "!", "Uber Driver Simulator", 1);
            payFare();
            hasBeenPickedUp = false;
            dropOffSpot.setLocation(0, 0);
        }
        if (isVisible) {
            pickUpSpot.setLocation((int) getX() + 30 , (int) getY() + 105);
        }
        if (hasBeenPickedUp) {
            pickUpSpot.setLocation(0, 0);
            dropOffSpot.setLocation((int) destination[0], (int) destination[1]);
        }
        // (hasTimeExpired) leave();
    }

    @Override
    public void render(Graphics graphics) {
        if (isVisible) {
            graphics.drawImage(Assets.customers[0], (int) super.getX(), (int) super.getY(), super.getWidth(), super.getHeight(), null);
            graphics.drawImage(fareDisplay, (int) (super.getX() + 35), (int) (super.getY() - 50), 120, 65, null);
            if (!hasBeenPickedUp) {
                graphics.fillRect((int) getX() + 30 , (int) getY() + 105, 30, 30);
            }
        }

        if (hasBeenPickedUp) {
            graphics.fillRect((int) destination[0], (int) destination[1], 30, 30);
        }
    }

    public void giveDirections() {
        
    }

    public void payFare() {
        game.getGamePanel().getCar().addMoneyMade(fare);
    }

    // --- SETTERS & GETTERS --- \\

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public void setHasBeenPickedUp(boolean hasBeenPickedUp) {
        this.hasBeenPickedUp = hasBeenPickedUp;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }
    
}