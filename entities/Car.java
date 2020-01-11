package entities;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;

import graphics.Assets;
import main.Game;
import main.Hud;

public class Car extends Entity {

    private Game game;
    private double fuelLeft;
    private double moneyMade;
    private boolean isDrivingACustomer;
    private BufferedImage car;
    private float xMove, yMove;

    public Car(Game game, float x, float y, int width, int height) {
        super(x, y, width, height);
        this.game = game;
        car = Assets.audi[0];
        xMove = 0;
        yMove = 0;

        isDrivingACustomer = false;
        moneyMade = 0;
        fuelLeft = 100.0;
    }

    @Override
    public void update(Hud hud) {

        // Car Movement \\
        getInputFromUser();
        move();
        
        // ------------------------- Hud --------------------------- \\
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
        graphics.drawImage(car, (int) super.getX(), (int) super.getY(), super.getWidth(), super.getHeight(), null);
    }

    public void move() {
        moveXPos();
        moveYPos();
    }

    public void moveXPos() {
        setX(getX() + xMove);
    }

    public void moveYPos() {
        setY(getY() + yMove);
    }

    private void getInputFromUser() {
        xMove = 0;
        yMove = 0;

        if (game.getKeyManager().getIsUpPressed()) {
            car = Assets.audi[0];
            fuelLeft -= 0.01;
            yMove = -2;
        }
        if (game.getKeyManager().getIsDownPressed()) {
            car = Assets.audi[2];
            fuelLeft -= 0.01;
            yMove = 2;
        }
        if (game.getKeyManager().getIsLeftPressed()) {
            car = Assets.audi[3];
            fuelLeft -= 0.01;
            xMove = -2;
        }
        if (game.getKeyManager().getIsRightPressed()) {
            car = Assets.audi[1];
            fuelLeft -= 0.01;
            xMove = 2;
        }
    }

    public void pickUpCustomer(Customer customer) {

    }

    public void dropOffCustomer(Customer customer) {

    }

    public void checkIfCustomerIsCloseEnough(Customer customer) {

    }

    // ------- SETTERS & GETTERS ------- \\

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getxMove() {
        return xMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setFuelLeft(double newFuelLeft) {
        fuelLeft = newFuelLeft;
    }

    public double getFuelLeft() {
        return fuelLeft;
    }

    public void addMoneyMade(double moneyMadeToBeAdded) {
        moneyMade += moneyMadeToBeAdded;
    }
    
    public double getMoneyMade() {
        return moneyMade;
    }

    public void setMoneyMade(double newMoneyMade) {
        moneyMade = newMoneyMade;
    }
    
    public Rectangle getCollisionBounds() {
        return new Rectangle((int) super.getX() + 42, (int) super.getY() + 45, 15, 20);
    }
}
