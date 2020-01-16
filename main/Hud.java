package main;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * The <code>Hud</code> class is a JPanel that displays 
 * the current stats of the game. This includes the total
 * amount of money made, fuel left, and time left.
 * 
 * @author Joshua Bautista
 * @version 1/14/2020
 */
@SuppressWarnings("serial")
public class Hud extends JPanel {

    /**
     * A JLabel that displays the total amount of money made.
     */
    private JLabel moneyMadeLabel;
    /**
     * A JLabel that displays the amount of fuel left.
     */
    private JLabel fuelLeftLabel;
    /**
     * A JProgressBar that visually displays how much fuel is 
     * left by a bar.
     */
    private JProgressBar fuelLeftBar;
    /**
     * A Timer that keeps track of how much time is left in the game.
     */
    private Timer timeLeftTimer;
    /**
     * An int representing the amount of time left in seconds.
     */
    private int timeLeftInSecs;
    /**
     * A String representing the amount of time left in seconds.
     */
    private String timeLeftStr;
    /**
     * A JLabel that displays how much time is remaining.
     */
    private JLabel timeLeftLabel;

    /**
     * Creates and displays the Hud.
     */
    public Hud() {
        createHudFrame();
    }

    /**
     * Creates the Hud JFrame.
     */
    private void createHudFrame() {
        setSize(new Dimension(1600, 200));
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBorder(new LineBorder(Color.BLACK, 5));
        setBackground(Color.WHITE);
        setFocusable(false);

        // -------------- Money Made Label ----------- \\
        moneyMadeLabel = new JLabel();
        moneyMadeLabel.setFont(new Font("", Font.BOLD, 45));
        moneyMadeLabel.setSize(new Dimension(100, 150));
        add(moneyMadeLabel);

        // -------------- Fuel Left Label --------------- \\
        fuelLeftLabel = new JLabel();
        fuelLeftLabel.setFont(new Font("", Font.BOLD, 45));
        fuelLeftLabel.setSize(new Dimension(100, 150));
        add(Box.createHorizontalGlue());
        add(fuelLeftLabel);

        // ---------------------- Fuel Left Bar ----------------- \\
        fuelLeftBar = new JProgressBar(0, 100);
        fuelLeftBar.setOrientation(SwingConstants.HORIZONTAL);
        fuelLeftBar.setBorder(new LineBorder(Color.BLACK, 3));
        fuelLeftBar.setForeground(Color.GREEN);
        add(fuelLeftBar);

        // -------------------- Time Left Timer ------------------\\
        timeLeftInSecs = 275;

        timeLeftTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeLeftInSecs--;
                timeLeftStr = String.format("%d:%02d", timeLeftInSecs / 60, timeLeftInSecs % 60);
                timeLeftLabel.setText("Time Left: " + timeLeftStr);
            }
        });
        timeLeftTimer.start();

        // ------------------ Time Left Label ------------------ \\
        timeLeftLabel = new JLabel();
        timeLeftLabel.setFont(new Font("", Font.BOLD, 45));
        timeLeftLabel.setSize(new Dimension(100, 150));
        add(Box.createHorizontalGlue());
        add(timeLeftLabel);

        setVisible(true);
    }

    /**
     * Returns the <code>moneyMadeLabel</code> JLabel.
     * 
     * @return the JLabel that displays how much money has been made
     */
    public JLabel getMoneyMadeLabel() {
        return moneyMadeLabel;
    }

    /**
     * Returns the <code>fueLLeftLabel</code> JLabel.
     * 
     * @return the JLabel that displays the amount of fuel left
     */
    public JLabel getFuelLeftLabel() {
        return fuelLeftLabel;
    }

    /**
     * Returns the <code>fuelLeftBar</code> JProgressBar.
     * 
     * @return the JProgressBar that visually displays how 
     * much fuel is left
     */
    public JProgressBar getFuelLeftBar() {
        return fuelLeftBar;
    }

    /**
     * Returns the <code>timeLeftInSecs</code> of the game.
     * 
     * @return an int representing how much time is left
     */
    public int getTimeLeft() {
        return timeLeftInSecs;
    }

    /**
     * Returns the <code>timeLeftTimer</code> Timer.
     * 
     * @return a Timer that keeps track of the time left 
     * in the game
     */
    public Timer getTimeLeftTimer() {
        return timeLeftTimer;
    }
}