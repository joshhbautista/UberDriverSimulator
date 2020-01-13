package main;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import java.awt.*;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {

    private final int SCREEN_WIDTH = 1600;
    private final int SCREEN_HEIGHT = 900;
    private GamePanel gamePanel;
    private Hud hud;

    public GameFrame(GamePanel gamePanel, Hud hud) {
        super("Uber Driver Simulator");
        this.gamePanel = gamePanel;
        this.hud = hud;
        
        createGameFrame();
    }

   private void createGameFrame() {
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