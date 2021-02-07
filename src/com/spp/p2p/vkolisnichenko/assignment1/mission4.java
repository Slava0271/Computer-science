package com.spp.p2p.vkolisnichenko.assignment1;
public class mission4 extends Keral {

    /**
     * The main method that ensures the operation of the program
     */
    public void run() throws Exception {
        mainMethod();
    }

    /**
     * In this method, the robot lays down the Bieber through 1 cell
     **/
    private void fillARow() throws Exception {
        if (frontIsClear()) {
            while (frontIsClear()) {
                putBeeper();
                if (frontIsClear()) {
                    move();
                }
                if (frontIsClear()) {
                    move();
                }
            }
            turnAround();
            move();
            if (noBeepersPresent()) {
                turnAround();
                move();
                putBeeper();
            } else {
                turnAround();
                move();
            }
        }


    }

    /**
     * This is a method in which the transition
     * to a new series is implemented, checking and,
     * if necessary, calling the main method
     */
    private void leftAndCheck() throws Exception {
        if (facingEast()) {
            turnLeft();
            if (frontIsClear()) {
                turnRight();
                turnLeft();
                move();
                turnLeft();
                check();
                mainMethod();
            }
        } else {
            if (facingWest()) {
                turnRight();
                if (frontIsClear()) {
                    turnLeft();
                    turnRight();
                    move();
                    turnRight();
                    check();
                    mainMethod();
                }
            }
        }
    }

    /**
     * A method that checks whether to put a bieber at the beginning of a row
     */
    private void check() throws Exception {
        if (facingWest()) {
            turnLeft();
            move();
            if (beepersPresent()) {
                turnAround();
                move();
                turnLeft();
                move();
            } else {
                if (noBeepersPresent()) {
                    turnAround();
                    move();
                    turnLeft();
                }
            }
        }

    }

    /**
     * A method that encapsulates previous methods
     */
    private void mainMethod() throws Exception {
        fillARow();
        leftAndCheck();

    }

}