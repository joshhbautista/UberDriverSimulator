package main;

import javax.swing.JFrame;
import java.awt.*;

public class GameFrame {

    private static JFrame frame;
    private static Canvas canvas;

    private String title;
    private final int WIDTH = 1200;
    private final int HEIGHT = 1000;

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
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public JFrame getFrame() {
        return frame;
    }

}