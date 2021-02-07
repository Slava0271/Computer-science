
package com.shpp.p2p.cs.vkolisnichenko.assignment2;

import acm.graphics.GOval;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/**
 * In this class, a window is created
 * that is designed to cause visual illusion.
 */
public class Assignment2Part2 extends WindowProgram {
    //Constants that determine the size of the window
    public static final int APPLICATION_WIDTH = 300;
    public static final int APPLICATION_HEIGHT = 300;
    //Constant that indicates the diameter of a circle
    public static final int DIAMETR = APPLICATION_HEIGHT / 3;
    //Constants that indicate the width and height of the rectangle (in fact the square)
    public static final int SQUARE_WIDTH = APPLICATION_WIDTH - DIAMETR;
    public static final int SQUARE_HEIGHT = APPLICATION_HEIGHT - DIAMETR;

    /**
     * The method that draws the main window,
     * then black circles at the corners and then a white square
     */
    @Override
    public void run() {
        drawMainWindow(APPLICATION_WIDTH, APPLICATION_HEIGHT);
        drawCircle(DIAMETR);
        drawRect(APPLICATION_WIDTH / 2, APPLICATION_HEIGHT / 2, SQUARE_WIDTH, SQUARE_HEIGHT);

    }

    /**
     * The method that draws the main frame
     *
     * @param width  - Responsible for the width of the window
     * @param height - Responsible for the height of the window
     */
    public void drawMainWindow(int width, int height) {
        GRect r = new GRect(width, height);
        add(r);
    }

    /**
     * A method that draws 4 black
     * circles in the corners of a frame
     *
     * @param diametr - This parameter is responsible for the diameter of the circle.
     */
    private void drawCircle(int diametr) {
        GOval o1 = new GOval(diametr, diametr);
        o1.setFilled(true);

        o1.setColor(Color.black);

        GOval o2 = new GOval(APPLICATION_WIDTH - diametr, 0, diametr, diametr);
        o2.setFilled(true);
        o2.setColor(Color.black);

        GOval o3 = new GOval(0, APPLICATION_HEIGHT - diametr, diametr, diametr);
        o3.setFilled(true);
        o3.setColor(Color.black);

        GOval o4 = new GOval(APPLICATION_HEIGHT - diametr, APPLICATION_WIDTH - diametr, diametr, diametr);
        o4.setFilled(true);
        o4.setColor(Color.black);


        add(o1);
        add(o2);
        add(o3);
        add(o4);
    }

    /**
     * This draw method is responsible for drawing
     * white square to create an illusion
     *
     * @param x      - Parameter which is responsible for x coordinate
     * @param y      - Parameter which is responsible for y coordinate
     * @param width  - Parameter that determines the width of the rectangle
     * @param height - Parameter that determines the height of the rectangle
     */
    private void drawRect(int width, int height, int x, int y) {
        GRect g1 = new GRect(width - x / 2, height - y / 2, x, y);
        add(g1);
        g1.setFilled(true);
        g1.setColor(Color.WHITE);

    }
}
