package main;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import entities.Car;
import entities.Customer;

/**
 * The <code>GamePanel</code> class is responsible for displaying 
 * the main game to the user. This includes the drivable <code>Car</code> 
 * interacting with the town and customers. The main drawing of the game
 * is done here. The overall game logic is stored in this class.
 * 
 * @author Joshua Bautista
 * @version 1/14/2020
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel {

    /**
     * The <code>Game</code> object to be communicated with.
     */
    private Game game;
    /**
     * The <code>Hud</code> object to be communicated with.
     */
    private Hud hud;

    /**
     * An <code>Customer</code> array that contains all of the customers.
     */
    private Customer[] customers;
    /**
     * The <code>Car</code> object that represents the player.
     */
    private Car car;
    /**
     * The <code>RoadBounds</code> object that represents the bounds of all the roads.
     */
    private RoadBounds roadBounds;
    /**
     * A <code>Timer</code> object that keeps track of how often a customer is spawned.
     */
    private Timer customerSpawnTimer;

    /**
     * An int representing the highest fare paid by a customer.
     */
    private int highestFarePaid = 0;
    /**
     * An int representing the total number of customers driven by the player.
     */
    private int numOfCustomersDriven = 0;
    /**
     * An int array that contains all of the possible fares the customers can pay.
     */
    private final int[] POSSIBLE_FARES = {11, 15, 16, 17, 18, 19, 21, 23};
    /**
     * An int representing the rate at which the customers spawn in.
     */
    private final int CUSTOMER_SPAWN_RATE = 20000; // 20 seconds

    /**
     * An ArrayList that contains all of the names of the customers.
     */
    private final ArrayList<String> CUSTOMER_NAMES = new ArrayList<String>(Arrays.asList("Avery", "Payton", 
                                                    "Quinn", "Hayden", "Sage", "Rylan", "Eden", "Elliott", "Shane", 
                                                    "Ariel", "Kyrie", "Lyric", "Finley", "Morgan"));

    /**
     * An int array representing the possible spawn locations
     * the customers can spawn at.
     */
    private final int[][] SPAWN_LOCATIONS = {{183, 55}, {383, 492}, {1080, 49}, {1226, 549}, {468, 165}, 
                                             {962, 549}, {858, 55}, {54, 55}, {1037, 233}, {1100, 550},
                                             {451, 282}, {758, 49}, {928, 390}, {1218, 220}};

    /**
     * An int array representing the possible destination locations
     * the customers can request to be dropped off at.
     */
    private final int[][] DESTINATION_LOCATIONS = {{1347, 251}, {34, 513}, {44, 173}, {1175, 513}, {567, 172}, 
                                                   {607, 511}, {853, 610}, {1056, 753}, {692, 287}, {1439, 65},
                                                   {1347, 175}, {243, 513}, {459, 51}, {854, 358}};
    private final ArrayList<int[]> POSSIBLE_SPAWN_LOCATIONS = new ArrayList<int[]>(14);
    private final ArrayList<int[]> POSSIBLE_DESTINATION_LOCATIONS = new ArrayList<int[]>(14);
    
    /**
     * Creates the GamePanel.
     * 
     * @param game the <code>Game</code> object to be communicated with
     */
    public GamePanel(Game game) {
        this.game = game;
        this.hud = game.getHud();
        roadBounds = new RoadBounds();
        addKeyListener(game.getKeyManager());
        setFocusable(true);
        setPreferredSize(new Dimension(1600, 790));
        playBackgroundMusic(-10.0f);

        spawnPlayer();

        initializeCustomers();
        spawnCustomer();
        startCustomerSpawnTimer();
    }

    /**
     * This method is called every frame to update
     * all game variables and objects.
     */
    public void update() {
        car.update(hud);

        stopCarIfCollidesWithRoad();

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

        if (hud.getTimeLeft() == 0 || car.getFuelLeft() <= 0) {
            endGame();
        }
    }

    /**
     * Paints/draws all the assets to the screen.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(game.getAssets().getTownMap(), 0, 0, 1600, 790, null);

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

    /**
     * Checks if the <code>Car</code> has collided with
     * the <code>RoadBounds</code> rectangles.
     */
    private void stopCarIfCollidesWithRoad() {
        Rectangle[] bounds = roadBounds.getBounds();
        Rectangle carBounds = car.getCollisionBounds();
        
        for (Rectangle bound : bounds) {
            if (bound.intersects(carBounds)) {
                if (car.getxMove() > 0) { // right
                    car.setxMove(0);
                    car.setXPos(car.getXPos() - 3);
                } if (car.getxMove() < 0) { // left
                    car.setxMove(0);
                    car.setXPos(car.getXPos() + 3);
                } if (car.getyMove() > 0) { // down
                    car.setyMove(0);
                    car.setYPos(car.getYPos() - 3);
                } if (car.getyMove() < 0) { // up
                    car.setyMove(0);
                    car.setYPos(car.getYPos() + 3);
                }
            }
        }
    }

    /**
     * Spawns in the player's <code>Car</code>.
     */
    private void spawnPlayer() {
        car = new Car(game, 645, 680, 100, 110);
    }

    /**
     * Plays the background music.
     * 
     * @param volume a float representing how load
     * the background music is to be played
     */
    private void playBackgroundMusic(float volume) {
        game.getAssets().getGameBgMusic().play(volume);
    }

    /**
     * Initializes and starts the customer spawn timer.
     */
    private void startCustomerSpawnTimer() {
        customerSpawnTimer = new Timer(CUSTOMER_SPAWN_RATE, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spawnCustomer();
            }
        });
        customerSpawnTimer.start();
    }

    /**
     * Generates a random index from 0 to a 
     * specified number.
     * 
     * @param max the maximum range to be generated
     */
    private int generateRandomIndex(int max) {
        int randomIndex = (int) (Math.random() * (max));
        return randomIndex;
    }

    /**
     * Simulating "spawning in" a <code>Customer</code> by 
     * making them visible.
     */
    private void spawnCustomer() {
        int randomIndex = generateRandomIndex(10);
        if (customers[randomIndex].getIsVisible() == true) {
            spawnCustomer();
        }
        customers[randomIndex].setIsVisible(true);
        game.getAssets().getCustomerSpawnSFX().play(0);
    }

    /**
     * Initializes all <code>Customer</code>'s.
     */
    private void initializeCustomers() {
        customers = new Customer[14];
        for (int i = 0; i < 14; i++) {
            int randomFareIndex = generateRandomIndex(8);

            sortCustomerNamesAlphabetically();

            int[] randomLocation = new int[2];
            randomLocation = selectRandomLocation();

            int[] randomDestination = selectRandomDestination();

            customers[i] = new Customer(game, CUSTOMER_NAMES.get(i), randomLocation[0], randomLocation[1], 60, 100, POSSIBLE_FARES[randomFareIndex], 
                                        game.getAssets().getFareDisplay()[randomFareIndex], game.getAssets().getCustomers()[i], randomDestination);
        }
    }

    /**
     * 
     */
    private void sortCustomerNamesAlphabetically() {
        sortAlphabeticallyUsingInsertionSort(CUSTOMER_NAMES);
    }

    private void sortAlphabeticallyUsingInsertionSort(ArrayList<String> CUSTOMER_NAMES) {
        for (int i = 1; i < CUSTOMER_NAMES.size(); i++) {
            String key = CUSTOMER_NAMES.get(i);
            int j = i - 1;

            while (j >= 0 && key.compareTo(CUSTOMER_NAMES.get(j)) < 0) {
                CUSTOMER_NAMES.set(j + 1, CUSTOMER_NAMES.get(j));
                j--;
            }
            CUSTOMER_NAMES.set(j + 1, key);
        }
    }

    private int[] selectRandomLocation() {
        int randomIndex = generateRandomIndex(14);

        if ((SPAWN_LOCATIONS[randomIndex] != null)) {
            int[] randomSpawnLocation = {SPAWN_LOCATIONS[randomIndex][0], SPAWN_LOCATIONS[randomIndex][1]};
            SPAWN_LOCATIONS[randomIndex] = null;
            return randomSpawnLocation;
        } else {
            return selectRandomLocation();
        }
    }

    private int[] selectRandomDestination() {
        int randomIndex = generateRandomIndex(14);

        if ((DESTINATION_LOCATIONS[randomIndex] != null)) {
            int[] randomDestination = DESTINATION_LOCATIONS[randomIndex];
            DESTINATION_LOCATIONS[randomIndex] = null;
            return randomDestination;
        } else {
            return selectRandomDestination();
        }
    }

    private void endGame() {
        game.setCurrentState("end");
        hud.getTimeLeftTimer().stop();
        customerSpawnTimer.stop();
        game.getAssets().getGameBgMusic().stop();
    }

    public Car getCar() {
        return car;
    }

    public void addNumOfCustomersDriven(int numOfCustomersDrivenToAdd) {
        numOfCustomersDriven += numOfCustomersDrivenToAdd;
    }

    public int getNumOfCustomersDriven() {
        return numOfCustomersDriven;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public int getHighestFarePaid() {
        return highestFarePaid;
    }

    public void setHighestFarePaid(int highestFarePaid) {
        this.highestFarePaid = highestFarePaid;
    }
}