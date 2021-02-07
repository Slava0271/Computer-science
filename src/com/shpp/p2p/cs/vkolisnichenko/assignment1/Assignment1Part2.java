package com.shpp.p2p.cs.vkolisnichenko.assignment1;

/**
 * In this task, the robot builds walls.
 * After the robot has built a wall, he needs to jump 4 rows
 */
public class Assignment1Part2 extends Keral {

    /**
     * This method starts a thread that builds walls.
     */
    public void run() throws Exception {
        buildWalls();
    }

    /**
     * The robot goes up and builds a wall.
     * If he stands on a bieber, then he just goes on
     */
    public void GoAndLayDownBieber() throws Exception {
        if (noBeepersPresent()) {
            putBeeper();
        }
        if (facingEast()) {
            turnLeft();
            if (frontIsClear()) {
                while (frontIsClear()) {
                    move();
                    if (noBeepersPresent()) {
                        putBeeper();
                    }
                }
            }
        }

    }

    /**
     * After Kerel built the wall,
     * he turns around and goes to the beginning of the row
     */
    private void GoToTheBeginningOfTheRow() throws Exception {
        if (facingNorth()) {
            turnAround();
            moveUntillBlock();
            turnLeft();
        }
    }

    /**
     * if front is clean, Kerel goes to the next row
     */
    private void GoToNextColumn() throws Exception {
        for (int i = 0; i < 4; i++) {
            if (frontIsClear()) {
                move();
            }
        }
    }

    /**
     * A method that encapsulates previous methods.
     * First, the Kerel builds a wall, then returns,
     * goes to the next column and so on until he can go to the next column
     */
    private void buildWalls() throws Exception {
        GoAndLayDownBieber();
        GoToTheBeginningOfTheRow();
        if (frontIsClear()) {
            GoToNextColumn();
            buildWalls();
        }
    }

}
