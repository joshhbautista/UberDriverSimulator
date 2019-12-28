import java.awt.Graphics;
import graphics.Assets;

public class GameState extends State {





    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.townMap, 0, 0, null);

    }

}