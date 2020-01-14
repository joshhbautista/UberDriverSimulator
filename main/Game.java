package main;

import graphics.*;
import input.KeyManager;

/**
 * The <code>Game</code> class houses the game loop. It is the main game
 * class that controls the states of the game. (e.g. the "Menu" 
 * state, the "Game" state, etc) The overall flow of the game can be 
 * controlled in this class. This class contains all game objects and main
 * update and render methods.
 * 
 * @version 1/14/2020
 * @author Joshua Bautista
 */
public class Game {

    /**
     * The JFrame <code>GameFrame</code> object that displays the game.
     */
    private GameFrame gameFrame;
    /**
     * The JPanel <code>GamePanel</code> object that displays the playing bounds.
     */
    private GamePanel gamePanel;
    /**
     * The JPanel <code>Hud</code> object that displays the current stats.
     */
    private Hud hud;
    /**
     * The <code>KeyManager</code> object that handles all keyboard input by the user.
     */
    private KeyManager keyManager;
    /**
     * The <code>Assets</code> object that loads all assets of the game.
     */
    private Assets assets;

    /**
     * A boolean telling if the game is running or not.
     */
    private boolean isGameRunning;
    /**
     * A boolean telling if the user wants to play again.
     */
    private boolean playAgain = false;
    /**
     * An int representing the rate at which the screen updates.
     */
    private final int SCREEN_UPDATE_RATE = 60;
    /**
     * A long representing the target time to be updated.
     */
    private long targetTime = 1000 / SCREEN_UPDATE_RATE;

    /**
     * A String representing the current state of the game.
     */
    private String currentState;

    /**
     * Starts and runs the game.
     */
    public Game() {
        run();
    }

    /**
     * Initializes all needed game objects and assets.
     */
    private void initialize() {
        keyManager = new KeyManager();
        assets = new Assets();
        start();
    }

    /**
     * Starts the game loop by setting the <code>isGameRunning</code>
     * property to true and setting the current state to menu.
     */
    public void start() {
        if (isGameRunning) {
            return;
        }
        
        currentState = "menu";
        isGameRunning = true;
    }

    /**
     * Stops the game loop by setting the <code>isGameRunning</code>
     * property to false.
     */
    public void stop() {
        if (!isGameRunning) {
            return;
        }
        
        isGameRunning = false;
    }
    
    /**
     * Initializes all assets and runs the main game loop.
     */
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
     * This method is called every frame update and is used to
     * update all game variables and check for certain events.
     */
    private void update() {
        gamePanel.update();
        keyManager.update();
    }

    /**
     * This method is called every frame update and is used to 
     * render/update all images drawn onto the <code>GamePanel</code>.
     */
    private void render() {
        gamePanel.repaint();
    }

    /**
     * Returns the <code>GameFrame</code> object.
     * 
     * @return the JFrame that displays the game
     */
    public GameFrame getFrame() {
        return gameFrame;
    }

    /**
     * Returns the <code>GamePanel</code> object.
     * 
     * @return the JPanel that displays the player interaction with the town map
     */
    public GamePanel getGamePanel() {
        return gamePanel;
    }

    /**
     * Returns the <code>KeyManager</code> object.
     * 
     * @return the keyboard input handler
     */
    public KeyManager getKeyManager() {
        return keyManager;
    }

    /**
     * Returns the <code>Hud</code> object.
     * 
     * @return the JPanel that displays the current stats
     */
    public Hud getHud() {
        return hud;
    }

    /**
     * Returns the <code>playAgain</code> attribute of the game.
     * 
     * @return a boolean telling if the user wants to play again or not
     */
    public boolean getPlayAgain() {
        return playAgain;
    }

    /**
     * Sets if the user wants to play again.
     */
    public void setPlayAgain(boolean playAgain) {
        this.playAgain = playAgain;
    }

    /**
     * Sets the current state of the game.
     */
    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    /**
     * Returns the <code>Assets</code> attribute of the game.
     * 
     * @return a class that contains all of the game assets
     */
    public Assets getAssets() {
        return assets;
    }
}

    /*
    TODO should car class be PlayerCar or Player or Car?
    */
    
