package graphics;

import java.awt.image.*;
import javax.swing.Icon;
import audio.AudioPlayer;

/**
 * Initalizes assets
 */
public class Assets {

    public static BufferedImage townMap, dropOffSymbol, pickUpSymbol;
    public static BufferedImage[] statButtons, customers, fareDisplay, audi;
    public static Icon playButton, quitButton, settingsButton, title;
    public static AudioPlayer menuBgMusic, gameBgMusic, carDoorsSFX, customerSpawnSFX;

    public static void init() {
        // Images
        //SpriteSheet tutSheet = new SpriteSheet(ImageLoader.loadImage("resources\\tutsheet.png"));
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
        customers = new BufferedImage[10];
        customers[0] = ImageLoader.loadImage("resources\\Customers\\cricketguy.png");
        customers[1] = ImageLoader.loadImage("resources\\Customers\\elon.png");

        // Icons & Hud
        title = ImageLoader.loadIcon("resources\\Menu\\title.PNG");
        playButton = ImageLoader.loadIcon("resources\\Menu\\playbutton.png");
        quitButton = ImageLoader.loadIcon("resources\\Menu\\quitbutton.png");
        settingsButton = ImageLoader.loadIcon("resources\\HUD\\settingsbutton.png");
        dropOffSymbol = ImageLoader.loadImage("resources\\HUD\\dropoffsymbol.png");
        pickUpSymbol = ImageLoader.loadImage("resources\\HUD\\pickupsymbol.png");

        // SFX
        menuBgMusic = new AudioPlayer("resources\\Music\\menubg.wav");
        gameBgMusic = new AudioPlayer("resources\\Music\\gamebg.wav");
        carDoorsSFX = new AudioPlayer("resources\\SFX\\cardoors.wav");
        customerSpawnSFX = new AudioPlayer("resources\\SFX\\customerspawn.wav");


        // Load all assets from spritesheet here


    }
}