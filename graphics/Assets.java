package graphics;

import java.awt.image.*;
import javax.swing.Icon;
import audio.AudioPlayer;

/**
 * The <code>Assets</code> class loads all assets of the game.
 * This includes all BufferedImages, Icons, and Audio. The attributes
 * of this class are allowed to be accessed anywhere.
 * 
 * @author Joshua Bautista
 * @version 1/14/2020
 */
public class Assets {

    /**
     * The town map image.
     */
    private static BufferedImage TOWN_MAP;
    /**
     * The drop off symbol image.
     */
    private static BufferedImage DROP_OFF_SYMBOL;
    /**
     * The pick up symbol image.
     */
    private static BufferedImage PICK_UP_SYMBOL;
    /**
     * Stores all customer images.
     */
    private static BufferedImage[] CUSTOMERS;
    /**
     * Stores all fare display images.
     */
    private static BufferedImage[] FARE_DISPLAY;
    /**
     * Stores the up, down, left, and right
     * images of the audi car.
     */
    private static BufferedImage[] AUDI;
    /**
     * The play button icon.
     */
    private static Icon PLAY_BUTTON_ICON;
    /**
     * The quit button icon.
     */
    private static Icon QUIT_BUTTON_ICON;
    /**
     * The settings button icon.
     */
    private static Icon SETTINGS_BUTTON_ICON;
    /**
     * The title icon.
     */
    private static Icon TITLE_ICON;
    /**
     * The play again button icon.
     */
    private static Icon PLAY_AGAIN_BUTTON_ICON;
    /**
     * The quit button displayed at the end
     * of the game.
     */
    private static Icon QUIT_END_BUTTON_ICON;
    /**
     * The menu background music.
     */
    private static AudioPlayer MENU_BG_MUSIC;
    /**
     * The game background music.
     */
    private static AudioPlayer GAME_BG_MUSIC;
    /**
     * The car doors close sound effect.
     */
    private static AudioPlayer CAR_DOORS_SFX;
    /**
     * The customer spawn sound effect.
     */
    private static AudioPlayer CUSTOMER_SPAWN_SFX;
    /**
     * The drop off sound effect.
     */
    private static AudioPlayer DROP_OFF_SFX;

    /**
     * Initializes all the assets.
     */
    public Assets() {
        initialize();
    }

    /**
     * Initializes and loads all assets.
     */
    private static void initialize() {
        // Car images
        AUDI = new BufferedImage[4];
        AUDI[0] = ImageLoader.loadImage("resources\\Vehicles\\AudiUp.png");
        AUDI[1] = ImageLoader.loadImage("resources\\Vehicles\\AudiRight.png");
        AUDI[2] = ImageLoader.loadImage("resources\\Vehicles\\AudiDown.png");
        AUDI[3] = ImageLoader.loadImage("resources\\Vehicles\\AudiLeft.png");

        // Town map background
        TOWN_MAP = ImageLoader.loadImage("resources\\HUD\\townmap.jpg");

        // Fare bubble icons
        FARE_DISPLAY = new BufferedImage[8];
        FARE_DISPLAY[0] = ImageLoader.loadImage("resources\\FareDisplay\\11.png");
        FARE_DISPLAY[1] = ImageLoader.loadImage("resources\\FareDisplay\\15.png");
        FARE_DISPLAY[2] = ImageLoader.loadImage("resources\\FareDisplay\\16.png");
        FARE_DISPLAY[3] = ImageLoader.loadImage("resources\\FareDisplay\\17.png");
        FARE_DISPLAY[4] = ImageLoader.loadImage("resources\\FareDisplay\\18.png");
        FARE_DISPLAY[5] = ImageLoader.loadImage("resources\\FareDisplay\\19.png");
        FARE_DISPLAY[6] = ImageLoader.loadImage("resources\\FareDisplay\\21.png");
        FARE_DISPLAY[7] = ImageLoader.loadImage("resources\\FareDisplay\\23.png");

        // Customer images
        CUSTOMERS = new BufferedImage[14];
        CUSTOMERS[0] = ImageLoader.loadImage("resources\\Customers\\cricketguy.png");
        CUSTOMERS[1] = ImageLoader.loadImage("resources\\Customers\\suitguy.png");
        CUSTOMERS[2] = ImageLoader.loadImage("resources\\Customers\\elder.png");
        CUSTOMERS[3] = ImageLoader.loadImage("resources\\Customers\\elder2.png");
        CUSTOMERS[4] = ImageLoader.loadImage("resources\\Customers\\millenial.png");
        CUSTOMERS[5] = ImageLoader.loadImage("resources\\Customers\\millenial2.png");
        CUSTOMERS[6] = ImageLoader.loadImage("resources\\Customers\\millenial3.png");
        CUSTOMERS[7] = ImageLoader.loadImage("resources\\Customers\\millenial4.png");
        CUSTOMERS[8] = ImageLoader.loadImage("resources\\Customers\\millenial5.png");
        CUSTOMERS[9] = ImageLoader.loadImage("resources\\Customers\\millenial6.png");
        CUSTOMERS[10] = ImageLoader.loadImage("resources\\Customers\\millenialgirl.png");
        CUSTOMERS[11] = ImageLoader.loadImage("resources\\Customers\\millenialgirl2.png");
        CUSTOMERS[12] = ImageLoader.loadImage("resources\\Customers\\millenialgirl3.png");
        CUSTOMERS[13] = ImageLoader.loadImage("resources\\Customers\\millenialgirl4.png");

        // Icons & Hud
        TITLE_ICON = ImageLoader.loadIcon("resources\\Menu\\title.PNG");
        PLAY_BUTTON_ICON = ImageLoader.loadIcon("resources\\Menu\\playbutton.png");
        QUIT_BUTTON_ICON = ImageLoader.loadIcon("resources\\Menu\\quitbutton.png");
        SETTINGS_BUTTON_ICON = ImageLoader.loadIcon("resources\\HUD\\settingsbutton.png");
        PLAY_AGAIN_BUTTON_ICON = ImageLoader.loadIcon("resources\\Menu\\playagainbutton.png");
        QUIT_END_BUTTON_ICON = ImageLoader.loadIcon("resources\\Menu\\quitbuttonend.png");
        DROP_OFF_SYMBOL = ImageLoader.loadImage("resources\\HUD\\dropoffsymbol.png");
        PICK_UP_SYMBOL = ImageLoader.loadImage("resources\\HUD\\pickupsymbol.png");

        // SFX
        MENU_BG_MUSIC = new AudioPlayer("resources\\Music\\menubg.wav");
        GAME_BG_MUSIC = new AudioPlayer("resources\\Music\\gamebg.wav");
        DROP_OFF_SFX = new AudioPlayer("resources\\SFX\\dropoff.wav");
        CAR_DOORS_SFX = new AudioPlayer("resources\\SFX\\cardoors.wav");
        CUSTOMER_SPAWN_SFX = new AudioPlayer("resources\\SFX\\customerspawn.wav");
    }

    /**
     * Returns the <code>audi</code> car image.
     * 
     * @return the player's car image
     */
    public BufferedImage[] getAudi() {
        return AUDI;
    }

    /**
     * Returns the <code>townMap</code> image.
     * 
     * @return the townmap background
     */
    public BufferedImage getTownMap() {
        return TOWN_MAP;
    }

    /**
     * Returns the <code>pickUpSymbol</code> image.
     * 
     * @return the pick up symbol image
     */
    public BufferedImage getPickUpSymbol() {
        return PICK_UP_SYMBOL;
    }

    /**
     * Returns the <code>dropOffSymbol</code> image.
     * 
     * @return the drop off symbol image
     */
    public BufferedImage getDropOffSymbol() {
        return DROP_OFF_SYMBOL;
    }

    /**
     * Returns the <code>fareDisplay</code> image.
     * 
     * @return the fare display image
     */
    public BufferedImage[] getFareDisplay() {
        return FARE_DISPLAY;
    }

    /**
     * Returns the <code>customers</code> image array.
     * 
     * @return the customers image array
     */
    public BufferedImage[] getCustomers() {
        return CUSTOMERS;
    }

    /**
     * Returns the <code>titleIcon</code> icon.
     * 
     * @return the title icon 
     */
    public Icon getTitleIcon() {
        return TITLE_ICON;
    }

    /**
     * Returns the <code>playButtonIcon</code> icon.
     * 
     * @return the play button icon
     */
    public Icon getPlayButtonIcon() {
        return PLAY_BUTTON_ICON;
    }

    /**
     * Returns the <code>quitButtonIcon</code> icon.
     * 
     * @return the quit button icon
     */
    public Icon getQuitButtonIcon() {
        return QUIT_BUTTON_ICON;
    }

    /**
     * Returns the <code>settingsButtonIcon</code> icon. 
     * 
     * @return the settings button icon
     */
    public Icon getSettingsButtonIcon() {
        return SETTINGS_BUTTON_ICON;
    }

    /**
     * Returns the <code>playAgainButtonIcon</code> icon.
     * 
     * @return the play again button icon
     */
    public Icon getPlayAgainButtonIcon() {
        return PLAY_AGAIN_BUTTON_ICON;
    }

    /**
     * Returns the <code>quitEndButtonIcon</code> icon.
     * 
     * @return the quit end button icon
     */
    public Icon getQuitEndButtonIcon() {
        return QUIT_END_BUTTON_ICON;
    }

    /**
     * Returns the <code>menuBgMusic</code> AudioPlayer.
     * 
     * @return the menu background music audio player
     */
    public AudioPlayer getMenuBgMusic() {
        return MENU_BG_MUSIC;
    }

    /**
     * Returns the <code>gameBgMusic</code> AudioPlayer.
     * 
     * @return the game background music audio player
     */
    public AudioPlayer getGameBgMusic() {
        return GAME_BG_MUSIC;
    }

    /**
     * Returns the <code>dropOffSFX</code> AudioPlayer.
     * 
     * @return the drop off sound effect audio player
     */
    public AudioPlayer getDropOffSFX() {
        return DROP_OFF_SFX;
    }

    /**
     * Returns the <code>carDoorsSFX</code> AudioPlayer.
     * 
     * @return the car doors sound effect audio player
     */
    public AudioPlayer getCarDoorsSFX() {
        return CAR_DOORS_SFX;
    }

    /**
     * Returns the <code>customerSpawnSFX</code> AudioPlayer.
     * 
     * @return the customer spawn sound effect audio player
     */
    public AudioPlayer getCustomerSpawnSFX() {
        return CUSTOMER_SPAWN_SFX;
    }
}