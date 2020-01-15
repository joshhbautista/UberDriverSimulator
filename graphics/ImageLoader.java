package graphics;

import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * The <code>ImageLoader</code> class load images.
 * 
 * @author Joshua Bautista
 * @version 1/14/2020
 */
public class ImageLoader {

    /**
     * Loads images with the specified path.
     * 
     * @param path the path of the image
     * @return the <code>BufferedImage</code> of the image
     */
    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Loads icons with the specified path.
     * 
     * @param path the path of the icon
     * @return the <code>Icon</code> of the icon
     */
    public static Icon loadIcon(String path) {
        try {
            return new ImageIcon(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}