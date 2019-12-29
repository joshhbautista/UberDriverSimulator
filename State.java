import java.awt.Graphics;

public abstract class State {

    protected Game game;

    public State(Game game) {
        this.game = game;
    }

    public abstract void update();

    public abstract void render(Graphics graphics);

}