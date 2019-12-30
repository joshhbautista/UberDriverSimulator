package main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import graphics.*;
import input.MouseManager;

public class Game {

    public Game() {
        new Menu();

        /*
        gameFrame.getFrame().addMouseListener(mouseManager);
        gameFrame.getFrame().addMouseMotionListener(mouseManager);
        gameFrame.getCanvas().addMouseListener(mouseManager);
        gameFrame.getCanvas().addMouseMotionListener(mouseManager);
        */
        Assets.init();
    }
    
}