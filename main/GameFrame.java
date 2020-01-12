package main;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import java.awt.*;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {

    private final int SCREEN_WIDTH = 1600;
    private final int SCREEN_HEIGHT = 900;

    public GameFrame(GamePanel gamePanel, Hud hud) {
        super("Uber Driver Simulator");
        createGameFrame(gamePanel, hud); // TODO pass it in or make it attributes?
    }

   private void createGameFrame(GamePanel gamePanel, Hud hud) {
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setFocusable(false);
        
        add(gamePanel);
        add(hud);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
   }
}