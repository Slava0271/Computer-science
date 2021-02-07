package com.shpp.p2p.cs.vkolisnichenko.assignment2;

import acm.graphics.GOval;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/**
 * This class draws 2 footprints.
 */
public class Assignment2Part3 extends WindowProgram {

    // The default width and height of the window. These constants will tell Java to
    // create a window whose size is *approximately* given by these dimensions.
    public static final int APPLICATION_WIDTH = 270;
    public static final int APPLICATION_HEIGHT = 220;

    // Constants controlling the relative positions of the
    // three toes to the upper-left corner of the pawprint.
    private static final double FIRST_TOE_OFFSET_X = 10;
    private static final double FIRST_TOE_OFFSET_Y = 30;
    private static final double SECOND_TOE_OFFSET_X = 40;
    private static final double SECOND_TOE_OFFSET_Y = 10;
    private static final double THIRD_TOE_OFFSET_X = 70;
    private static final double THIRD_TOE_OFFSET_Y = 30;

    private static final double FIRST_TOE2_OFFSET_X = 180;
    private static final double FIRST_TOE2_OFFSET_Y = 70;
    private static final double SECOND_TOE2_OFFSET_X = 210;
    private static final double SECOND_TOE2_OFFSET_Y = 50;
    private static final double THIRD_TOE2_OFFSET_X = 240;
    private static final double THIRD_TOE2_OFFSET_Y = 70;


    // The position of the heel relative to the upper-left
    // corner of the pawprint.
    private static final double HEEL_OFFSET_X = 30;
    private static final double HEEL_OFFSET_Y = 50;
    private static final double HEEL2_OFFSET_X = APPLICATION_WIDTH - (HEEL_OFFSET_X * 2) - 10;
    private static final double HEEL2_OFFSET_Y = 90;


    // Each toe is an oval with this width and height.
    private static final double TOE_WIDTH = 20;
    private static final double TOE_HEIGHT = 30;

    // The heel is an oval with this width and height.
    private static final double HEEL_WIDTH = 40;
    private static final double HEEL_HEIGHT = 60;

    /**
     * The method that draws the main window, then 2 footprints
     */
    @Override
    public void run() {
        window(APPLICATION_WIDTH, APPLICATION_HEIGHT);
        drawPawprint(FIRST_TOE_OFFSET_X, FIRST_TOE_OFFSET_Y);
        drawPawprint(SECOND_TOE_OFFSET_X, SECOND_TOE_OFFSET_Y);
        drawPawprint(THIRD_TOE_OFFSET_X, THIRD_TOE_OFFSET_Y);
        drawHeel(HEEL_OFFSET_X, HEEL_OFFSET_Y);
        drawPawprint(FIRST_TOE2_OFFSET_X, FIRST_TOE2_OFFSET_Y);
        drawPawprint(SECOND_TOE2_OFFSET_X, SECOND_TOE2_OFFSET_Y);
        drawPawprint(THIRD_TOE2_OFFSET_X, THIRD_TOE2_OFFSET_Y);
        drawHeel(HEEL2_OFFSET_X, HEEL2_OFFSET_Y);
    }

    /**
     * Draws a pawprint. The parameters should specify the upper-left corner of the
     * bounding box containing that pawprint.
     *
     * @param x The x coordinate of the upper-left corner of the bounding box for the pawprint.
     * @param y The y coordinate of the upper-left corner of the bounding box for the pawprint.
     */
    private void drawPawprint(double x, double y) {
        GOval o = new GOval(x, y, TOE_WIDTH, TOE_HEIGHT);
        o.setFilled(true);
        o.setColor(Color.BLACK);
        add(o);

    }

    /**
     * In this method, a window is drawn
     *
     * @param x - The parameter that is responsible for the x coordinate
     * @param y - The parameter that is responsible for the y coordinate
     */
    private void window(int x, int y) {
        GRect g = new GRect(x, y);
    }

    /**
     * In this method, the heel is drawn
     *
     * @param x-The parameter that is responsible for the x coordinate
     * @param y-    The parameter that is responsible for the y coordinate
     */
    private void drawHeel(double x, double y) {
        GOval o1 = new GOval(x, y, HEEL_WIDTH, HEEL_HEIGHT);
        o1.setFilled(true);
        o1.setColor(Color.BLACK);
        add(o1);
    }
}
