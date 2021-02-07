package com.shpp.p2p.cs.vkolisnichenko.assignment2;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/**
 * The class draws the matrix from the black boxes, creating the illusion
 */
public class Assignment2Part5 extends WindowProgram {
    //Number of rows
    private static final int NUM_ROWS = 5;
    //Number of columns
    private static final int NUM_COLS = 6;
    //Box Size Width and Height
    private static final int BOX_SIZE = 40;
    //Distance between boxes
    private static final int BOX_SPACING = 10;
    //Constants that determine the size of the window
    public static final int APPLICATION_WIDTH = 310;
    public static final int APPLICATION_HEIGHT = 260;

    /**
     * The method that draws the frame,
     * then draws the matrix from the black boxes
     */
    @Override
    public void run() {
        window(APPLICATION_WIDTH, APPLICATION_HEIGHT);
        drawAllBoxes(NUM_ROWS);

    }

    /**
     * The method that draws the main frame
     *
     * @param width  - width of frame
     * @param height - height of frame
     */
    public void window(int width, int height) {
        GRect r = new GRect(width, height);
        add(r);
    }

    /**
     * The method that draws the box
     *
     * @param x      - The parameter that is responsible for the location of the box on the x coordinate
     * @param y      - The parameter that is responsible for the location of the box on the y coordinate
     * @param width  - The parameter that is responsible for the width of the box
     * @param height - The parameter that is responsible for the height of the box
     */
    public void drawBox(int x, int y, int width, int height) {
        GRect g = new GRect(x, y, width, height);
        g.setFilled(true);
        g.setColor(Color.BLACK);
        add(g);
    }

    /**
     * The method that builds the columns
     *
     * @param y    - The parameter that is responsible for the location of the box on the y coordinate
     * @param cols - The parameter that is responsible for the number of columns
     */
    public void drawColumns(int y, int cols) {
        for (int i = 0; i < cols; i++) {
            drawBox((i * 50) + BOX_SPACING, y, BOX_SIZE, BOX_SIZE);
        }
    }

    /**
     * The method that builds the rows
     *
     * @param rows - The parameter that is responsible for the number of rows
     */
    public void drawAllBoxes(int rows) {
        for (int i = 0; i < rows; i++) {
            drawColumns((i * 50) + BOX_SPACING, NUM_COLS);
        }
    }
}


