package graphics;

import java.awt.*;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ImageLoader {

    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Icon loadIcon(String path) {
        // TODO do i need try catch
        try {
            return new ImageIcon(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}