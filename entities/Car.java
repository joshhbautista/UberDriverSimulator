package entities;

import java.awt.Graphics;

import graphics.Assets;
import main.Hud;

public class Car extends Entity {

    private double fuelLeft;
    private double moneyMade;


    public Car(float x, float y) {
        super(x, y, 100, 110);

        // TODO TEST
        moneyMade = 12;
        fuelLeft = 10.0;
    }

    @Override
    public void update(Hud hud) {
        x += 1;
        y += 1;
        hud.getMoneyMadeLabel().setText("Money Made: $" + (int) moneyMade);
        hud.getFuelLeftLabel().setText("Fuel Left: " + fuelLeft + "L");
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.car, (int) x, (int) y, super.width, super.height, null);
    }

    
}