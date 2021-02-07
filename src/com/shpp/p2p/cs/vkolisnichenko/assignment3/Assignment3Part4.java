package com.shpp.p2p.cs.vkolisnichenko.assignment3;

import acm.graphics.GRect;
import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.WindowProgram;
import java.awt.*;

//The class that draws the pyramid
public class Assignment3Part4 extends WindowProgram {
    //The coordinates that are responsible for the size of the window
    public static final int APPLICATION_WIDTH = 300;
    public static final int APPLICATION_HEIGHT = 300;
    //The coordinates that correspond to the block size
    public static final double BRICK_WIDTH = 50;
    public static final double BRICK_HEIGHT = 23;
    //A variable that is responsible for the number of blocks at the lower level
    public static int BRICKS_IN_BASE = 6;
    //The variables that are needed to build the pyramid
    int c = BRICKS_IN_BASE;
    int b = 0;
    double r =(6-BRICKS_IN_BASE);



    /**
     * The method that draws a window,
     * after which it draws a pyramid
     */
    @Override
    public void run() {
        drawWindow(getWidth(), getHeight());
        drawFullBrick();
    }

    /**
     * The method that draws the main window
     *
     * @param height - window height
     * @param width  - window width
     */
    private void drawWindow(int height, int width) {
        GRect g = new GRect(height, width);
        add(g);
    }

    /**
     * The method that draws 1 brick for the pyramid
     *
     * @param x      - brick in x coordinate
     * @param y      - brick in y coordinate
     * @param width  - pyramid width
     * @param height - pyramid height
     */
    private void drawBrick(double x, double y, double width, double height) {
        GRect g = new GRect(x, y, width, height);
        g.setFilled(true);
        g.setFillColor(Color.ORANGE);
        add(g);
    }

    /**
     * A method that draws blocks along the x coordinate
     *
     * @param y - The parameter that is responsible for the coordinate y
     */

    private void drawBrickOnXCoordinate(double y) {

        for (int i = 0; i < c; i++) {
            drawBrick(((+(BRICK_WIDTH / 2) * b) + i * BRICK_WIDTH)+(r*BRICK_WIDTH-(r/2*BRICK_WIDTH)), y, BRICK_WIDTH, BRICK_HEIGHT);
        }
        c--;
        b++;
    }

    /**
     * A method that draws a complete pyramid
     */
    private void drawFullBrick() {
        for (int i = 0; i < BRICKS_IN_BASE; i++) {
            drawBrickOnXCoordinate(getHeight() - (BRICK_HEIGHT * i) - 23);
        }
    }
}


//-отсутств /2 ;
