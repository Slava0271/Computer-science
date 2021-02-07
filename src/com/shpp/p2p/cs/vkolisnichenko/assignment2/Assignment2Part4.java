package com.shpp.p2p.cs.vkolisnichenko.assignment2;

import acm.graphics.GLabel;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.*;

import java.awt.*;

/**
 * A class that draws a flag of Belgium with a signature
 */
public class Assignment2Part4 extends WindowProgram {
    //Constants that determine the size of the window
    public static final int APPLICATION_WIDTH = 300;
    public static final int APPLICATION_HEIGHT = 300;

    //Constants that indicate x and y coordinates for parts of the flag
    public static final int FLAG1_X = APPLICATION_WIDTH / 5;
    public static final int FLAG1_Y = APPLICATION_HEIGHT / 2;

    /**
     * The method that draws the
     * frame and then the flag of Belgium with signature
     */
    @Override
    public void run() {
        window(APPLICATION_WIDTH, APPLICATION_HEIGHT);
        drawFlagOfBelgium();
        label("flag of Belgium");

    }

    /**
     * The method that draws the main window
     *
     * @param width  -  Parameter that determines the width of the window
     * @param height -  Parameter that determines the height of the window
     */
    public void window(int width, int height) {
        GRect r = new GRect(width, height);
    }

    /**
     * The method that draws the 1st part of the flag
     *
     * @param a      - A parameter that determines the location of this part of the flag along the x coordinate
     * @param b      - A parameter that determines the location of this part of the flag along the y coordinate
     * @param width  - The parameter that determines the width of the flag part
     * @param height - The parameter that determines the height of the flag part
     */
    public void partOfTheFlag1(int a, int b, int width, int height) {
        GRect r = new GRect(a, b, width, height);
        add(r);
        r.setFilled(true);
        r.setColor(Color.YELLOW);
    }


    /**
     * The method that draws the 2nd part of the flag
     *
     * @param a      - A parameter that determines the location of this part of the flag along the x coordinate
     * @param b      - A parameter that determines the location of this part of the flag along the y coordinate
     * @param width  - The parameter that determines the width of the flag part
     * @param height - The parameter that determines the height of the flag part
     */
    public void partOfTheFlag2(int a, int b, int width, int height) {
        GRect r = new GRect(a, b, width, height);
        add(r);
        r.setFilled(true);
        r.setColor(Color.BLACK);

    }

    /**
     * The method that draws the 3rd part of the flag
     *
     * @param a      - A parameter that determines the location of this part of the flag along the x coordinate
     * @param b      - A parameter that determines the location of this part of the flag along the y coordinate
     * @param width  - The parameter that determines the width of the flag part
     * @param height - The parameter that determines the height of the flag part
     */
    public void partOfTheFlag3(int a, int b, int width, int height) {
        GRect r = new GRect(a, b, width, height);
        add(r);
        r.setFilled(true);
        r.setColor(Color.RED);
    }

    /**
     * The method that draws the flag signature in the lower right corner
     *
     * @param s - The inscription that appears
     */
    public void label(String s) {
        GLabel label = new GLabel(s);
        label.setFont("London-20");
        label.setColor(Color.RED);
        double x = (APPLICATION_WIDTH - label.getWidth() - 5);
        double y = (APPLICATION_HEIGHT - label.getHeight());
        add(label, x, y);
    }

    /**
     * A method that encapsulates 3 parts of a flag
     */
    private void drawFlagOfBelgium() {
        partOfTheFlag1(APPLICATION_WIDTH / 2 - FLAG1_X / 2, APPLICATION_HEIGHT / 2 - FLAG1_Y / 2, FLAG1_X, FLAG1_Y);
        partOfTheFlag2(APPLICATION_WIDTH / 2 - FLAG1_X / 2 - FLAG1_X, APPLICATION_HEIGHT / 2 - FLAG1_Y / 2, FLAG1_X, FLAG1_Y);
        partOfTheFlag3(APPLICATION_WIDTH / 2 - FLAG1_X / 2 + FLAG1_X, APPLICATION_HEIGHT / 2 - FLAG1_Y / 2, FLAG1_X, FLAG1_Y);

    }


}
