package main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import graphics.*;
import states.*;

public class Game {

    private GameFrame gameFrame;
    private final String title = "Uber Driver Simulator";

    private boolean running = false;

    private BufferStrategy bufferStrategy;

    private Graphics graphics;
    // States
    private GameStateManager gsm;

    public Game() {
        run();
    }

    private void init() {
        gameFrame = new GameFrame(title);
        Assets.init();

        start();

        gsm = new GameStateManager(this);
        gsm.setState(GameStateManager.MENUSTATE);
    }
 
    /**
     * This method is called every frame
     */
    private void update() {
        if (gsm.getState() != null) {
            gsm.getState().update();
        }

    }

    private void render() {
        if (gsm.getState() != gsm.menuState) {
            bufferStrategy = gameFrame.getCanvas().getBufferStrategy();
            if (bufferStrategy == null) {
                gameFrame.getCanvas().createBufferStrategy(3);
                return;
            }
            graphics = bufferStrategy.getDrawGraphics();

            // Adding resources to graphics object
            if (gsm.getState() != null) {
                gsm.getState().render(graphics);
            }

            // End adding resources
            bufferStrategy.show();
            graphics.dispose();
        }
    }
    
    public void run() {

        init();

        while (running) {
            update();
            render();
        }

        stop();

    }

    public void start() {
        if (running) {
            return;
        }
        
        running = true;
    }

    public GameStateManager getGameStateManager() {
        return gsm;
    }

    public void stop() {
        if (!running) {
            return;
        }
        
        running = false;
    }

    public JFrame getFrame() {
        return gameFrame.getFrame();
    }

    public GameFrame getGameFrame() {
        return gameFrame;
    }
}