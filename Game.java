import java.awt.*;
import java.awt.image.BufferStrategy;


public class Game implements Runnable {

    private GameFrame gameFrame;
    private final String title = "Uber Driver Simulator";

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bufferStrategy;
    private Graphics graphics;

    public Game() {
    }

    private void init() {
        gameFrame = new GameFrame(title);
    }

    private void update() {


    }

    private void render() {
        bufferStrategy = gameFrame.getCanvas().getBufferStrategy();
        if (bufferStrategy == null) {
            gameFrame.getCanvas().createBufferStrategy(2);
            return;
        }
        graphics = bufferStrategy.getDrawGraphics();
        // Adding resources

        


        // End adding resources
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