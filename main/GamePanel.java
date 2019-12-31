package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import audio.AudioPlayer;
import entities.Car;
import graphics.Assets;

public class GamePanel extends JPanel implements MouseListener, MouseMotionListener {

    private BufferedImage townMap;
    private Car car;

    public GamePanel() {
        addMouseListener(this);
        addMouseMotionListener(this);
        townMap = Assets.townMap;
        setPreferredSize(new Dimension(1200, 1000));
        Assets.gameBgMusic.play();
        Assets.carDoorsSFX.play();
        car = new Car(100, 100);
    }

    public void update() {
        car.update();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(townMap, 0, 0, 1200, 1000, null);
        car.render(g);
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println(e.getX() + " " + e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}