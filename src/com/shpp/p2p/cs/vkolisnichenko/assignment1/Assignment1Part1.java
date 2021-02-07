package com.shpp.p2p.cs.vkolisnichenko.assignment1;
/**
 in this task, the robot goes to the newspaper,
 picks it up, and goes back
 */
public class Assignment1Part1 extends Keral {

    /**
     * The main method that ensures the operation of the program
     */
    public void run() throws Exception {
        moveToNewSpaper();
        pickBeeper();
        goBack();
    }

    /**
     * The method that moves the robot to bieber
     */
    private void moveToNewSpaper() throws Exception {
        moveUntillBlock();
        turnRight();
        move();
        turnLeft();
        while (noBeepersPresent()) {
            move();
        }
    }

    /**
     * Method, that returns the robot to its original position
     */
    private void goBack() throws Exception {
        turnAround();
        moveUntillBlock();
        turnRight();
        move();
        turnRight();
    }
}
