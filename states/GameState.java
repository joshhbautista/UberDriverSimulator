package states;

import java.awt.Graphics2D;
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
    }

    public void updateFrame() {
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(1600, 900));
        
        getGame().getFrame().add(canvas);
        getGame().getFrame().pack();
    }

    @Override
    public void update() {
;
    }

    @Override
    public void render(Graphics2D graphics) {
        graphics.fillRect(0, 0, 100, 100);
        //car.render(graphics);
        //customer.render(graphics);
    }

}