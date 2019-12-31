package states;

import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import graphics.Assets;
import main.*;
import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class MenuState extends State implements ActionListener {

    private JPanel menuPanel;
    private JButton playButton, quitButton;
    private JLabel title;
    private JLabel background;

    public MenuState(Game game) {
        super(game);
        updateFrame();
    }

    public void updateFrame() {

        menuPanel = new JPanel(new GridBagLayout());
        menuPanel.setOpaque(false);

        getGame().getGameFrame().getCanvas().setVisible(false);
        getGame().getFrame().setLayout(new GridBagLayout());
        
        background = new JLabel(new ImageIcon("resources\\townmap.jpg"));
        background.setPreferredSize(new Dimension(1200, 1000));
        getGame().getFrame().setContentPane(background);
        getGame().getFrame().setLayout(new GridBagLayout());

        Font buttonFont = new Font(Font.DIALOG, Font.PLAIN, 24);
        
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
        
        title.setFont(buttonFont);
        
        playButton.setActionCommand("play"); 
        playButton.addActionListener(this);
        quitButton.setActionCommand("quit"); 
        quitButton.addActionListener(this);
        
        menuPanel.add(title, c); 
        menuPanel.add(playButton, c);
        menuPanel.add(quitButton, c);
        
        getGame().getFrame().add(menuPanel);
        getGame().getFrame().pack();
        
        getGame().getFrame().revalidate(); 
        getGame().getFrame().repaint();
        
        Assets.menuBgMusic.play();
        
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.car, 0, 0, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "play") {
            Assets.menuBgMusic.stop();
            menuPanel.setVisible(false);
            background.setVisible(false);
            getGame().getGameFrame().getCanvas().setVisible(true);
            getGame().getFrame().revalidate(); 
            getGame().getFrame().repaint();
            getGame().getGameStateManager().setState(GameStateManager.GAMESTATE);
        }
        if (e.getActionCommand() == "quit") {
            Assets.menuBgMusic.stop();
            getGame().getFrame().dispose();
        }
    }


}