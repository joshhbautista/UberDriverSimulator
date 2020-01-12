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
    public static Icon playButton, quitButton, settingsButton, title, playAgainButton, quitEndButton;
    public static AudioPlayer menuBgMusic, gameBgMusic, carDoorsSFX, customerSpawnSFX, dropOffSFX;

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


        // Load all assets from spritesheet here


    }
}