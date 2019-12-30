package main;

import javax.swing.JFrame;
import java.awt.*;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {

    private final static int WIDTH = 800;
    private final static int HEIGHT = 800;

    public GameFrame(GamePanel gamePanel) {
        super("Uber Driver Simulator");
        setPreferredSize(new Dimension(800, 800));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        

        add(gamePanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}