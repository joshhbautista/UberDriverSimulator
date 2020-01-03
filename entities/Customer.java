package entities;

import java.awt.Graphics;

import graphics.Assets;
import main.Hud;

public class Customer extends Entity {

    private double fare;
    private int[][] destination; // TODO random destination
    private boolean hasTimeExpired;

    public Customer(float x, float y, int width, int height, double fare) {
        super(x, y, width, height);
        this.fare = fare; // TODO implement random fare method
    }

    public void giveDirections() {
        
    }

    public void payFare() {

    }

    public void leave() {
        
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    @Override
    public void update(Hud hud) {
        // (if location == destination) payFare();
        // (hasTimeExpired) leave();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.customers[0], (int) super.getX(), (int) super.getY(), super.getWidth(), super.getHeight(), null);
    }

    
}