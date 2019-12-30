package states;

import java.awt.Graphics;
import javax.swing.*;
import graphics.Assets;
import main.*;
import javax.swing.*;

public class MenuState extends State {

    private JFrame menuFrame;
    private JLabel menuLabel;
    private JButton startButton;

    public MenuState(Handler handler) {
        super(handler);

        /*
        menuFrame = handler.getGame().getGameFrame().getFrame();
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setResizable(false);
        menuFrame.setVisible(true);

        menuLabel = new JLabel("Menu");
        menuLabel.setSize(200, 200);

        startButton = new JButton("Start");

        menuFrame.add(menuLabel);
        menuFrame.add(startButton);

        menuFrame.pack();
        */
        menuLabel = new JLabel("Menu");
        menuLabel.setSize(200,200);
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
        
        //menuFrame.removeAll();
        handler.getFrame().getContentPane().add(menuLabel);
        handler.getFrame().repaint();
        handler.getFrame().revalidate();
    }


}