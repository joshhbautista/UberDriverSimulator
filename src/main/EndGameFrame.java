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

import entities.Customer;
/**
 * The <code>EndGameFrame</code> class is the JFrame that displays
 * the end game frame to the user. The end game frame displays the 
 * end game stats. This includes the total money made and number 
 * of customers driven. It also contains buttons that ask the user
 * if they want to play again or not.
 * 
 * @author Joshua Bautista
 * @version 1/14/2020
 */
@SuppressWarnings("serial")
public class EndGameFrame extends JFrame implements ActionListener {

    /**
     * The <code>Game</code> object to be communicated with.
     */
    private Game game;
    /**
     * The width of the <code>EndGameFrame</code>.
     */
    private final int SCREEN_WIDTH = 800;
    /**
     * The height of the <code>EndGameFrame</code>.
     */
    private final int SCREEN_HEIGHT = 450;

    /**
     * The JPanel that displays all the stats.
     */
    private JPanel statsPanel;
    /**
     * The JLabel that displays the title of the stats panel.
     */
    private JLabel statsTitle;
    /**
     * The JLabel that displays the stats itself.
     */
    private JLabel stats;
    /**
     * The JLabel that displays the highest paying customer.
     */
    private JLabel highestPayingCustomer;
    /**
     * The JPanel that contains play again and quit button.
     */
    private JPanel playAgainPanel;
    /**
     * The play again button JButton.
     */
    private JButton playAgainButton;
    /**
     * The quit end frame JButton.
     */
    private JButton quitEndButton;
    /**
     * A String representing the total number of customers driven.
     */
    private String numOfCustomersDriven;
    /**
     * An int representing the total amount of money made.
     */
    private int totalMoneyMade;

    /**
     * Creates and displays the <code>EndGameFrame</code>.
     * 
     * @param game The <code<Game</code> object to be communicated with
     */
    public EndGameFrame(Game game) {
        super("Uber Driver Simulator");
        this.game = game;
        createEndGameFrame();
    }

    /**
     * Creates the EndGameFrame JFrame.
     */
    private void createEndGameFrame() {
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new GridBagLayout());
        setFocusable(false);
        getContentPane();

        // ------------ GridBagConstraints ------------- \\
        GridBagConstraints frameGBC = new GridBagConstraints();
        frameGBC.insets = new Insets(0, 5, 0, 5);
        frameGBC.gridwidth = GridBagConstraints.REMAINDER;
        frameGBC.weightx = 1.0;
        frameGBC.weighty = 1.0;

        GridBagConstraints panelGBC = new GridBagConstraints();
        panelGBC.insets = new Insets(0, 0, 20, 0);
        panelGBC.gridwidth = GridBagConstraints.REMAINDER;
        
        // --------------------- End Game Stats --------------------- \\
        numOfCustomersDriven = game.getGamePanel().getNumOfCustomersDriven() + "";
        totalMoneyMade = game.getGamePanel().getCar().getMoneyMade();

        statsPanel = new JPanel();
        statsPanel.setLayout(new GridBagLayout());

        statsTitle = new JLabel();
        statsTitle.setFont(new Font("", Font.BOLD, 48));
        statsTitle.setText("You've earned...");

        stats = new JLabel();
        stats.setFont(new Font("", Font.BOLD, 28));
        stats.setText("$" + totalMoneyMade + " by driving " + numOfCustomersDriven + " customer(s)!");

        highestPayingCustomer = new JLabel();
        highestPayingCustomer.setFont(new Font("", Font.BOLD, 24));

        int highestFarePaid = game.getGamePanel().getHighestFarePaid();
        String nameOfHighestPayingCustomer;
        if (highestFarePaid != 0) {
            nameOfHighestPayingCustomer = searchForHighestPayingCustomer(highestFarePaid);
            highestPayingCustomer.setText("One of your highest paying customer(s) was " + nameOfHighestPayingCustomer + " with a $"
             + highestFarePaid + " fare!");
        } else {
            highestPayingCustomer.setText("");
        }

        statsPanel.add(statsTitle, panelGBC);
        statsPanel.add(stats, panelGBC);
        statsPanel.add(highestPayingCustomer, panelGBC);
        
        // --------------- Play Again Options ------------- \\
        playAgainPanel = new JPanel();
        playAgainButton = new JButton();
        playAgainButton.setIcon(game.getAssets().getPlayAgainButtonIcon());
        playAgainButton.setBorderPainted(false);
        playAgainButton.setBorder(null);
        playAgainButton.addActionListener(this);
        playAgainButton.setActionCommand("play again");

        quitEndButton = new JButton();
        quitEndButton.setIcon(game.getAssets().getQuitEndButtonIcon());
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

    /**
     * Searches for the highest paying customer that the player 
     * has driven using a linear search algorithm.
     * 
     * @param highestFareToSearchFor the highest fare to search for
     * @return a String representing the name of the highest paying
     * customer
     */
    private String searchForHighestPayingCustomer(int highestFareToSearchFor) {
        Customer[] customers = game.getGamePanel().getCustomers();

        Customer highestPayingCustomer = searchCustomersForFareUsingLinearSearch(customers, highestFareToSearchFor);

        return highestPayingCustomer.getName();
    }

    /**
     * Searches for a specified fare using the linear search algorithm.
     * 
     * @param customers a <code>Customer</code> array containing all of
     * the customers to search for
     * @param fareToSearchFor the fare to search for
     * @return a <code>Customer</code> object representing the customer
     * that paid the highest fare to the player
     */
    private Customer searchCustomersForFareUsingLinearSearch(Customer[] customers, int fareToSearchFor) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getFare() == fareToSearchFor) {
                if (customers[i].getHasBeenDroppedOff()) {
                    return customers[i];
                }
            }
        }
        return null;
    }

    /**
     * This method is called every time an action is performed.
     * Used to check for button clicks.
     * 
     * @param e the <code>ActionEvent</code>
     */
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