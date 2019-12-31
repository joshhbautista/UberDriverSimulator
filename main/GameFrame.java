package main;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import java.awt.*;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {

    private final static int WIDTH = 800;
    private final static int HEIGHT = 800;

    public GameFrame(GamePanel gamePanel, Hud hud) {
        super("Uber Driver Simulator");
        setPreferredSize(new Dimension(1600, 900));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        add(gamePanel);
        add(hud);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    
}