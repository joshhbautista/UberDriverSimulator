import java.awt.Graphics;
import graphics.Assets;

public class MenuState extends State {





    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.menu, 0, 0, null);

    }

}