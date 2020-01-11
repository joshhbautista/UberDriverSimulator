package main;

import javax.swing.JOptionPane;

public class Launcher {

    private static Game game;
    private static boolean playAgain = true; // TODO declare true here or constructor?

    public static void main(String[] args) {
        playGame();
    }

    private static void playGame() {
        while (playAgain) {
            game = new Game();
            playAgain = game.getPlayAgain();
        }
    }
}