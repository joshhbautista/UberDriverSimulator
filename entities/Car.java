package entities;

import java.awt.Graphics;

import graphics.Assets;

public class Car extends Entity {


    public Car(float x, float y) {
        super(x, y, 300, 300);
    }

    @Override
    public void update() {
        x += 1;
        y += 1;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.car, (int) x, (int) y, super.width, super.height, null);
    }

    
}