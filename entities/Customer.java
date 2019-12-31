package entities;

import java.awt.Graphics;

import graphics.Assets;
import main.Hud;

public class Customer extends Entity {

    private float fare;

    public Customer(float x, float y) {
        super(x, y, 60, 100);
        fare = 0; // TODO implement random fare method
    }

    public float getFare() {
        return fare;
    }

    public void setFare(float fare) {
        this.fare = fare;
    }

    @Override
    public void update(Hud hud) {
        y += 1;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.customers[0], (int) x, (int) y, super.width, super.height, null);
    }

    
}