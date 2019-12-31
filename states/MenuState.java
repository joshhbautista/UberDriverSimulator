package states;

import java.awt.Graphics;
import javax.swing.*;
import graphics.Assets;
import main.*;
import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.Font;

public class MenuState extends State implements ActionListener {

    private JButton playButton, quitButton;
    private JLabel title;

    public MenuState(Game game) {
        super(game);
        updateMenuFrame();
    }

    public void updateMenuFrame() {
        getGame().getFrame().setVisible(false);
        getGame().getFrame().removeAll();

        // background = new JLabel(new ImageIcon("resources\\townmap.jpg"));
        // background.setSize(new Dimension(1200, 1000));
        // setContentPane(background);
        getGame().getFrame().setLayout(new GridBagLayout());

        Font buttonFont = new Font(Font.DIALOG, Font.PLAIN, 24);

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(15, 40, 15, 40);
        c.gridwidth = GridBagConstraints.REMAINDER;

        playButton = new JButton();
        quitButton = new JButton();
        title = new JLabel("Uber Driver Simulator Menu");

        // playButton.setIcon(Assets.playButton);
        playButton.setBorderPainted(false);
        playButton.setBorder(null);
        // quitButton.setIcon(Assets.quitButton);
        quitButton.setBorderPainted(false);
        quitButton.setBorder(null);

        title.setFont(buttonFont);

        playButton.setActionCommand("play");
        playButton.addActionListener(this);
        quitButton.setActionCommand("quit");
        quitButton.addActionListener(this);

        getGame().getFrame().add(title, c);
        getGame().getFrame().add(playButton, c);
        getGame().getFrame().add(quitButton, c);

        getGame().getFrame().pack();

        getGame().getFrame().revalidate();
        getGame().getFrame().repaint();
        getGame().getFrame().setVisible(true);

        // Assets.menuBgMusic.play();
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.menu, 0, 0, 800, 800, null);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }


}