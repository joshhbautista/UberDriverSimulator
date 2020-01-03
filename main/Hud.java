package main;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import graphics.Assets;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.Timer;

public class Hud extends JPanel {

    private JLabel moneyMadeLabel;
    private JLabel fuelLeftLabel;
    private JProgressBar fuelLeftBar;
    private JButton settingsButton;

    private Timer timeLeftTimer;
    private int timeLeftInSecs;
    private String timeLeftStr;
    private JLabel timeLeft;

    public Hud() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBorder(new LineBorder(Color.BLACK, 5));
        setBackground(Color.WHITE);
        setFocusable(false);

        // -------------- Money Made Label ----------- \\
        moneyMadeLabel = new JLabel();
        moneyMadeLabel.setFont(new Font("", Font.BOLD, 30));
        moneyMadeLabel.setSize(new Dimension(100, 50));
        add(moneyMadeLabel);

        // -------------- Fuel Left Label --------------- \\
        fuelLeftLabel = new JLabel();
        fuelLeftLabel.setFont(new Font("", Font.BOLD, 30));
        fuelLeftLabel.setSize(new Dimension(100, 50));
        add(Box.createHorizontalGlue());
        add(fuelLeftLabel);

        // ---------------------- Fuel Left Bar ----------------- \\
        fuelLeftBar = new JProgressBar(0, 100);
        fuelLeftBar.setOrientation(SwingConstants.HORIZONTAL);
        fuelLeftBar.setBorder(new LineBorder(Color.BLACK, 3));
        fuelLeftBar.setForeground(Color.GREEN);
        add(fuelLeftBar);

        // -------------------- Time Left Timer ------------------\\
        timeLeftInSecs = 300;

        timeLeftTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeLeftInSecs--;
                timeLeftStr = String.format("%d:%02d", timeLeftInSecs / 60, timeLeftInSecs % 60);
                timeLeft.setText("Time Left: " + timeLeftStr);
            }
        });
        timeLeftTimer.start();

        // ------------------ Time Left Label ------------------ \\
        timeLeft = new JLabel();
        timeLeft.setFont(new Font("", Font.BOLD, 30));
        timeLeft.setSize(new Dimension(100, 50));
        add(Box.createHorizontalGlue());
        add(timeLeft);

        // --------- Settings Button -------------- \\
        settingsButton = new JButton();
        settingsButton.setIcon(Assets.settingsButton);
        add(Box.createHorizontalGlue());
        add(Box.createHorizontalGlue());
        add(settingsButton);

        setVisible(true);
    }

    public JLabel getMoneyMadeLabel() {
        return moneyMadeLabel;
    }

    public JLabel getFuelLeftLabel() {
        return fuelLeftLabel;
    }

    public JProgressBar getFuelLeftBar() {
        return fuelLeftBar;
    }

    public int getTimeLeft() {
        return timeLeftInSecs;
    }

    public Timer getTimeLeftTimer() {
        return timeLeftTimer;
    }
}