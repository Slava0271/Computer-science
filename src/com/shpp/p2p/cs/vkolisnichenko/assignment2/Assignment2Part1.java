package com.shpp.p2p.cs.vkolisnichenko.assignment2;

import com.shpp.cs.a.console.*;

/**
 * This class finds the roots of the quadratic equation
 */
public class Assignment2Part1 extends TextProgram {

    // Variables a, b, c - coefficients of the quadratic equation
    // Variables x1, x2 - the roots of the quadratic equation
    double a, b, c, x1, x2;


    /**
     * In this method, the user
     * enters the coefficients of the equation
     */
    public void enterRoot() {
        println("Enter a numbers:");
        a = readDouble();
        b = readDouble();
        c = readDouble();
    }

    /**
     * This method finds the roots of
     * the quadratic equation, if they exist
     */
    public void findRoot() {
        enterRoot();
        x1 = (-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / 2 * a;
        x2 = (-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / 2 * a;

        if (Double.isNaN(x1)) {
            println("No 1st root");
        } else {
            println("1st root " + x1);
        }

        if (Double.isNaN(x2)) {
            println("No 2nd root");
        } else {
            println("2nd root " + x2);
        }


    }

    /**
     * A new thread starts,
     * in which the findRoot method is called
     */
    @Override
    public void run() {
        findRoot();
    }
}

