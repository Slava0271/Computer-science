package com.shpp.cs.vkolisnichenko.namesurfer;

/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;
import com.shpp.cs.a.simple.SimpleProgram;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NameSurfer extends SimpleProgram implements NameSurferConstants {
    // Create buttons
    JButton clearButton, graph;
    //Create an input field
    TextField textField;
    //Create an object of type NameSurferGraph
    NameSurferGraph nameSurferGraph = new NameSurferGraph();
    //Allocate memory for a new object
    NameSurferDataBase nameSurferDataBase;

    /* Method: init() */

    /**
     * This method has the responsibility for reading in the data base
     * and initializing the interactors at the top of the window.
     */
    public void init() {
        textField = new TextField(GRAPH_MARGIN_SIZE);
        add(textField, NORTH);
        clearButton = new JButton("Clear");
        graph = new JButton("Graph");
        add(graph, NORTH);
        add(clearButton, NORTH);
        add(nameSurferGraph);
        addActionListeners();
    }
    /* Method: actionPerformed(e) */

    /**
     * This class is responsible for detecting when the buttons are
     * clicked, so you will have to define a method to respond to
     * button actions.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            textField.setText("");
            nameSurferGraph.clear();
        }
        if (e.getSource() == graph) {
            //We write the value from the textfield to the variable
            String line = textField.getText();
            //Making the Case Insensitive
            String s = line.toLowerCase();
            nameSurferDataBase = new NameSurferDataBase(NAMES_DATA_FILE, s);
            nameSurferGraph.update();
        }
    }
}
