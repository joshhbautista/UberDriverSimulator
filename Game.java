import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import graphics.*;

public class Game implements Runnable {

    private GameFrame gameFrame;
    private final String title = "Uber Driver Simulator";

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bufferStrategy;
    private Graphics graphics;

    // States
    private GameStateManager gsm;
    private State gameState, menuState;

    public Game() {
    }

    private void init() {
        gameFrame = new GameFrame(title);
        Assets.init();

        gsm = new GameStateManager();
        gameState = new GameState();
        menuState = new MenuState();
        gsm.setState(menuState);
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

    public synchronized void start() {
        if (running) {
            return;
        }
        
        running = true;
        thread = new Thread(this);
        thread.start();

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
}