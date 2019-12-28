import java.util.ArrayList;
import java.awt.Graphics2D;

public class GameStateManager {

    private State currentState = null;

    public GameStateManager() {

    }

    public void setState(State state) {
        currentState = state;
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