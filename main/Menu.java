package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

/**
 * The <code>Menu</code> class is a JFrame that displays the 
 * menu of the game to the user. It contains a "Play" and "Quit"
 * button.
 * 
 * @author Joshua Bautista
 * @version 1/14/2020
 */
@SuppressWarnings("serial")
public class Menu extends JFrame implements ActionListener {
    
    /**
     * A JButton that checks if the user wants to play.
     */
    private JButton playButton;
    /**
     * A JButton that checks if the user wants to quit.
     */
    private JButton quitButton;
    /**
     * A JLabel that displays the title of the game.
     */
    private JLabel title;
    /**
     * A JLabel that contains the menu background image.
     */
    private JLabel background;
    /**
     * The <code>Game</code> object to be communicated with.
     */
    private Game game;

    /**
     * Creates and displays the menu.
     * 
     * @param game the <code>Game</code> object to be 
     * communicated with
     */
    public Menu(Game game) {
        super("Uber Driver Simulator");
        this.game = game;
        createMenuFrame();
        playBackgroundMusic(-5.0f);
    }

    /**
     * Creates the Menu JFrame.
     */
    private void createMenuFrame() {
        setPreferredSize(new Dimension(1600, 900));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        background = new JLabel(new ImageIcon("resources\\HUD\\townmap.jpg"));
        background.setSize(new Dimension(1600, 900));
        setContentPane(background);
        setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(15, 40, 15, 40);
        c.gridwidth = GridBagConstraints.REMAINDER;

        playButton = new JButton();
        quitButton = new JButton();
        title = new JLabel();

        playButton.setIcon(game.getAssets().getPlayButtonIcon());
        playButton.setBorderPainted(false);
        playButton.setBorder(null);
        quitButton.setIcon(game.getAssets().getQuitButtonIcon());
        quitButton.setBorderPainted(false);
        quitButton.setBorder(null);

        title.setIcon(game.getAssets().getTitleIcon());
        title.setFont(new Font("", Font.BOLD, 80));
        title.setBorder(new LineBorder(Color.BLACK));
        title.setBackground(Color.BLUE);
        title.setForeground(Color.BLACK);

        playButton.addActionListener(this);
        playButton.setActionCommand("play");
        quitButton.addActionListener(this);
        quitButton.setActionCommand("quit");

        add(title, c);
        add(playButton, c);
        add(quitButton, c);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Plays the menu background music with a 
     * specified volume.
     * 
     * @param volume a float representing how loud 
     * the music should be played
     */
    private void playBackgroundMusic(float volume) {
        game.getAssets().getMenuBgMusic().play(volume);
    }

    /**
     * This method is called everytime an action is 
     * performed. Used to check for button presses.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "play") {
            game.setCurrentState("game");
            game.getAssets().getMenuBgMusic().stop();
            dispose();
        } else {
            game.getAssets().getMenuBgMusic().stop();
            game.stop();
            dispose();
        }
    }

}