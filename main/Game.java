package main;

import graphics.*;
import input.KeyManager;

public class Game {

    private GameFrame gameFrame;
    private GamePanel gamePanel;
    private Hud hud;
    private KeyManager keyManager;

    private boolean isGameRunning = false;
    private int FPS = 60;
    private long targetTime = 1000 / FPS;

    private String currentState = "";

    public Game() {
        run();
    }

    private void initializeAssets() {
        keyManager = new KeyManager();
        Assets.init();
        start();

        currentState = "menu";
    }

    public void start() {
        if (isGameRunning) {
            return;
        }
        
        isGameRunning = true;
    }

    public void stop() {
        if (!isGameRunning) {
            return;
        }
        
        isGameRunning = false;
    }
    
    public void run() {

        long start;
        long elapsed;
        long wait;

        initializeAssets();

        // ----------------GAME LOOP----------------- \\

        while (isGameRunning) {
            System.out.println(currentState);

            // MENU STATE
            if (currentState == "menu") {
                new Menu(this);
                currentState = "menu playing";
            }

            // GAME STATE
            if (currentState == "game") {
                hud = new Hud();
                gamePanel = new GamePanel(this);
                new GameFrame(gamePanel, hud);
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

            if (currentState == "end") {
                return;
            }
        }
    }

    /**
     * This method is called every frame
     */
    private void update() {
        gamePanel.update();
        keyManager.update();
    }

    private void render() {
        gamePanel.repaint();
    }

    public GameFrame getFrame() {
        return gameFrame;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public Hud getHud() {
        return hud;
    }

    public void setState(String state) {
        currentState = state;
    }
}

    

    /*
    TODO ask about dimensions - what to do to cover all users
    proper GAPP - proper game dev vs GAPP
    how will we be marked (see above)
    ask - static is okay??
    should sounds files be treated as constant
    should car class be PlayerCar or Player or Car?
    do we need setters/getters for ALL attributes or only ones you use?

    */
    
