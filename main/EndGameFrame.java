package main;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EndGameFrame extends JFrame {

    private final int WIDTH = 800;
    private final int HEIGHT = 450;

    private JPanel statsPanel;
    private JLabel statsTitle;
    private JLabel stats;

    private JPanel playAgainPanel;
    private JButton playAgainButton;
    private JButton quitButton;

    private String numOfCustomersDriven;
    private double totalMoneyMade;

    public EndGameFrame(Game game) {
        super("Uber Driver Simulator");
        createEndGameFrame(game);
    }

    private void createEndGameFrame(Game game) {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setFocusable(false);
        
        // ------------ End Game Stats ----------- \\
        numOfCustomersDriven = game.getGamePanel().getNumOfCustomersDriven() + "";
        totalMoneyMade = game.getGamePanel().getCar().getMoneyMade();

        statsPanel = new JPanel();
        statsPanel.setLayout(new BoxLayout(statsPanel, BoxLayout.Y_AXIS));

        statsTitle = new JLabel();
        statsTitle.setFont(new Font("", Font.BOLD, 36));
        statsTitle.setText("You've earned...");

        stats = new JLabel();
        stats.setFont(new Font("", Font.BOLD, 24));
        stats.setText("$" + totalMoneyMade + " by driving " + numOfCustomersDriven + " customers!");
        
        statsPanel.add(statsTitle);
        statsPanel.add(stats);

        // --------------- Play Again Options ------------- \\
        playAgainPanel = new JPanel();
        playAgainButton = new JButton("Play Again");
        quitButton = new JButton("Quit");
        playAgainPanel.setLayout(new BoxLayout(playAgainPanel, BoxLayout.X_AXIS));
        playAgainPanel.add(playAgainButton);
        playAgainPanel.add(quitButton);

        add(statsPanel);
        add(playAgainPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}