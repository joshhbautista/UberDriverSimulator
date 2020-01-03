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

    public Car(Game game, float x, float y, int width, int height) {
        super(x, y, width, height);
        this.game = game;

        // TODO TEST
        moneyMade = 0;
        fuelLeft = 100.0;
    }

    @Override
    public void update(Hud hud) {

        // ---------------------- Car Movement ------------------------ \\
        if (game.getKeyManager().getIsUpPressed()) {
            fuelLeft -= 0.01;
            super.setY(super.getY() - 2);
        }
        if (game.getKeyManager().getIsDownPressed()) {
            fuelLeft -= 0.01;
            super.setY(super.getY() + 2);
        }
        if (game.getKeyManager().getIsLeftPressed()) {
            fuelLeft -= 0.01;
            super.setX(super.getX() - 2);
        }
        if (game.getKeyManager().getIsRightPressed()) {
            fuelLeft -= 0.01;
            super.setX(super.getX() + 2);
        }

        hud.getMoneyMadeLabel().setText("Money Made: $" + (int) moneyMade);
        hud.getFuelLeftLabel().setText("Fuel Left: " + String.format("%.1f", fuelLeft) + " L");
        hud.getFuelLeftBar().setValue((int) fuelLeft);

        if (fuelLeft < 50)
            hud.getFuelLeftBar().setForeground(Color.YELLOW);
        if (fuelLeft < 20) {
           hud.getFuelLeftBar().setForeground(Color.RED); 
        }
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.car, (int) super.getX(), (int) super.getY(), super.getWidth(), super.getHeight(), null);
    }

    public void pickUpCustomer(Customer customer) {

    }

    public void dropOffCustomer(Customer customer) {

    }

    public void checkIfCustomerIsCloseEnough(Customer customer) {

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