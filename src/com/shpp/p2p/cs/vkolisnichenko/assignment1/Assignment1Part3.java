package com.shpp.p2p.cs.vkolisnichenko.assignment1;

/**
 * in this task, Karel must find the middle
 */
public class Assignment1Part3 extends Keral {

    /** A method, that seeks the middle*/
    public void run() throws Exception {
      verificationAndMethodSelection();
    }


    /**
     * The robot fills the entire row with biebers
     * if there are no other biebers under it.
     */
    private void putBibers() throws Exception {
        while (noBeepersPresent() && frontIsClear()) {
            putBeeper();
            move();
        }
        putBeeper();
    }


    /**
     * If the robot doesn’t have bieber under its feet, then it goes straight to the nearest bieber
     */
    private void goWhileNoBibers() throws Exception {
        if (noBeepersPresent()) {
            while (noBeepersPresent()) {
                if (frontIsClear()) {
                    move();
                } else {
                    turnAround();
                }
            }
        }

    }


    /**
     * It calls the previous method,
     * after which it picks up the bieber,
     * goes to the end of the row and picks up the bieber from there
     */
    private void goToBibers() throws Exception {
        goWhileNoBibers();
        pickBeeper();
        if (frontIsClear()) {
            moveUntillBlock();
        } else {
            turnAround();
            moveUntillBlock();
        }
        while (beepersPresent()) {
            goToBibers();
        }
        if (frontIsBlocked()) {
            turnAround();
        }
    }


    /**
     * A method that simply tells the robot to go to the nearest bieber
     */
    private void moveUntillBibers() throws Exception {
        if (noBeepersPresent()) {
            while (noBeepersPresent()) {
                if (frontIsBlocked()) {
                    turnAround();
                }
                move();
            }
        }
    }


    /**
     In this method, the robot picks up the bieber
     that lies in front of it, after which it goes
     to the end of the map and stands on the extreme bieber */
    private void becomeAnExtremeBieber() throws Exception {
        moveUntillBibers();
        pickBeeper();
        goWhereNoBibers();
        check();

    }

    /**
     The robot takes a step, and if the robot
     is on the bieber, it goes until it is on the bieber
     */
    private void goWhereNoBibers() throws Exception {
        move();
        while (beepersPresent()) {
            if (frontIsBlocked()) {
                turnAround();
            }
            move();
        }
        while (noBeepersPresent()) {
            if (frontIsBlocked()) {
                turnAround();
            }
            move();
        }

    }


    /**
     * The method by which it is checked whether it is worth further to raise the bieber
     */
    private void check() throws Exception {
        move();
        if (beepersPresent()) {
            turnAround();
            move();
            turnAround();
           becomeAnExtremeBieber();
        }
    }


    /**
     * Last method, return the robot to the center
     * if the row is unpaired, otherwise add the last bieber
     */
    private void finish() throws Exception {
        if (facingWest()) {
            turnAround();
            move();


        }
    }


    /**
     * The robot checks if the row consists of 3 squares.
     * If so, it searches for the center using a separate method
     */
    public void checkBibers() throws Exception {
        turnAround();
        move();
        move();
        if (frontIsClear()) {
            turnAround();
            move();
            move();
            turnAround();
            goToBibers();
        } else {
            findMiddleIf3Squares();
        }
    }


    /**
     * If there are 3 squares in a row,
     * the robot uses this method to find the center
     */
    private void findMiddleIf3Squares() throws Exception {
        pickBeeper();
        turnAround();
        moveUntillBlock();
        pickBeeper();
    }


    /**
     Keral checks to see if there is a row
     with the 1st cell. If it is, then he simply
     lays down the bieber.
     It also decides which method to select for
     the center, depending on the number of cells.*/
    private void verificationAndMethodSelection()throws Exception{
        if (frontIsClear()) {
            move();
            if(frontIsClear()) {
                turnAround();
                move();
                turnAround();
                putBibers();
                checkBibers();
                if (frontIsClear()) {
                    move();
                }
                if (frontIsClear()) {
                    turnAround();
                    move();
                    turnAround();
                    becomeAnExtremeBieber();
                    finish();
                }
            }else { putBeeper();}
        } else {
            putBeeper();
        }
    }
}


