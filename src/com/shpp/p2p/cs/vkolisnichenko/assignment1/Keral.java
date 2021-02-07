package com.shpp.p2p.cs.vkolisnichenko.assignment1;
import com.shpp.karel.KarelTheRobot;


public class Keral extends KarelTheRobot {

    //Keral rotate 180 degrees
    public void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }


    //Turns the robot to the right
    public void turnRight() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    //The robot will walk until there is a wall in front of it
    public void moveUntillBlock() throws Exception {
        while (frontIsClear()) {
            move();
        }
    }

}
