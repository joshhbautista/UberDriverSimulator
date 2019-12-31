package states;

import java.awt.Graphics;
import main.*;

public abstract class State {

    private Game game;

    public State(Game game) {
        this.game = game;
    }

    public abstract void update();

    public abstract void render(Graphics graphics);

    public Game getGame() {
        return game;
    }

}