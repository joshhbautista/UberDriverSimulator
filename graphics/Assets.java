package graphics;

import java.awt.image.*;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import audio.AudioPlayer;
import graphics.*;

/**
 * Initalizes assets
 */
public class Assets {

    private static final int width = 32, height = 32;

    public static BufferedImage car, townMap, menu;
    public static BufferedImage[] customers;
    public static Icon playButton, quitButton, settingsButton;
    public static BufferedImage[] startButtons;
    public static AudioPlayer menuBgMusic, gameBgMusic, carDoorsSFX;

    public static void init() {
        // Images
        SpriteSheet tutSheet = new SpriteSheet(ImageLoader.loadImage("resources\\tutsheet.png"));
        car = ImageLoader.loadImage("resources\\Vehicles\\Audi.png");
        townMap = ImageLoader.loadImage("resources\\townmap.jpg");

        customers = new BufferedImage[1];
        customers[0] = ImageLoader.loadImage("resources\\Customers\\cricketguy.png");

        // Icons
        playButton = ImageLoader.loadIcon("resources\\Menu\\playbutton.png");
        quitButton = ImageLoader.loadIcon("resources\\Menu\\quitbutton.png");
        settingsButton = ImageLoader.loadIcon("resources\\HUD\\settingsbutton.png");

        // SFX
        menuBgMusic = new AudioPlayer("resources\\Music\\menubg.wav");
        gameBgMusic = new AudioPlayer("resources\\Music\\gamebg.wav");
        carDoorsSFX = new AudioPlayer("resources\\SFX\\cardoors.wav");


        // Load all assets from spritesheet here


        //menu = sheet.crop(0, 0, width, height);
    }
}