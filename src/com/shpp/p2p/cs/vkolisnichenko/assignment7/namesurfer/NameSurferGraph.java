package com.shpp.p2p.cs.vkolisnichenko.assignment7.namesurfer;

/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the list of entries changes
 * or the window is resized.
 */

import acm.graphics.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class NameSurferGraph extends GCanvas
        implements NameSurferConstants, ComponentListener {
    // Indent for lines above and below
    private static final int INDENT = 40;
    // one desade
    private static final int DESADE = 10;
    //indent for label
    private static final int INDENT_FOR_LABEL = 10;
    //indent for first line
    private static final int INDENT_FOR_LINE = 5;
    //Color variable
    private int numberforcolor;
    //An array in which popularity values are stored
    private Integer[][] NameRanks = new Integer[NDECADES][NDECADES];
    //An array in which names are stored
    private ArrayList<String> names = new ArrayList<>();

    /**
     * Creates a new NameSurferGraph object that displays the data.
     */
    public NameSurferGraph() {
        addComponentListener(this);
        // You fill in the rest //
    }

    /**
     * Clears the list of name surfer entries stored inside this class.
     */
    public void clear() {
        removeAll();
        names.clear();
        update();
    }


    /* Method: addEntry(entry) */

    /**
     * Adds a new NameSurferEntry to the list of entries on the display.
     * Note that this method does not actually draw the graph, but
     * simply stores the entry; the graph is drawn by calling update.
     */
    public void addEntry(NameSurferEntry entry) {
        boolean check = true;
        for (int i = 0; i < names.size(); i++) {
            if (entry.getName().toLowerCase().equals(names.get(i).toLowerCase())) {
                check = false;
                break;
            }
        }
        if (names.size() + 1 >= NameRanks.length) {
            check = false;
        }
        if (check) {
            names.add(entry.getName());
            for (int i = 0; i < NDECADES; i++) {
                NameRanks[names.size() - 1][i] = entry.getRank(i);
            }
        }
        update();
    }

    /**
     * A method that draws a graph to
     * display the popularity values of names.
     */
    private void drawGraph() {
        for (int i = 0; i < names.size(); i++) {
            double x = INDENT_FOR_LINE + 2;
            double x2 = 0, y2 = 0;
            for (int j = 0; j < NDECADES; j++) {
                double y = getHeight() / NDECADES;
                if (NameRanks[i][j] <= 0) {
                    y = getHeight() - y;
                } else {
                    y = (y + (y * NameRanks[i][j] / (MAX_RANK / (NDECADES))));
                }
                label(names.get(i), x, y - INDENT_FOR_LINE, color());
                if (j != 0 & NameRanks[i][j] != 0 && NameRanks[i][j] < 860) {
                    label(names.get(i) + " " + NameRanks[i][j], x, y - INDENT_FOR_LINE, color());
                    line(x2, y2, x, y, color());
                } else if (NameRanks[i][j] == 0) {
                    label(names.get(i) + " " + "*", x, y - INDENT_FOR_LINE, color());
                    line(x2, y2, x, y, color());
                } else if (NameRanks[i][j] > 860) {
                    label(names.get(i) + NameRanks[i][j], x, y - INDENT_FOR_LINE, color());
                    line(x2, y2, x, y, color());
                }
                x2 = x;
                y2 = y;
                x = x + APPLICATION_WIDTH / NDECADES;
            }
            numberforcolor++;
        }
    }

    /**
     * The method that is responsible for changing the colors of the graph
     *
     * @return - return color
     */
    private Color color() {
        if (numberforcolor == 0) return Color.blue;
        if (numberforcolor == 1) return Color.red;
        if (numberforcolor == 2) return Color.magenta;
        if (numberforcolor == 3) {
            numberforcolor = 0;
            return Color.black;
        }
        return null;
    }


    /**
     * Updates the display image by deleting all the graphical objects
     * from the canvas and then reassembling the display according to
     * the list of entries. Your application must call update after
     * calling either clear or addEntry; update is also called whenever
     * the size of the canvas changes.
     */
    public void update() {
        removeAll();
        drawGrid();
        drawGraph();
    }

    /**
     * The method that draws the grid for the graph
     */
    public void drawGrid() {
        for (int i = 0; i < NDECADES; i++) {
            line(INDENT_FOR_LINE + i * APPLICATION_WIDTH / NDECADES, getHeight(),
                    INDENT_FOR_LINE + i * APPLICATION_WIDTH / NDECADES, 0, Color.BLACK);
            label(Integer.toString(START_DECADE + (i * DESADE)), i * APPLICATION_WIDTH /
                    NDECADES + INDENT_FOR_LABEL, getHeight() - 20, Color.BLACK);
        }

        line(0, getHeight() - INDENT, APPLICATION_WIDTH, getHeight() - INDENT, Color.BLACK);
        line(0, INDENT, APPLICATION_WIDTH, INDENT, Color.BLACK);

    }


    /**
     * Method that draws an inscription on the screen
     *
     * @param text - The text to be displayed
     * @param x    - X coordinate text
     * @param y    - Y coordinate text
     * @return - return label
     */
    public GLabel label(String text, double x, double y, Color color) {
        GLabel label = new GLabel(text);
        label.setFont("London-15");
        add(label, x, y);
        return label;
    }

    /**
     * Method that draws a line
     *
     * @param x-  First point on the x axis
     * @param y-  First point on the y axis
     * @param x1- Second point on the x axis
     * @param y1- Second point on the y axis
     * @return - return line
     */
    public GLine line(double x, double y, double x1, double y1, Color color) {
        GLine gLine = new GLine(x, y, x1, y1);
        gLine.setVisible(true);
        gLine.setColor(color);
        add(gLine);
        return gLine;
    }

    /* Implementation of the ComponentListener interface */
    public void componentHidden(ComponentEvent e) {
    }

    public void componentMoved(ComponentEvent e) {
    }

    public void componentResized(ComponentEvent e) {
        update();
    }

    public void componentShown(ComponentEvent e) {
    }
}
