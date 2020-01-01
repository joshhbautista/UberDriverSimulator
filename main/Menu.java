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

import graphics.Assets;
import graphics.ImageLoader;
import audio.AudioPlayer;

@SuppressWarnings("serial")
public class Menu extends JFrame implements ActionListener {
    
    JButton playButton;
    JButton quitButton;
    JLabel title;
    JLabel background;
    Game game;

    public Menu(Game game) {
        super("Uber Driver Simulator");
        this.game = game;
        setPreferredSize(new Dimension(1600, 900));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        background = new JLabel(new ImageIcon("resources\\townmap.jpg"));
        background.setSize(new Dimension(1600, 900));
        setContentPane(background);
        setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(15, 40, 15, 40);
        c.gridwidth = GridBagConstraints.REMAINDER;

        playButton = new JButton();
        quitButton = new JButton();
        title = new JLabel("Uber Driver Simulator");

        playButton.setIcon(Assets.playButton);
        playButton.setBorderPainted(false);
        playButton.setBorder(null);
        quitButton.setIcon(Assets.quitButton);
        quitButton.setBorderPainted(false);
        quitButton.setBorder(null);

        title.setFont(new Font("", Font.BOLD, 50));

        playButton.setActionCommand("play");
        playButton.addActionListener(this);
        quitButton.setActionCommand("quit");
        quitButton.addActionListener(this);

        add(title, c);
        add(playButton, c);
        add(quitButton, c);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        Assets.menuBgMusic.play();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "play") {
            game.setState("game");
            Assets.menuBgMusic.stop();
            dispose();
            
        }
        if (e.getActionCommand() == "quit") {
            Assets.menuBgMusic.stop();
            game.stop();
            dispose();
        }
    }

}