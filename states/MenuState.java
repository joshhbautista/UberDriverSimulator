package states;

import java.awt.Graphics;
import graphics.Assets;
import main.*;

public class MenuState extends State {


    public MenuState(Handler handler) {
        super(handler);
    }


    @Override
    public void update() {
        if (handler.getMouseManager().isLeftPressed() && handler.getMouseManager().isRightPressed()) {
            handler.getGameStateManager().setState(GameStateManager.GAMESTATE);
        }
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.menu, 0, 0, 800, 800, null);

    }

}