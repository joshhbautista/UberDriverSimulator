package main;

import javax.swing.JOptionPane;

public class Launcher {

    private static Game game;
    private static boolean playAgain;

    public static void main(String[] args) {
        playGame();
    }

    private static void playGame() {
        do {
            game = new Game();
            playAgain = getIfUserWantsToPlayAgain(game);
        } while (playAgain);
        System.exit(0);
    }

    private static boolean getIfUserWantsToPlayAgain(Game game) {
        int userOption = JOptionPane.showConfirmDialog(null, "Play Again?", "Uber Driver Simulator", JOptionPane.YES_NO_OPTION);
        if (userOption == 0) {
            game.getFrame().dispose();
            return true;
        } else {
            return false;
        }
    }
}