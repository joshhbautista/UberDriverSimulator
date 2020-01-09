package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

import entities.Car;
import entities.Customer;
import graphics.Assets;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {

    private Game game;
    private Hud hud;

    private Customer customer1, customer2, customer3, customer4, customer5, customer6, customer7, customer8, customer9, customer10;
    private Car car;
    private Timer customerSpawnTimer;

    private int numOfCustomersDriven = 0;

    private int numOfCustomersSpawned = 0;
    private final int CUSTOMER_SPAWN_RATE = 30000; // 30 seconds
    private final int[][] POSSIBLE_CUSTOMER_LOCATIONS = {{100, 100}, {200, 200}};

    public GamePanel(Game game) {
        this.game = game;
        this.hud = game.getHud();
        addKeyListener(game.getKeyManager());
        setFocusable(true);
        setPreferredSize(new Dimension(1600, 790));
        
        playBackgroundMusic();

        spawnPlayer();
        spawnCustomer();

        startCustomerSpawnTimer();
    }

    public void update() {
        car.update(hud);
        updateCustomers();

        if (hud.getTimeLeft() == 290 || car.getFuelLeft() == 0) {
            endGame();
        }

        // if (player click drive customer) carCloseEnough = car.checkIfCarCloseEnough(); if (carCloseEnough) car.pickUpCustomer(); customer.giveDirections();
        // 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Assets.townMap, 0, 0, 1600, 790, null);
        car.render(g);
        renderCustomers(g);
    }

    private void spawnPlayer() {
        car = new Car(game, 645, 680, 100, 110);
    }

    private void playBackgroundMusic() {
        Assets.gameBgMusic.play(-3.0f);
    }

    private void startCustomerSpawnTimer() {
        customerSpawnTimer = new Timer(CUSTOMER_SPAWN_RATE, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spawnCustomer();
                Assets.customerSpawnSFX.play(0);
            }
        });
        customerSpawnTimer.start();
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

    private void endGame() {
        game.stop();
        game.setState("end");
        hud.getTimeLeftTimer().stop();
        customerSpawnTimer.stop();
        Assets.gameBgMusic.stop();
    }

    public Car getCar() {
        return car;
    }

    public int getNumOfCustomersDriven() {
        return numOfCustomersDriven;
    }
}