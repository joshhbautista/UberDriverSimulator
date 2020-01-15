package main;

/**
 * The <code>Launcher</code> class contains the main
 * method of the game. This is where the <code>Game</code>
 * object is initialized.
 * 
 * @author Joshua Bautista
 * @version 1/14/2020
 */
public class Launcher {

    /**
     * The <code>Game</code> object of the game.
     */
    private static Game game;
    /**
     * A boolean representing if the user wants to play again or not. 
     * Assumed user does not want to play agian.
     */
    private static boolean playAgain = false; // TODO declare true here or constructor? || should this be named launcher?

    public static void main(String[] args) {
        playGame();
    }

    /**
     * Starts and plays the game by initializing a new 
     * <code>Game</code> object.
     */
    private static void playGame() {
        do {
            game = new Game();
            playAgain = game.getPlayAgain();
        } while (playAgain);
    }
}