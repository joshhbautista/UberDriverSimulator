package graphics;

import java.awt.image.*;
import javax.swing.Icon;
import audio.AudioPlayer;

/**
 * The <code>Assets</code> class loads all assets of the game.
 * This includes all BufferedImages, Icons, and Audio. The attributes
 * of this class are allowed to be accessed anywhere.
 */
public class Assets {

    // TODO make this static or use getters?

    /**
     * The town map image.
     */
    public static BufferedImage townMap;
    /**
     * The drop off symbol image.
     */
    public static BufferedImage dropOffSymbol;
    /**
     * The pick up symbol image.
     */
    public static BufferedImage pickUpSymbol;
    /**
     * Stores the play again and quit button displayed
     * on the EndGameFrame.
     */
    public static BufferedImage[] statButtons;
    /**
     * Stores all customer images.
     */
    public static BufferedImage[] customers;
    /**
     * Stores all fare display images.
     */
    public static BufferedImage[] fareDisplay;
    /**
     * Stores the up, down, left, and right
     * images of the audi car.
     */
    public static BufferedImage[] audi;
    /**
     * The play button icon.
     */
    public static Icon playButton;
    /**
     * The quit button icon.
     */
    public static Icon quitButton;
    /**
     * The settings button icon.
     */
    public static Icon settingsButton;
    /**
     * The title icon.
     */
    public static Icon title;
    /**
     * The play again button icon.
     */
    public static Icon playAgainButton;
    /**
     * The quit button displayed at the end
     * of the game.
     */
    public static Icon quitEndButton;
    /**
     * The menu background music.
     */
    public static AudioPlayer menuBgMusic;
    /**
     * The game background music.
     */
    public static AudioPlayer gameBgMusic;
    /**
     * The car doors close sound effect.
     */
    public static AudioPlayer carDoorsSFX;
    /**
     * The customer spawn sound effect.
     */
    public static AudioPlayer customerSpawnSFX;
    /**
     * The drop off sound effect.
     */
    public static AudioPlayer dropOffSFX;

    /**
     * Initializes and loads all assets.
     */
    public static void init() {

        // Car images
        audi = new BufferedImage[4];
        audi[0] = ImageLoader.loadImage("resources\\Vehicles\\AudiUp.png");
        audi[1] = ImageLoader.loadImage("resources\\Vehicles\\AudiRight.png");
        audi[2] = ImageLoader.loadImage("resources\\Vehicles\\AudiDown.png");
        audi[3] = ImageLoader.loadImage("resources\\Vehicles\\AudiLeft.png");
        townMap = ImageLoader.loadImage("resources\\townmap.jpg");

        // Fare bubble icons
        fareDisplay = new BufferedImage[8];
        fareDisplay[0] = ImageLoader.loadImage("resources\\FareDisplay\\11.png");
        fareDisplay[1] = ImageLoader.loadImage("resources\\FareDisplay\\15.png");
        fareDisplay[2] = ImageLoader.loadImage("resources\\FareDisplay\\16.png");
        fareDisplay[3] = ImageLoader.loadImage("resources\\FareDisplay\\17.png");
        fareDisplay[4] = ImageLoader.loadImage("resources\\FareDisplay\\18.png");
        fareDisplay[5] = ImageLoader.loadImage("resources\\FareDisplay\\19.png");
        fareDisplay[6] = ImageLoader.loadImage("resources\\FareDisplay\\21.png");
        fareDisplay[7] = ImageLoader.loadImage("resources\\FareDisplay\\23.png");

        // Customer images
        customers = new BufferedImage[14];
        customers[0] = ImageLoader.loadImage("resources\\Customers\\cricketguy.png");
        customers[1] = ImageLoader.loadImage("resources\\Customers\\suitguy.png");
        customers[2] = ImageLoader.loadImage("resources\\Customers\\elder.png");
        customers[3] = ImageLoader.loadImage("resources\\Customers\\elder2.png");
        customers[4] = ImageLoader.loadImage("resources\\Customers\\millenial.png");
        customers[5] = ImageLoader.loadImage("resources\\Customers\\millenial2.png");
        customers[6] = ImageLoader.loadImage("resources\\Customers\\millenial3.png");
        customers[7] = ImageLoader.loadImage("resources\\Customers\\millenial4.png");
        customers[8] = ImageLoader.loadImage("resources\\Customers\\millenial5.png");
        customers[9] = ImageLoader.loadImage("resources\\Customers\\millenial6.png");
        customers[10] = ImageLoader.loadImage("resources\\Customers\\millenialgirl.png");
        customers[11] = ImageLoader.loadImage("resources\\Customers\\millenialgirl2.png");
        customers[12] = ImageLoader.loadImage("resources\\Customers\\millenialgirl3.png");
        customers[13] = ImageLoader.loadImage("resources\\Customers\\millenial4.png");

        // Icons & Hud
        title = ImageLoader.loadIcon("resources\\Menu\\title.PNG");
        playButton = ImageLoader.loadIcon("resources\\HUD\\playbutton.png");
        quitButton = ImageLoader.loadIcon("resources\\HUD\\quitbutton.png");
        settingsButton = ImageLoader.loadIcon("resources\\HUD\\settingsbutton.png");
        playAgainButton = ImageLoader.loadIcon("resources\\Menu\\playagainbutton.png");
        quitEndButton = ImageLoader.loadIcon("resources\\Menu\\quitbuttonend.png");
        dropOffSymbol = ImageLoader.loadImage("resources\\HUD\\dropoffsymbol.png");
        pickUpSymbol = ImageLoader.loadImage("resources\\HUD\\pickupsymbol.png");

        // SFX
        menuBgMusic = new AudioPlayer("resources\\Music\\menubg.wav");
        gameBgMusic = new AudioPlayer("resources\\Music\\gamebg.wav");
        dropOffSFX = new AudioPlayer("resources\\SFX\\dropoff.wav");
        carDoorsSFX = new AudioPlayer("resources\\SFX\\cardoors.wav");
        customerSpawnSFX = new AudioPlayer("resources\\SFX\\customerspawn.wav");

    }
}