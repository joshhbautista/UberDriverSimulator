package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import graphics.Assets;
import main.Hud;

public class Customer extends Entity {

    private double fare;
    private BufferedImage fareDisplay;
    private int[][] destination; // TODO random destination
    private boolean hasTimeExpired;
    private boolean isVisible;

    public Customer(float x, float y, int width, int height, double fare, BufferedImage fareDisplay) {
        super(x, y, width, height);
        this.fare = fare; // TODO implement random fare method
        this.fareDisplay = fareDisplay;
        isVisible = false;
    }

    public void giveDirections() {
        
    }

    public void payFare() {

    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    @Override
    public void update(Hud hud) {
        // (if location == destination) payFare();
        // (hasTimeExpired) leave();
    }

    @Override
    public void render(Graphics graphics) {
        if (isVisible) {
            graphics.drawImage(Assets.customers[1], (int) super.getX(), (int) super.getY(), super.getWidth(), super.getHeight(), null);
            graphics.drawImage(fareDisplay, (int) (super.getX() + 40), (int) (super.getY() - 65), 125, 75, null);
        }
    }

    
}