package entities;

import graphics.Assets;

import java.awt.Graphics;

public class Customer extends Entity {

    private float fare;

    public Customer(float x, float y) {
        super(x, y, 300, 300);
        fare = 0; // TODO implement random fare method
    }

    public float getFare() {
        return fare;
    }

    public void setFare(float fare) {
        this.fare = fare;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.customers[0], (int) x, (int) y, width, height, null);
    }

    
}