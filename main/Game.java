package main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import graphics.*;
import input.MouseManager;
import states.*;

public class Game implements Runnable {

    private GameFrame gameFrame;
    private final String title = "Uber Driver Simulator";

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bufferStrategy;
    private Graphics graphics;

    // States
    private GameStateManager gsm;

    // Input
    private MouseManager mouseManager;

    // Handler
    private Handler handler;

    public Game() {
        mouseManager = new MouseManager();
    }

    private void init() {
        gameFrame = new GameFrame(title);
        gameFrame.getFrame().addMouseListener(mouseManager);
        gameFrame.getFrame().addMouseMotionListener(mouseManager);
        gameFrame.getCanvas().addMouseListener(mouseManager);
        gameFrame.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();

        handler = new Handler(this);

        gsm = new GameStateManager(handler);
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
        bufferStrategy = gameFrame.getCanvas().getBufferStrategy();
        if (bufferStrategy == null) {
            gameFrame.getCanvas().createBufferStrategy(2);
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
    
    @Override
    public void run() {

        init();

        while (running) {
            update();
            render();
        }

        stop();

    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    public synchronized void start() {
        if (running) {
            return;
        }
        
        running = true;
        thread = new Thread(this);
        thread.start();

    }

    public GameStateManager getGameStateManager() {
        return gsm;
    }

    public synchronized void stop() {
        if (!running) {
            return;
        }
        
        running = false;

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public GameFrame getGameFrame() {
        return gameFrame;
    }
}