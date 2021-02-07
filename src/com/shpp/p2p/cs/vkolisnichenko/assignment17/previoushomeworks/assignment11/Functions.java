package com.shpp.p2p.cs.vkolisnichenko.assignment17.previoushomeworks.assignment11;

/**
 * An enumeration that lists all trigonometric functions
 */
public enum Functions {
    SIN("sin"), COS("cos"), TAN("tan"),
    ATAN("atan"), LOG2("log"),
    LOG10("log10"), SQRT("sqrt");

    //A variable that stores the names of trigonometric functions
    private String name;

    Functions(String name) {
        this.name = name;
    }
    //Method that returns the name of the function
    public String getName() {
        return name;
    }
}