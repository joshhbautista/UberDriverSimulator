package graphics;
import java.awt.image.*;

/**
 * Initalizes all assets
 */
public class Assets {

    private static final int width = 580, height = 580;

    public static BufferedImage car, townMap, menu, customer;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("resources\\townmap.png"));
        menu = ImageLoader.loadImage("resources\\Backgrounds\\grassbg1.gif");
        car = ImageLoader.loadImage("resources\\Sprites\\Player\\playersprites.gif");
        customer = ImageLoader.loadImage("resources\\Sprites\\Enemies\\arachnik.gif");


        // Load all assets from spritesheet here
        townMap = sheet.crop(0, 0, width, height);
        //menu = sheet.crop(0, 0, width, height);
    }
}