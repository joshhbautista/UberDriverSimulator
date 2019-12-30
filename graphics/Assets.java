package graphics;

import java.awt.image.*;
import graphics.*;

/**
 * Initalizes all assets
 */
public class Assets {

    private static final int width = 32, height = 32;

    public static BufferedImage car, townMap, menu, customer;
    public static BufferedImage[] startButtons;

    public static void init() {
        SpriteSheet tutSheet = new SpriteSheet(ImageLoader.loadImage("resources\\tutsheet.png"));
        menu = ImageLoader.loadImage("resources\\Backgrounds\\menubg.gif");
        car = ImageLoader.loadImage("resources\\Sprites\\Player\\playersprites.gif");
        customer = ImageLoader.loadImage("resources\\Sprites\\Enemies\\arachnik.gif");


        // Load all assets from spritesheet here
        startButtons = new BufferedImage[2];
        startButtons[0] = tutSheet.crop(width * 6, height * 4, 64, 32);
        startButtons[1] = tutSheet.crop(width * 6, height * 5, 64, 32);

        //menu = sheet.crop(0, 0, width, height);
    }
}