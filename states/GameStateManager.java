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

    public GameStateManager(Handler handler) {
        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        pickMapState = new PickMapState(handler);
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