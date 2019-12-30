package states;

import java.awt.Graphics;
import graphics.Assets;
import entities.*;
import main.*;

public class GameState extends State {

    private Car car;
    private Customer customer;

    public GameState(Handler handler) {
        super(handler);
        car = new Car(100, 100);
        customer = new Customer(300, 300);
    }

    @Override
    public void update() {
        car.update();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.townMap, 0, 0, 800, 800, null);
        car.render(graphics);
        customer.render(graphics);
    }

}