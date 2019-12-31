package main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import graphics.*;

public class Game {

    private JFrame gameFrame;

    private boolean running = false;
    private int FPS = 60;
    private long targetTime = 1000 / FPS;

    private String currentState = null;

    private GamePanel gamePanel;

    public Game() {
        run();
    }

    private void init() {
        Assets.init();
        start();

        new Menu(this);
    }
 
    /**
     * This method is called every frame
     */
    private void update() {
        gamePanel.update();
    }

    private void render() {
        gamePanel.repaint();
    }
    
    public void run() {

        long start;
        long elapsed;
        long wait;

        // -----------GAME LOOP------------ //
        init();

        while (running) {
            System.out.println(""); // why does this only run when I put this???

            // GAME STATE
            if (currentState == "game") {
                gamePanel = new GamePanel();
                new GameFrame(gamePanel);
                currentState = "game playing";
            }

            // PLAY AGAIN STATE
            if (currentState == "play again") {

            }

            // GAME PLAYING STATE
            if (currentState == "game playing") {
                start = System.nanoTime();

                update();
                render();
    
                elapsed = System.nanoTime() - start;
    
                wait = targetTime - elapsed / 1000000;
    
                try {
                    Thread.sleep(wait);
                } catch (Exception e) {
                    e.printStackTrace();
                } 
            }
        }
    }

    public void setState(String state) {
        currentState = state;
    }

    public void start() {
        if (running) {
            return;
        }
        
        running = true;
    }

    public void stop() {
        if (!running) {
            return;
        }
        
        running = false;
    }

    public JFrame getFrame() {
        return gameFrame;
    }


}

    

    /*
    TODO ask about dimensions - what to do to cover all users
    proper GAPP - proper game dev vs GAPP
    how will we be marked (see above)
    ask - static is okay??
    should sounds files be treated as constant

    */
    
