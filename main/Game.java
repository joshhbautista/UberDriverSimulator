package main;

import graphics.*;
import input.KeyManager;

public class Game {

    private GameFrame gameFrame;
    private GamePanel gamePanel;
    private Hud hud;
    private KeyManager keyManager;

    private boolean isGameRunning = false;
    private boolean playAgain = false;
    private final int SCREEN_UPDATE_RATE = 60;
    private long targetTime = 1000 / SCREEN_UPDATE_RATE;

    private String currentState;

    public Game() {
        run();
    }

    private void initialize() {
        keyManager = new KeyManager();
        Assets.initialize();
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

        initialize();

        // ----------------GAME LOOP----------------- \\

        while (isGameRunning) {
            System.out.println(currentState);

            // MENU STATE
            if (currentState.equals("menu")) {
                new Menu(this);
                currentState = "menu playing";
            }

            // GAME STATE
            if (currentState.equals("game")) {
                hud = new Hud();
                gamePanel = new GamePanel(this);
                gameFrame = new GameFrame(gamePanel, hud);
                currentState = "game playing";
            }

            // GAME PLAYING STATE
            if (currentState.equals("game playing")) {
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
                currentState = "ask if play again";
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

    public String getCurrentState() {
        return currentState;
    }

    public void setState(String state) {
        currentState = state;
    }
}

    /*
    should car class be PlayerCar or Player or Car?
    do we need setters/getters for ALL attributes or only ones you use?
    */
    
