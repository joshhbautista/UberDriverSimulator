package states;

import java.util.ArrayList;
import java.awt.Graphics2D;
import main.*;

public class GameStateManager {

    private State currentState = null;
    private State gameState, menuState, pickMapState;

    public static final int MENUSTATE = 0;
    public static final int PICKMAPSTATE = 1;
    public static final int GAMESTATE = 2;

    public GameStateManager(Game game) {
        menuState = new MenuState(game);
        gameState = new GameState(game);
        pickMapState = new PickMapState(game);
    }

    public void setState(int state) {
        if (state == MENUSTATE) {
            currentState = menuState;
        } 
        if (state == GAMESTATE) {
            currentState = gameState;
        }
        if (state == PICKMAPSTATE) {
            currentState = pickMapState;
        }
    }

    public State getState() {
        return currentState;
    }

    /*
    public void update() {
        gameStates.get(currentState).update();
    }

    public void draw(Graphics graphics) {
        gameStates.get(currentState).draw();
    }

    public void keyPressed(int k) {
        gameStates.get(currentState).keyPressed(k);
    }

    public void keyReleased(int k) {
        gameStates.get(currentState).keyReleased(k);
    }
    */
}