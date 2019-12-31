package main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import graphics.*;
import input.MouseManager;

public class Game {

    public Game() {
        Assets.init();

        new Menu();

        /*
        gameFrame.getFrame().addMouseListener(mouseManager);
        gameFrame.getFrame().addMouseMotionListener(mouseManager);
        gameFrame.getCanvas().addMouseListener(mouseManager);
        gameFrame.getCanvas().addMouseMotionListener(mouseManager);
        */
        
    }

    /*
    TODO ask about dimensions - what to do to cover all users
    proper GAPP - proper game dev vs GAPP
    how will we be marked (see above)
    ask - static is okay??
    should sounds files be treated as constant

    */
    
}