package entities;

import graphics.Assets;

import java.awt.Graphics;

public class Car extends Entity {


    public Car(float x, float y) {
        super(x, y, 300, 300);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.car, (int) x, (int) y, super.width, super.height, null);
    }

    
}