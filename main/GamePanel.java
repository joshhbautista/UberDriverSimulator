package main;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private int highestFarePaid;
    /**
     * An int representing the total number of customers driven by the player.
     */
    private int numOfCustomersDriven;
    /**
     * An int array that contains all of the possible fares the customers can pay.
     */
    private final int[] POSSIBLE_FARES = {11, 15, 16, 17, 18, 19, 21, 23};
    /**
     * An int representing the rate at which the customers spawn in.
     */
    private final int CUSTOMER_SPAWN_RATE = 20000; // 20 seconds

    /**
     * An String array that contains all of the names of the customers.
     */
    private String[] customerNames = {"Avery", "Payton", "Quinn", "Hayden", "Sage", "Rylan", 
                                        "Eden", "Elliott", "Shane", "Ariel", "Kyrie", "Lyric", 
                                        "Finley", "Morgan"};

    /**
     * An 2D int array representing the possible spawn locations
     * the customers can spawn at.
     */
    private final int[][] SPAWN_LOCATIONS = {{183, 55}, {383, 492}, {1080, 49}, {1226, 549}, {468, 165}, 
                                             {962, 549}, {858, 55}, {54, 55}, {1037, 233}, {1100, 550},
                                             {451, 282}, {758, 49}, {928, 390}, {1218, 220}};

    /**
     * An 2D int array representing the possible destination locations
     * the customers can request to be dropped off at.
     */
    private final int[][] DESTINATION_LOCATIONS = {{1347, 251}, {34, 513}, {44, 173}, {1175, 513}, {567, 172}, 
                                                   {607, 511}, {853, 610}, {1056, 753}, {692, 287}, {1439, 65},
                                                   {1347, 175}, {243, 513}, {459, 51}, {854, 358}};
    
    /**
     * Creates the GamePanel and initializes all game objects.
     * 
     * @param game the <code>Game</code> object to be communicated with
     */
    public GamePanel(Game game) {
        this.game = game;
        this.hud = game.getHud();
        this.roadBounds = new RoadBounds();
        highestFarePaid = 0;
        numOfCustomersDriven = 0;
        addKeyListener(game.getKeyManager());
        setFocusable(true);
        setPreferredSize(new Dimension(1600, 790));
        playBackgroundMusic(2.0f);

        initializeCustomers();
        spawnPlayer();
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

        updateCustomers();

        if (hud.getTimeLeft() == 0 || car.getFuelLeft() <= 0) {
            endGame();
        }
    }

    private void updateCustomers() {
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
        customers[10].update(hud);
        customers[11].update(hud);
        customers[12].update(hud);
        customers[13].update(hud);
    }

    /**
     * Paints/draws all the assets to the screen.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(game.getAssets().getTownMap(), 0, 0, 1600, 790, null);

        car.render(g);

        renderCustomers(g);
    }

    private void renderCustomers(Graphics g) {
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
        customers[10].render(g);
        customers[11].render(g);
        customers[12].render(g);
        customers[13].render(g);
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
        game.getAssets().getCustomerSpawnSFX().play(5);
    }

    /**
     * Initializes all <code>Customer</code>'s.
     */
    private void initializeCustomers() {
        customers = new Customer[14];
        for (int i = 0; i < 14; i++) {
            int randomFareIndex = generateRandomIndex(8);

            sortCustomerNamesAlphabeticallyUsingInsertion();

            int[] randomLocation = new int[2];
            randomLocation = selectRandomLocation();

            int[] randomDestination = selectRandomDestination();

            customers[i] = new Customer(game, customerNames[i], randomLocation[0], randomLocation[1], 60, 100, POSSIBLE_FARES[randomFareIndex], 
                                        game.getAssets().getFareDisplay()[randomFareIndex], game.getAssets().getCustomers()[i], randomDestination);
        }
    }

    /**
     * Sorts the <code>customerNames</code> String array 
     * alphabetically using the insertion sort algorithm.
     */
    private void sortCustomerNamesAlphabeticallyUsingInsertion() {
        for (int i = 1; i < customerNames.length; i++) {
            String key = customerNames[i];
            int j = i - 1;

            while (j >= 0 && key.compareTo(customerNames[j]) < 0) {
                customerNames[j + 1] = customerNames[j];
                j--;
            }
            customerNames[j + 1] = key;
        }
    }

    /**
     * Randomly returns a location from the <code>SPAWN_LOCATIONS</code>
     * int[] array. Once returned, sets that index in the array as null as to not reuse that
     * location again, ensuring that all of the customers locations are unique.
     * 
     * @return an int array representing a random location from <code>SPAWN_LOCATIONS</code>
     */
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

    /**
     * Randomly returns a destination from the <code>DESTINATION_LOCATIONS</code>
     * int[] array. Once returned, sets that index in the array as null as to not reuse that
     * location again, ensuring that all of the customers destination locations are unique.
     * 
     * @return an int array representing a random destination from <code>DESTINATION_LOCATIONS</code>
     */
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

    /**
     * Ends the current game by setting the game's current
     * state to "end" and stopping all timers and music.
     */
    private void endGame() {
        game.setCurrentState("end");
        hud.getTimeLeftTimer().stop();
        customerSpawnTimer.stop();
        game.getAssets().getGameBgMusic().stop();
    }

    /**
     * Returns the <code>Car</code> object of this Game.
     * 
     * @return a <code>Car</code> object the player is driving
     */
    public Car getCar() {
        return car;
    }

    /**
     * Adds a specified number to the <code>numOfCustomersDriven</code>
     * property.
     * 
     * @param numOfCustomersDrivenToAdd the number of customers driven to add
     */
    public void addNumOfCustomersDriven(int numOfCustomersDrivenToAdd) {
        numOfCustomersDriven += numOfCustomersDrivenToAdd;
    }

    /**
     * Returns the <code>numOfCustomerDriven</code> property of this Game.
     * 
     * @return an int representing the total number of customers driven
     */
    public int getNumOfCustomersDriven() {
        return numOfCustomersDriven;
    }

    /**
     * Returns the <code>customers</code> Customer array of this Game.
     * 
     * @return a Customer array that contains all of the customers
     */
    public Customer[] getCustomers() {
        return customers;
    }

    /**
     * Returns the <code>highestFarePaid</code> property of this Game.
     * 
     * @return an int representing the highest fare paid by the customer
     */
    public int getHighestFarePaid() {
        return highestFarePaid;
    }

    /**
     * Sets the highest fare paid by a customer.
     * 
     * @param highestFarePaid an int representing the highest fare
     * paid by a customer
     */
    public void setHighestFarePaid(int highestFarePaid) {
        this.highestFarePaid = highestFarePaid;
    }
}