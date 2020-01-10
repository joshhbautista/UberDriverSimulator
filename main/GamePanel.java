package main;

import java.math.*;
import java.awt.Dimension;
import java.awt.Rectangle;
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

    private Customer[] customers;
    private Car car;
    private RoadBounds roadBounds;
    private Timer customerSpawnTimer;

    private int numOfCustomersDriven = 0;
    private final int[] POSSIBLE_FARES = {11, 15, 16, 17, 18, 19, 21, 23};

    private final int CUSTOMER_SPAWN_RATE = 10000; // 30 seconds
    private final int[][] SPAWN_LOCATIONS = {{183, 67}, {383, 492}, {1080, 67}, {1226, 549}, {468, 165}, 
                                             {962, 549}, {858, 67}, {54, 67}, {1037, 243}, {1191, 550}};
    private final int[][] DESTINATION_LOCATIONS = {{1347, 251}, {34, 513}, {44, 173}, {1175, 513}, {567, 172}, 
                                                   {607, 511}, {853, 610}, {1056, 753}, {692, 287}, {1509, 60}};

    public GamePanel(Game game) {
        this.game = game;
        this.hud = game.getHud();
        roadBounds = new RoadBounds();
        addKeyListener(game.getKeyManager());
        addMouseListener(this);
        setFocusable(true);
        setPreferredSize(new Dimension(1600, 790));
        playBackgroundMusic();

        initializeCustomers();
        spawnPlayer();
        spawnCustomer();

        startCustomerSpawnTimer();
    }

    public void update() {
        car.update(hud);
        checkCollision();
        customers[0].update(hud);
        customers[1].update(hud);
        customers[2].update(hud);
        customers[3].update(hud);
        customers[4].update(hud);
        customers[5].update(hud);
        customers[6].update(hud);
        customers[7].update(hud);
        customers[8].update(hud);
        customers[9].update(hud);

        if (hud.getTimeLeft() == 0 || car.getFuelLeft() == 0) {
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
        customers[0].render(g);
        customers[1].render(g);
        customers[2].render(g);
        customers[3].render(g);
        customers[4].render(g);
        customers[5].render(g);
        customers[6].render(g);
        customers[7].render(g);
        customers[8].render(g);
        customers[9].render(g);
    }

    private void checkCollision() {
        Rectangle[] bounds = roadBounds.getBounds();
        Rectangle carBounds = car.getCollisionBounds();
        
        for (Rectangle bound : bounds) {
            if (bound.intersects(carBounds)) {
                car.setX(car.getX() - 5);
                car.setY(car.getY() - 5);
            }
        }
    }

    private void spawnPlayer() {
        car = new Car(game, 645, 680, 100, 110);
    }

    private void playBackgroundMusic() {
        Assets.gameBgMusic.play(1.0f);
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

    private int generateRandomIndex(int max) {
        int randomIndex = (int) (Math.random() * max);
        return randomIndex;
    }

    private void spawnCustomer() {
        int randomIndex = generateRandomIndex(10);
        customers[randomIndex].setIsVisible(true);
    }

    private void initializeCustomers() {
        customers = new Customer[10];
        for (int i = 0; i < 10; i++) {
            int[] randomLocation = new int[2];
            randomLocation = selectRandomLocation();
            int randomFareIndex = generateRandomIndex(8); // cricket guy - 60, 100
            customers[i] = new Customer(randomLocation[0], randomLocation[1], 100, 250, POSSIBLE_FARES[randomFareIndex], Assets.fareDisplay[randomFareIndex]);
        }
    }

    private int[] selectRandomLocation() {
        int randomIndex = generateRandomIndex(10);

        if ((SPAWN_LOCATIONS[randomIndex] != null)) {
            int[] randomSpawnLocation = {SPAWN_LOCATIONS[randomIndex][0], SPAWN_LOCATIONS[randomIndex][1]};
            SPAWN_LOCATIONS[randomIndex] = null;
            return randomSpawnLocation;
        } else {
            return selectRandomLocation();
        }
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