package states;

import java.awt.Graphics2D;
import main.*;

public abstract class State {

    private Game game;

    public State(Game game) {
        this.game = game;
    }

    public abstract void update();

    public abstract void render(Graphics2D graphics);

    public Game getGame() {
        return game;
    }

}