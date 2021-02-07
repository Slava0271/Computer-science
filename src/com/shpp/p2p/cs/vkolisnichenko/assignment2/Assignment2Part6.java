package com.shpp.p2p.cs.vkolisnichenko.assignment2;

import acm.graphics.GOval;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/**
 * The class that draws the caterpillar
 */
public class Assignment2Part6 extends WindowProgram {
    //Constants that determine the size of the window
    public static final int APPLICATION_WIDTH = 300;
    public static final int APPLICATION_HEIGHT = 300;
    //Constant that determines the diameter of a segment
    public static final int DIAMETR = APPLICATION_HEIGHT / 4;
    // Constant which is responsible for the number of segments
    public static final int N = 12;
    //Static variable needed to draw a caterpillar
    public static int i = 0;

    /**
     * The method that first draws the frame,
     * then the number of segments that were set in the variable
     */
    @Override
    public void run() {
        window(APPLICATION_WIDTH, APPLICATION_HEIGHT);
        drawCaterpillar();
    }

    /**
     * The method that draws the main frame
     *
     * @param width  - frame width
     * @param height - frame height
     */
    public void window(int width, int height) {
        GRect g = new GRect(width, height);
    }

    /**
     * A method that draws a sigment for a caterpillar
     *
     * @param x    - X-axis oval
     * @param y    - Y-axis oval
     * @param diam - Segment diameter
     */
    public void drawSegment(int x, int y, int diam) {
        GOval o = new GOval(x, y, diam, diam);
        o.setFilled(true);
        o.setFillColor(Color.GREEN);
        add(o);
    }

    /**
     * A method that draws a caterpillar.
     * If the number of the segment that is currently
     * being drawn is divided by 2, it is drawn above, otherwise below
     */
    public void drawCaterpillar() {
        drawSegment(20 + (i * DIAMETR), 100, DIAMETR);
        for (i = 1; i < N; i++) {
            if ((i % 2) == 0) {
                drawSegment(20 + i * DIAMETR - (DIAMETR / 3) * i, 100, DIAMETR);
            }
            if ((i % 2) != 0) {
                drawSegment(20 + i * DIAMETR - (DIAMETR / 3) * i, 70, DIAMETR);
            }
        }
    }
}