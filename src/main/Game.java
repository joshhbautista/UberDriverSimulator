package main;

import javax.swing.JOptionPane;
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
     * Assumed false.
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
     * Initializes all needed game objects and assets 
     * and calls the start method.
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
    private void run() {

        long start;
        long elapsed;
        long wait;

        initialize();

        // ---------------- GAME LOOP ----------------- \\

        while (isGameRunning) {

            // -------- MENU STATE ----- \\
            if (currentState.equals("menu")) {
                new Menu(this);
                currentState = "playing menu";
            } 
            // -------- INIT GAME STATE -------- \\
            else if (currentState.equals("init game")) {
                displayGameDescription();
                hud = new Hud();
                gamePanel = new GamePanel(this);
                gameFrame = new GameFrame(gamePanel, hud);
                currentState = "playing game";
            } 
            // ---------- PLAYING GAME STATE -------- \\ 
            else if (currentState.equals("playing game")) {
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
            // -------- END GAME STATE ------- \\
            else if (currentState.equals("end")) {
                new EndGameFrame(this);
                currentState = "prompt play again";
            } else {
                System.out.println(); // the game bugs out if nothing is outputted in between state changes
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
     * Displays the game description to the user.
     */
    private void displayGameDescription() {
        JOptionPane.showMessageDialog(null, "Welcome to Uber Driver Simulator!\n\nYou are an Uber driver and "
         + "your job is to pick up as much customers as you can before your fuel runs out or when time runs out! "
         + "\n\nUse the \'WASD\' keys to drive your car. If you want to pick up a customer, simply drive near the "
         + "pick up symbol below them.\nOnce they are picked up, they will let you know where to drop them off by displaying " 
         + "a taxi marker on your screen.\nTo drop them off, simply drive to the marker.\nIf you wish to exit the game, press the "
         + " \'X\' button in the top right of your screen. Happy driving!", "Uber Driver Simulator", 1);
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
     * 
     * @param playAgain a boolean telling if the user wants to play again
     */
    public void setPlayAgain(boolean playAgain) {
        this.playAgain = playAgain;
    }

    /**
     * Sets the current state of the game.
     * 
     * @param currentState the current state of the game
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