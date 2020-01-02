package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import audio.AudioPlayer;
import entities.Car;
import entities.Customer;
import graphics.Assets;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements MouseListener, KeyListener {

    private Game game;

    private BufferedImage townMap;
    private Car car;
    private Customer customer;

    private Timer timeLeftTimer;
    private int timeLeftInSecs;
    private String timeLeftStr;

    private Hud hud;

    private Graphics g;

    public GamePanel(Game game) {
        this.game = game;
        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);
        townMap = Assets.townMap;
        setPreferredSize(new Dimension(1600, 900));
        Assets.gameBgMusic.play();
        Assets.carDoorsSFX.play();
        car = new Car(game, 100, 100);
        customer = new Customer(300, 300);
        timeLeftInSecs = 300;

        // ----------------- Timer ------------------------- //
        timeLeftTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeLeftInSecs--;
                timeLeftStr = String.format("%d:%02d", timeLeftInSecs / 60, timeLeftInSecs % 60);
                hud.getTimeLeftLabel().setText("Time Left: " + timeLeftStr);
            }
        });
        timeLeftTimer.start();
    }

    public void update(Hud hud) {
        this.hud = hud;
        car.update(hud);
        customer.update(hud);

        if (timeLeftInSecs == 0) {

        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(townMap, 0, 0, 1600, 790, null);
        car.render(g);
        customer.render(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println(e.getX() + " " + e.getY());

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {

        // ---------------------- Car Movement ------------------------ \\
        if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
            car.setFuelLeft(car.getFuelLeft() - 0.1);
            car.setY(car.getY() - 5);
        }
        if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
            car.setFuelLeft(car.getFuelLeft() - 0.1);
            car.setY(car.getY() + 5);
        }
        if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
            car.setFuelLeft(car.getFuelLeft() - 0.1);
            car.setX(car.getX() - 5);
        }
        if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            car.setFuelLeft(car.getFuelLeft() - 0.1);
            car.setX(car.getX() + 5);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

}