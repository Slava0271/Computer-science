package com.shpp.p2p.cs.vkolisnichenko.assignment7.namesurfer;

/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */


import com.shpp.cs.a.simple.SimpleProgram;
import java.awt.event.*;
import javax.swing.*;

public class NameSurfer extends SimpleProgram implements NameSurferConstants {
    private JTextField textField = new JTextField(GRAPH_MARGIN_SIZE);
    private NameSurferGraph nameSurferGraph = new NameSurferGraph();
    private NameSurferDataBase nameSurferDataBase = new NameSurferDataBase(NAMES_DATA_FILE);
    private JButton graph = new JButton("Graph!");
    private JButton clear = new JButton("Clear");

    /* Method: init() */

    /**
     * This method has the responsibility for reading in the data base
     * and initializing the interactors at the top of the window.
     */
    public void init() {
        add(new JLabel("Name"), NORTH);
        add(textField, NORTH);
        add(graph, NORTH);
        add(clear, NORTH);
        add(nameSurferGraph);
        addActionListeners();
        textField.addKeyListener(this);
    }

    /* Method: actionPerformed(e) */

    /**
     * This class is responsible for detecting when the buttons are
     * clicked, so you will have to define a method to respond to
     * button actions.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == graph) {
            add(nameSurferGraph);
            nameSurferGraph.addEntry(nameSurferDataBase.findEntry(textField.getText()));
            nameSurferGraph.update();
        }
        if (e.getSource() == clear) {
            nameSurferGraph.clear();
        }
    }

    /**
     If the specified key has been pressed, a graph is drawn.
     */
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            add(nameSurferGraph);
            nameSurferGraph.addEntry(nameSurferDataBase.findEntry(textField.getText()));
            nameSurferGraph.update();
        }
    }

}


