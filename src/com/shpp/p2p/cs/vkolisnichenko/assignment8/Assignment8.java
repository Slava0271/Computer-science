package com.shpp.p2p.cs.vkolisnichenko.assignment8;

import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * The class in which the code for the mid-exam is implemented.
 * Implemented 10 10x10 squares in the center
 * of the screen and their physics
 */
public class Assignment8 extends WindowProgram {
    //Number of squares on the screen
    private static final int COUNT_OF_SQUARE = 10;
    //Length of squares
    private static final int SIZE_OF_SQUARE = 10;
    //Window length
    public static final int APPLICATION_WIDTH = 300;
    public static final int APPLICATION_HEIGHT = 300;
    //ten pixel
    private static final int TEN_PIXELS = 10;
    //Pause time
    private static final double PAUSE_TIME = 1000 / 48;
    //The sheet in which the squares are stored
    ArrayList<GObject> gObjects = new ArrayList<>();
    //The sheet in which the coordinates of the movement are stored
    ArrayList<Integer> xSpeed = new ArrayList<>();

    /**
     * A method in which a listener for clicks is added,
     * after which it draws squares and adds
     * a method for physics
     */
    @Override
    public void run() {
        addMouseListeners();
        drawAllSquares();
        physics();
    }

    /**
     * The method that is triggered
     * when you click on the screen
     *
     * @param e - event
     */
    @Override
    public void mousePressed(MouseEvent e) {
        moveSquares(e);
    }

    /**
     * The method that is triggered
     * when you click on the screen
     *
     * @param e - event
     */
    private void moveSquares(MouseEvent e) {
        if (getElementAt(e.getX(), e.getY()) != null) {
            GObject object = getElementAt(e.getX(), e.getY());
            gObjects.add(object);
            if (getElementAt(e.getX(), e.getY() + TEN_PIXELS) != null) {
                GObject object1 = getElementAt(e.getX(), e.getY() + TEN_PIXELS);
                gObjects.add(object1);
            }
            if (getElementAt(e.getX(), e.getY() - TEN_PIXELS) != null) {
                GObject object2 = getElementAt(e.getX(), e.getY() - TEN_PIXELS);
                gObjects.add(object2);
            }
        }
    }

    /**
     * A method that implements physics
     * for moving squares and checking for
     * collisions with walls
     */
    private void physics() {
        int dx = 2;
        int dy = 0;
        GObject object;
        while (true) {
            for (int i = 0; i < gObjects.size(); i++) {
                xSpeed.add(dx);
                object = gObjects.get(i);
                object.move(xSpeed.get(i), dy);
                if (theBallCollidedWithRightWall((GRect) object)) xSpeed.set(i, -xSpeed.get(i));
                if (theBallCollidedWithLeftWall((GRect) object)) xSpeed.set(i, -xSpeed.get(i));
            }
            pause(PAUSE_TIME);
        }
    }

    /**
     * Method in which 1 square is drawn
     *
     * @param x     - x coordinate
     * @param y     - y coordinate
     * @param size  - size square
     * @param color - color square
     * @return - square
     */
    private GRect square(double x, double y, double size, Color color) {
        GRect gRect = new GRect(x, y, size, size);
        gRect.setFilled(true);
        gRect.setFillColor(color);
        add(gRect);
        return gRect;
    }

    /**
     * Method in which 10 squares are
     * drawn in the center of the screen
     */
    private void drawAllSquares() {
        RandomGenerator randomGenerator = new RandomGenerator();
        int xCoordinate = getWidth() / 2 - SIZE_OF_SQUARE / 2;
        for (int i = 0; i < COUNT_OF_SQUARE; i++) {
            square(xCoordinate, 80 + (i * SIZE_OF_SQUARE), SIZE_OF_SQUARE, randomGenerator.nextColor());
        }
    }

    /**
     * Method that checks for collisions with the wall on the right
     *
     * @param object - square
     * @return - yes or no
     */
    private boolean theBallCollidedWithRightWall(GRect object) {
        return object.getX() - 10 >= getHeight();
    }

    /**
     * Method that checks for collisions with the wall on the left
     *
     * @param object - square
     * @return - yes or no
     */
    private boolean theBallCollidedWithLeftWall(GRect object) {
        return object.getX() <= 0;
    }

}
