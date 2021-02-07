package com.shpp.cs.vkolisnichenko.namesurfer;

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

public class NameSurferGraph extends GCanvas
        implements NameSurferConstants, ComponentListener {
    // Indent for lines above and below
    public static final int INDENT = 50;
    // one desade
    public static final int DESADE = 10;
    //indent for label
    public static final int INDENT_FOR_LABEL=10;

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
    }


    /* Method: addEntry(entry) */

    /**
     * Adds a new NameSurferEntry to the list of entries on the display.
     * Note that this method does not actually draw the graph, but
     * simply stores the entry; the graph is drawn by calling update.
     */
    public void addEntry(NameSurferEntry entry) {
    }

    /**
     * Updates the display image by deleting all the graphical objects
     * from the canvas and then reassembling the display according to
     * the list of entries. Your application must call update after
     * calling either clear or addEntry; update is also called whenever
     * the size of the canvas changes.
     */
    public void update() {

        for (int i = 0; i < NDECADES; i++) {
            line(i * APPLICATION_WIDTH / NDECADES, getHeight(), i * APPLICATION_WIDTH / NDECADES, 0);
            label(Integer.toString(START_DECADE + (i * DESADE)), i * APPLICATION_WIDTH /
                    NDECADES+INDENT_FOR_LABEL, getHeight() - 20);
        }

        line(0, getHeight() - INDENT, APPLICATION_WIDTH, getHeight() - INDENT);
        line(0, INDENT, APPLICATION_WIDTH, INDENT);
    }

    /**
     * Method that draws an inscription on the screen
     *
     * @param text - The text to be displayed
     * @param x    - X coordinate text
     * @param y    - Y coordinate text
     * @return - return label
     */
    public GLabel label(String text, int x, int y) {
        GLabel label = new GLabel(text);
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
    public GLine line(int x, int y, int x1, int y1) {
        GLine gLine = new GLine(x, y, x1, y1);
        gLine.setVisible(true);
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
