package main;

import java.math.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import entities.Car;
import entities.Customer;
import graphics.Assets;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements MouseListener {

    private Game game;
    private Hud hud;

    private Customer customer1, customer2, customer3, customer4, customer5, customer6, customer7, customer8, customer9, customer10;
    private Car car;
    private Timer customerSpawnTimer;

    private int numOfCustomersDriven = 0;

    private int numOfCustomersSpawned = 0;
    private final int CUSTOMER_SPAWN_RATE = 30000; // 30 seconds
    private final int[][] SPAWN_LOCATIONS = {{183, 152}, {383, 592}, {1157, 139}, {1226, 649}, {468, 265}, 
                                            {962, 649}, {858, 150}, {74, 153}, {1108, 325}, {1191, 650}};

    public GamePanel(Game game) {
        this.game = game;
        this.hud = game.getHud();
        addKeyListener(game.getKeyManager());
        addMouseListener(this);
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

        if (hud.getTimeLeft() == 240 || car.getFuelLeft() == 0) {
            endGame();
        }

        // if (player click drive customer) carCloseEnough =
        // car.checkIfCarCloseEnough(); if (carCloseEnough) car.pickUpCustomer();
        // customer.giveDirections();
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

    private int[] selectRandomSpawnLocation() {
        int randomIndex = (int) (Math.random() * 10);

        if ((SPAWN_LOCATIONS[randomIndex] != null)) {
            int[] randomSpawnLocation = {SPAWN_LOCATIONS[randomIndex][0], SPAWN_LOCATIONS[randomIndex][1]};
            return randomSpawnLocation;
        }
        return null;
    }

    private void spawnCustomer() {
        int[] randomSpawnLocation = new int[2];
        randomSpawnLocation = selectRandomSpawnLocation();
        if (numOfCustomersSpawned == 0) {
            customer1 = new Customer(randomSpawnLocation[0], randomSpawnLocation[1], 60, 100, 16, Assets.fareDisplay[1]);
            numOfCustomersSpawned++;
        } else if (numOfCustomersSpawned == 1) {
            customer2 = new Customer(randomSpawnLocation[0], randomSpawnLocation[1], 60, 100, 5, Assets.fareDisplay[1]);
            numOfCustomersSpawned++;
        } else if (numOfCustomersSpawned == 2) {
            customer3 = new Customer(randomSpawnLocation[0], randomSpawnLocation[1], 60, 100, 5, Assets.fareDisplay[1]);
            numOfCustomersSpawned++;
        } else if (numOfCustomersSpawned == 3) {
            customer4 = new Customer(randomSpawnLocation[0], randomSpawnLocation[1], 60, 100, 5, Assets.fareDisplay[1]);
            numOfCustomersSpawned++;
        } else if (numOfCustomersSpawned == 4) {
            new Customer(randomSpawnLocation[0], randomSpawnLocation[1], 60, 100, 5, Assets.fareDisplay[1]);
            numOfCustomersSpawned++;
        } else if (numOfCustomersSpawned == 5) {
            new Customer(randomSpawnLocation[0], randomSpawnLocation[1], 60, 100, 5, Assets.fareDisplay[1]);
            numOfCustomersSpawned++;
        } else if (numOfCustomersSpawned == 6) {
            new Customer(randomSpawnLocation[0], randomSpawnLocation[1], 60, 100, 5, Assets.fareDisplay[1]);
            numOfCustomersSpawned++;
        } else if (numOfCustomersSpawned == 7) {
            new Customer(randomSpawnLocation[0], randomSpawnLocation[1], 60, 100, 5, Assets.fareDisplay[1]);
            numOfCustomersSpawned++;
        } else if (numOfCustomersSpawned == 8) {
            new Customer(randomSpawnLocation[0], randomSpawnLocation[1], 60, 100, 5, Assets.fareDisplay[1]);
            numOfCustomersSpawned++;
        } else {
            new Customer(randomSpawnLocation[0], randomSpawnLocation[1], 60, 100, 5, Assets.fareDisplay[1]);
            numOfCustomersSpawned++;
        }
    }

    private void updateCustomers() {
        if (numOfCustomersSpawned == 1) {
            customer1.update(hud);
        } else if (numOfCustomersSpawned == 2) {
            customer1.update(hud);
            customer2.update(hud);
        } else if (numOfCustomersSpawned == 3) {
            customer1.update(hud);
            customer2.update(hud);
            customer3.update(hud);
        } else if (numOfCustomersSpawned == 4) {
            customer1.update(hud);
            customer2.update(hud);
            customer3.update(hud);
            customer4.update(hud);
        }
        if (numOfCustomersSpawned == 5)
        if (numOfCustomersSpawned == 6)
        if (numOfCustomersSpawned == 7)
        if (numOfCustomersSpawned == 8)
        if (numOfCustomersSpawned == 9)
        if (numOfCustomersSpawned == 10);
    }

    private void renderCustomers(Graphics g) {
        if (numOfCustomersSpawned == 1) {
            customer1.render(g);
        } else if (numOfCustomersSpawned == 2) {
            customer1.render(g);
            customer2.render(g);
        } else if (numOfCustomersSpawned == 3)
            customer1.render(g);
            customer2.render(g);
            customer3.render(g);
        if (numOfCustomersSpawned == 4) {
            customer1.render(g);
            customer2.render(g);
            customer3.render(g);
            customer4.render(g);
        } else if (numOfCustomersSpawned == 5)
        if (numOfCustomersSpawned == 6)
        if (numOfCustomersSpawned == 7)
        if (numOfCustomersSpawned == 8)
        if (numOfCustomersSpawned == 9)
        if (numOfCustomersSpawned == 10);
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

    @Override
    public void mouseClicked(MouseEvent e) {
        JOptionPane.showMessageDialog(null, "X: " + e.getX() + " Y: " + e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}