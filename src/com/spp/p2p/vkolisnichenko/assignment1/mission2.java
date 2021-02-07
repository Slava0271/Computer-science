package com.spp.p2p.vkolisnichenko.assignment1;
public class mission2 extends Keral {

    /**
     * The main method that ensures the operation of the program
     */
    public void run() throws Exception {
        turnLeft();
        mainMethod();
    }

    /**
     * The robot goes along a row and if there are
     * no biebers on the floor, it lays them down
     */
    private void fillARow() throws Exception {
        while (frontIsClear()) {
            if (noBeepersPresent()) {
                putBeeper();
            }
            move();
        }
        if (noBeepersPresent()) putBeeper();
    }

    /**
     * The robot steps forward 1 column (takes 4 steps)
     */
    private void toNextColumn() throws Exception {
        if (frontIsClear()) {
            for (int i = 0; i < 4; i++) {
                move();
            }
        }
    }

    /**
     * A method that encapsulates previous methods
     */
    private void mainMethod() throws Exception {
        fillARow();
        ifFacingNorth();
        ifFacingSouth();
    }

    /**
     * If the robot looks at the north,
     * the robot turns right and goes to the next row
     */
    private void ifFacingNorth() throws Exception {
        if (facingNorth()) {
            turnRight();
            if (frontIsClear()) {
                toNextColumn();
                turnRight();
                mainMethod();
            }
        }
    }

    /**
     * If the robot looks at the South,
     * the robot turns left and goes to the next row
     */
    private void ifFacingSouth() throws Exception {
        if (facingSouth()) {
            turnLeft();
            if (frontIsClear()) {
                toNextColumn();
                turnLeft();
                mainMethod();
            }

        }

    }
}
