package main;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import java.awt.*;

/**
 * The <code>GameFrame</code> class is the JFrame that displays
 * the main game to the user. This includes the <code>GamePanel</code>
 * that contains the town map and player's car and the <code>Hud</code>
 * that contains the current stats.
 * 
 * @author Joshua Bautista
 * @version 1/14/2020
 */
@SuppressWarnings("serial")
public class GameFrame extends JFrame {

    /**
     * The width of the JFrame.
     */
    private final int SCREEN_WIDTH = 1600;
    /**
     * The height of the JFrame.
     */
    private final int SCREEN_HEIGHT = 900;
    /**
     * The <code>GamePanel</code> object to be communicated with.
     */
    private GamePanel gamePanel;
    /**
     * The <code>Hud</code> object to be communicated with.
     */
    private Hud hud;

    /**
     * Creates and displays the GameFrame.
     * 
     * @param gamePanel the <code>GamePanel</code> object that displays the main game
     * @param hud the <code>Hud</code> object that displays the stats
     */
    public GameFrame(GamePanel gamePanel, Hud hud) {
        super("Uber Driver Simulator");
        this.gamePanel = gamePanel;
        this.hud = hud;
        
        createGameFrame();
    }

    /**
     * Creates the GameFrame JFrame.
     */
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