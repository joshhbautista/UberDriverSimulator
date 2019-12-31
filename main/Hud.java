package main;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import graphics.Assets;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class Hud extends JPanel {

    private JLabel moneyMadeLabel;
    private JLabel fuelLeftLabel;
    private JLabel TBD;
    private JButton settingsButton;

    public Hud() {
        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 15, 10, 15);

        moneyMadeLabel = new JLabel("Money Made: ");
        moneyMadeLabel.setSize(new Dimension(100, 50));
        gbc.gridy = 5;
        gbc.gridx = 1;
        add(moneyMadeLabel, gbc);

        fuelLeftLabel = new JLabel("Fuel Left: ");
        fuelLeftLabel.setSize(new Dimension(100, 50));
        gbc.gridx = 9;
        add(fuelLeftLabel, gbc);

        settingsButton = new JButton();
        settingsButton.setIcon(Assets.settingsButton);
        settingsButton.setSize(new Dimension(25, 25));
        add(settingsButton, gbc);

        setVisible(true);
    }

    public JLabel getMoneyMadeLabel() {
        return moneyMadeLabel;
    }

    public JLabel getFuelLeftLabel() {
        return fuelLeftLabel;
    }
}