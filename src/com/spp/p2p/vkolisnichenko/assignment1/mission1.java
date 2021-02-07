package com.spp.p2p.vkolisnichenko.assignment1;
public class mission1 extends Keral {

    /**
     * The main method that ensures the operation of the program
     */
    public void run() throws Exception {
        moveToNewSpaper();
        pickBeeper();
        goAround();

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
    private void goAround() throws Exception {
        turnAround();
        moveUntillBlock();
        turnRight();
        move();
        turnRight();
    }
}
