package graphics;
import java.awt.*;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.*;

public class ImageLoader {

    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
