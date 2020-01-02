package entities;

import java.awt.Graphics;
import java.awt.Color;

import graphics.Assets;
import main.Game;
import main.Hud;

public class Car extends Entity {

    private Game game;
    private double fuelLeft;
    private double moneyMade;

    public Car(Game game, float x, float y) {
        super(x, y, 100, 110);
        this.game = game;

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
        System.out.println("is g null car " + (graphics == null));
        graphics.drawImage(Assets.car, (int) x, (int) y, super.width, super.height, null);
    }

    public void setFuelLeft(double newFuelLeft) {
        fuelLeft = newFuelLeft;
    }

    public double getFuelLeft() {
        return fuelLeft;
    }
    
    public double getMoneyMade() {
        return moneyMade;
    }

    public void setMoneyMade(double newMoneyMade) {
        moneyMade = newMoneyMade;
    }
}