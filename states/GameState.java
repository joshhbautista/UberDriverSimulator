package states;

import java.awt.Graphics;
import graphics.Assets;
import entities.*;
import main.*;

public class GameState extends State {

    private Car car;
    private Customer customer;

    public GameState(Game game) {
        super(game);

        car = new Car(100, 100);
        customer = new Customer(300, 300);
    }

    public void updateFrame() {

    }

    @Override
    public void update() {
        car.update();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.car, 0, 0, null);
        //car.render(graphics);
        //customer.render(graphics);
    }

}