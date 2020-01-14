package main;

import graphics.*;
import input.KeyManager;

public class Game {

    private GameFrame gameFrame;
    private GamePanel gamePanel;
    private Hud hud;
    private KeyManager keyManager;
    private Assets assets;

    private boolean isGameRunning;
    private boolean playAgain = false;
    private final int SCREEN_UPDATE_RATE = 60;
    private long targetTime = 1000 / SCREEN_UPDATE_RATE;

    private String currentState;

    public Game() {
        run();
    }

    private void initialize() {
        keyManager = new KeyManager();
        assets = new Assets();
        start();
    }

    public void start() {
        if (isGameRunning) {
            return;
        }
        
        currentState = "menu";
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

        initialize();

        // ----------------GAME LOOP----------------- \\

        while (isGameRunning) {
            System.out.println(currentState);

            if (currentState.equals("menu")) {
                new Menu(this);
                currentState = "playing menu";
            }
            
            // GAME STATE
            if (currentState.equals("game")) {
                hud = new Hud();
                gamePanel = new GamePanel(this);
                gameFrame = new GameFrame(gamePanel, hud);
                currentState = "playing game";
            }

            // GAME PLAYING STATE
            if (currentState.equals("playing game")) {
                start = System.nanoTime();

                update();
                render();
    
                elapsed = System.nanoTime() - start;
    
                wait = targetTime - elapsed / 1000000;
    
                try {
                    Thread.sleep(wait);
                } catch (Exception e) {
                    //e.printStackTrace();
                } 
            }

            // END GAME STATE
            if (currentState.equals("end")) {
                new EndGameFrame(this);
                currentState = "prompt play again";
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

    public boolean getPlayAgain() {
        return playAgain;
    }

    public void setPlayAgain(boolean playAgain) {
        this.playAgain = playAgain;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public Assets getAssets() {
        return assets;
    }
}

    /*
    should car class be PlayerCar or Player or Car?
    do we need setters/getters for ALL attributes or only ones you use?
    */
    
