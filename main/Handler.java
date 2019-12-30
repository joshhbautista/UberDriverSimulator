package main;

import input.*;
import states.GameStateManager;
import javax.swing.*;

public class Handler {

    private Game game;
    
    public Handler(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }
    
    public void setGame(Game game) {
        this.game = game;
    }

    public JFrame getFrame() {
        return game.getGameFrame().getFrame();
    }

    public MouseManager getMouseManager() {
        return game.getMouseManager();
    }

    public GameStateManager getGameStateManager() {
        return game.getGameStateManager();
    }
    
}