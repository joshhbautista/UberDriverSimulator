package states;

import java.awt.Graphics;
import main.*;

public abstract class State {

    protected Handler handler;

    public State(Handler handler) {
        this.handler = handler;
    }

    public abstract void update();

    public abstract void render(Graphics graphics);

}