package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import audio.AudioPlayer;
import entities.Car;
import entities.Customer;
import graphics.Assets;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {

    private Game game;

    private final int[][] POSSIBLE_CUSTOMER_LOCATIONS = {{100, 100}, {200, 200}};

    private Car car;

    private Timer timeLeftTimer;
    private int timeLeftInSecs;
    private String timeLeftStr;

    private Timer customerSpawnTimer;
    private final int CUSTOMER_SPAWN_RATE = 30000;

    private int numOfCustomersSpawned = 0;
    private Customer customer1, customer2, customer3, customer4, customer5, customer6, customer7, customer8, customer9, customer10;

    private Hud hud;

    public GamePanel(Game game, Hud hud) {
        this.game = game;
        this.hud = hud;
        addKeyListener(game.getKeyManager());
        setFocusable(true);

        setPreferredSize(new Dimension(1600, 900));
        
        Assets.gameBgMusic.play();
        Assets.carDoorsSFX.play();

        car = new Car(game, 100, 100, 100, 110);
        spawnCustomer();

        timeLeftInSecs = 300;

        // ----------------- Timer ------------------------- //
        timeLeftTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeLeftInSecs--;
                timeLeftStr = String.format("%d:%02d", timeLeftInSecs / 60, timeLeftInSecs % 60);
                hud.getTimeLeftLabel().setText("Time Left: " + timeLeftStr);
            }
        });
        timeLeftTimer.start();

        // ------------------------ Customer Spawn Timer  ----------------- \\
        customerSpawnTimer = new Timer(CUSTOMER_SPAWN_RATE, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spawnCustomer();
                Assets.customerSpawnSFX.play();
            }
        });
        customerSpawnTimer.start(); // TODO remeber to end timers when game ends
    }

    public void update() {
        car.update(hud);

        updateCustomers();

        if (timeLeftInSecs == 0) {

        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Assets.townMap, 0, 0, 1600, 790, null);
        car.render(g);
        renderCustomers(g);
    }

    private void spawnCustomer() {
        if (numOfCustomersSpawned == 0)
            customer1 = new Customer(POSSIBLE_CUSTOMER_LOCATIONS[0][0], POSSIBLE_CUSTOMER_LOCATIONS[0][1], 60, 100, 5);
            numOfCustomersSpawned++;
        if (numOfCustomersSpawned == 1)
            customer2 = new Customer(POSSIBLE_CUSTOMER_LOCATIONS[0][0], POSSIBLE_CUSTOMER_LOCATIONS[0][1], 60, 100, 5);
            numOfCustomersSpawned++;
        if (numOfCustomersSpawned == 2)
            customer3 = new Customer(POSSIBLE_CUSTOMER_LOCATIONS[0][0], POSSIBLE_CUSTOMER_LOCATIONS[0][1], 60, 100, 5);
            numOfCustomersSpawned++;
        if (numOfCustomersSpawned == 3)
            customer4 = new Customer(POSSIBLE_CUSTOMER_LOCATIONS[0][0], POSSIBLE_CUSTOMER_LOCATIONS[0][1], 60, 100, 5);
            numOfCustomersSpawned++;
        if (numOfCustomersSpawned == 4)
            customer5 = new Customer(POSSIBLE_CUSTOMER_LOCATIONS[0][0], POSSIBLE_CUSTOMER_LOCATIONS[0][1], 60, 100, 5);
            numOfCustomersSpawned++;
        if (numOfCustomersSpawned == 5)
            customer6 = new Customer(POSSIBLE_CUSTOMER_LOCATIONS[0][0], POSSIBLE_CUSTOMER_LOCATIONS[0][1], 60, 100, 5);
            numOfCustomersSpawned++;
        if (numOfCustomersSpawned == 6)
            customer7 = new Customer(POSSIBLE_CUSTOMER_LOCATIONS[0][0], POSSIBLE_CUSTOMER_LOCATIONS[0][1], 60, 100, 5);
            numOfCustomersSpawned++; 
        if (numOfCustomersSpawned == 7)
            customer8 = new Customer(POSSIBLE_CUSTOMER_LOCATIONS[0][0], POSSIBLE_CUSTOMER_LOCATIONS[0][1], 60, 100, 5);
            numOfCustomersSpawned++;
        if (numOfCustomersSpawned == 8)
            customer9 = new Customer(POSSIBLE_CUSTOMER_LOCATIONS[0][0], POSSIBLE_CUSTOMER_LOCATIONS[0][1], 60, 100, 5);
            numOfCustomersSpawned++;
        if (numOfCustomersSpawned == 9)
            customer10 = new Customer(POSSIBLE_CUSTOMER_LOCATIONS[0][0], POSSIBLE_CUSTOMER_LOCATIONS[0][1], 60, 100, 5);
            numOfCustomersSpawned++;
    }

    private void updateCustomers() {
        if (numOfCustomersSpawned == 0) customer1.update(hud);
        if (numOfCustomersSpawned == 1) customer1.update(hud); customer2.update(hud);
        if (numOfCustomersSpawned == 2) customer1.update(hud); customer2.update(hud); customer3.update(hud);
        if (numOfCustomersSpawned == 3) customer1.update(hud); customer2.update(hud); customer4.update(hud);
        if (numOfCustomersSpawned == 4)
        if (numOfCustomersSpawned == 5)
        if (numOfCustomersSpawned == 6)
        if (numOfCustomersSpawned == 7)
        if (numOfCustomersSpawned == 8)
        if (numOfCustomersSpawned == 9);
    }

    private void renderCustomers(Graphics g) {
        if (numOfCustomersSpawned == 0) customer1.render(g);
        if (numOfCustomersSpawned == 1) customer1.render(g); customer2.render(g);
        if (numOfCustomersSpawned == 2) customer1.render(g); customer2.render(g); customer3.render(g);
        if (numOfCustomersSpawned == 3) customer1.render(g); customer2.render(g); customer4.render(g);
        if (numOfCustomersSpawned == 4)
        if (numOfCustomersSpawned == 5)
        if (numOfCustomersSpawned == 6)
        if (numOfCustomersSpawned == 7)
        if (numOfCustomersSpawned == 8)
        if (numOfCustomersSpawned == 9);
    }
}