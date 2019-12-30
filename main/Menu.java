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

    private AudioPlayer backgroundMusic;

    public Menu() {
        super("Uber Driver Simulator");
        setPreferredSize(new Dimension(800, 800));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        background = new JLabel(new ImageIcon("resources\\townmap.PNG"));
        background.setSize(new Dimension(800, 800));
        setContentPane(background);
        setLayout(new GridBagLayout());

        Font buttonFont = new Font(Font.DIALOG, Font.PLAIN, 24);

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(15, 40, 15, 40);
        c.gridwidth = GridBagConstraints.REMAINDER;

        playButton = new JButton();
        quitButton = new JButton();
        title = new JLabel("Uber Driving Simulator");

        playButton.setIcon(new ImageIcon("resources\\Menu\\playbutton.png"));
        playButton.setBorderPainted(false);
        playButton.setBorder(null);
        quitButton.setIcon(new ImageIcon("resources\\Menu\\quitbutton.png"));
        quitButton.setBorderPainted(false);
        quitButton.setBorder(null);
        title.setFont(buttonFont);

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

        backgroundMusic = new AudioPlayer("resources\\Music\\level1-1.wav");
        backgroundMusic.play();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "play") {
            new GameFrame(new GamePanel());
            dispose();
            
        }
        if (e.getActionCommand() == "quit") {
            backgroundMusic.stop();
            dispose();
        }
    }

}