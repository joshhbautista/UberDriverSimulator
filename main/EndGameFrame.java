package main;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import graphics.Assets;

@SuppressWarnings("serial")
public class EndGameFrame extends JFrame implements ActionListener {

    private Game game;
    private final int SCREEN_WIDTH = 800;
    private final int SCREEN_HEIGHT = 450;

    private JPanel statsPanel;
    private JLabel statsTitle;
    private JLabel stats;

    private JPanel playAgainPanel;
    private JButton playAgainButton;
    private JButton quitEndButton;

    private String numOfCustomersDriven;
    private int totalMoneyMade;

    public EndGameFrame(Game game) {
        super("Uber Driver Simulator");
        this.game = game;
        createEndGameFrame();
    }

    private void createEndGameFrame() {
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new GridBagLayout());
        setFocusable(false);
        getContentPane();

        GridBagConstraints frameGBC = new GridBagConstraints();
        frameGBC.insets = new Insets(0, 5, 0, 5);
        frameGBC.gridwidth = GridBagConstraints.REMAINDER;
        frameGBC.weightx = 1.0;
        frameGBC.weighty = 1.0;

        GridBagConstraints panelGBC = new GridBagConstraints();
        panelGBC.insets = new Insets(0, 0, 20, 0);
        panelGBC.gridwidth = GridBagConstraints.REMAINDER;
        
        // ------------ End Game Stats ----------- \\
        numOfCustomersDriven = game.getGamePanel().getNumOfCustomersDriven() + "";
        totalMoneyMade = game.getGamePanel().getCar().getMoneyMade();

        statsPanel = new JPanel();
        statsPanel.setLayout(new GridBagLayout());

        statsTitle = new JLabel();
        statsTitle.setFont(new Font("", Font.BOLD, 48));
        statsTitle.setText("You've earned...");

        stats = new JLabel();
        stats.setFont(new Font("", Font.BOLD, 36));
        stats.setText("$" + totalMoneyMade + " by driving " + numOfCustomersDriven + " customers!");
        
        statsPanel.add(statsTitle, panelGBC);
        statsPanel.add(stats, panelGBC);

        // --------------- Play Again Options ------------- \\
        playAgainPanel = new JPanel();
        playAgainButton = new JButton();
        playAgainButton.setIcon(Assets.playAgainButton);
        playAgainButton.setBorderPainted(false);
        playAgainButton.setBorder(null);
        playAgainButton.addActionListener(this);
        playAgainButton.setActionCommand("play again");

        quitEndButton = new JButton();
        quitEndButton.setIcon(Assets.quitEndButton);
        quitEndButton.setBorderPainted(false);
        quitEndButton.setBorder(null);
        quitEndButton.addActionListener(this);
        quitEndButton.setActionCommand("quit");

        playAgainPanel.setLayout(new BoxLayout(playAgainPanel, BoxLayout.X_AXIS));
        playAgainPanel.add(playAgainButton);
        playAgainPanel.add(quitEndButton);

        add(statsPanel, frameGBC);
        add(Box.createHorizontalGlue());
        add(playAgainPanel, frameGBC);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "play again") {
            game.setPlayAgain(true);
            game.stop();
            dispose();
            game.getFrame().dispose();
        } else {
            game.stop();
            dispose();
            game.getFrame().dispose();
        }
    }
}