package entities;

import java.awt.Graphics;
import java.awt.Color;

import graphics.Assets;
import main.Hud;

public class Car extends Entity {

    private double fuelLeft;
    private double moneyMade;

    public Car(float x, float y) {
        super(x, y, 100, 110);

        // TODO TEST
        moneyMade = 12;
        fuelLeft = 9.0;
    }

    @Override
    public void update(Hud hud) {
        hud.getMoneyMadeLabel().setText("Money Made: $" + (int) moneyMade);
        hud.getFuelLeftLabel().setText("Fuel Left: " + fuelLeft + "L");
        hud.getFuelLeftBar().setValue((int) fuelLeft);

        if (fuelLeft < 5)
            hud.getFuelLeftBar().setForeground(Color.YELLOW);
        if (fuelLeft < 2) {
           hud.getFuelLeftBar().setForeground(Color.RED); 
        }
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.car, (int) x, (int) y, super.width, super.height, null);
    }

    
}