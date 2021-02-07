package com.spp.p2p.vkolisnichenko.assignment1;
public class mission3 extends Keral {

    /**
     * The main method that ensures the operation of the program
     */
    public void run() throws Exception {
        //In case there are other biebers on the way
        /**
         while (frontIsClear()){
         move();
         if (beepersPresent()){
         pickBibers();
         }
         }
         turnAround();
         moveUntillBlock();
         turnAround();

         say("begin");
         */

        putBobi();
        goToBibers();

        mainMethod();

        finish();


    }

    /**
     * The robot fills the entire row with biebers
     * if there are no other biebers under it.
     */

    private void putBobi() throws Exception {

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
     * The method that selects bieber
     */
    private void pickBibers() throws Exception {
        pickBeeper();
    }


    /**
     * The main method by which a robot searches for a center
     */

    private void mainMethod() throws Exception {
        moveUntillBibers();
        pickBibers();
        goWhereNoBibers();

        check();
    }

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
            mainMethod();
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
        } else {
            putBeeper();
        }

    }


}


