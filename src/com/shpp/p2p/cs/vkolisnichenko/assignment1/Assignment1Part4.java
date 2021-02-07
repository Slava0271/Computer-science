package com.shpp.p2p.cs.vkolisnichenko.assignment1;

/**
 * in this task, Karel builds a chessboard
 */
public class Assignment1Part4 extends Keral {
    /**
     * In this method, a checkerboard is built.
     */
    public void run() throws Exception {
        builtСhessboard();
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
                move();
                turnLeft();
                check();
                builtСhessboard();
            }
        } else {
            if (facingWest()) {
                turnRight();
                if (frontIsClear()) {
                    move();
                    turnRight();
                    check();
                    builtСhessboard();
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
     * It is checked whether the world consists of one cell.
     * It is also checked whether the world consists of one row or columns.
     * After that, a chessboard is built.
     */
    private void builtСhessboard() throws Exception {
        if (frontIsClear()) {
            fillARow();
            leftAndCheck();
        } else {
            turnLeft();
            if (frontIsBlocked()) {
                putBeeper();
            } else {
                fillARow();
            }

        }

    }
}