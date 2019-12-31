package states;

import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.Dimension;

import graphics.Assets;
import entities.*;
import main.*;

public class GameState extends State {

    private Car car;
    private Customer customer;
    private Canvas canvas;

    public GameState(Game game) {
        super(game);

        car = new Car(100, 100);
        customer = new Customer(300, 300);
    }

    public void updateFrame() {
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(1200, 1000));
        
        getGame().getFrame().add(canvas);
        getGame().getFrame().pack();
    }

    @Override
    public void update() {
        car.update();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillRect(0, 0, 100, 100);
        //car.render(graphics);
        //customer.render(graphics);
    }

}