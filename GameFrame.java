import javax.swing.JFrame;
import java.awt.*;

public class GameFrame {

    private static JFrame frame;
    private static Canvas canvas;

    private String title;
    private final int WIDTH = 880;
    private final int HEIGHT = 1280;

    public GameFrame(String title) {
        this.title = title;

        createFrame(title, WIDTH, HEIGHT);
    }

    public static void createFrame(String title, int width, int height) {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));

        frame.add(canvas);
        frame.pack();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public JFrame getFrame() {
        return frame;
    }
}