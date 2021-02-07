package com.shpp.p2p.cs.vkolisnichenko.assignment3;

import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/**
 * A class that generates 30 squares within 3 seconds,
 * then performs another 2 seconds of animation, and ends the program
 */
public class Assignment3Part6 extends WindowProgram {
    //The constant that is responsible for the size of the square
    public static final double BOX_SIZE = 50;

    /**
     * In this method, a new Thread object is created,
     * after which an animation is created.
     */
    public void run() {
        Thread thrd = new Thread(new MyThread());
        thrd.start();
        GRect box = makeBox();
        add(box);
        try {
            drawLotOfSquares();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * The method that draws 1 square
     *
     * @return - return box
     */
    private GRect makeBox() {
        RandomGenerator rgen = RandomGenerator.getInstance();
        GRect box = new GRect(rgen.nextInt(rgen.nextInt(0, (int) (getWidth() - BOX_SIZE))), rgen.nextInt(0, (int) (getHeight() - BOX_SIZE)), BOX_SIZE, BOX_SIZE);
        box.setFilled(true);
        box.setFillColor(rgen.nextColor());
        add(box);
        return box;
    }

    /**
     * A method that draws squares for 3 seconds,
     * deletes them, then draws an inscription
     *
     * @throws Exception - is possible InterruptedException
     */
    private void drawLotOfSquares() throws Exception {
        for (int i = 0; i < 30; i++) {
            makeBox();
            Thread.sleep(100);
        }
        Thread.sleep(500);
        removeAll();
        string("The end ");
    }

    /**
     * A method that draws an inscription and changes its color every 0.2 seconds
     *
     * @param s - Parameter that passes the inscription
     * @throws Exception - is possible InterruptedException
     */
    private void string(String s) throws Exception {
        RandomGenerator rgen = RandomGenerator.getInstance();
        GLabel label = new GLabel(s);
        label.setFont("London-60");
        label.setColor(Color.RED);
        double x = (getWidth() / 2 - label.getWidth() / 2);
        double y = (getHeight() / 2);
        add(label, x, y);
        while (true) {
            Thread.sleep(200);
            label.setColor(rgen.nextColor());
        }
    }

}

/**
 * The class that creates the new thread.
 * After 5 seconds after creating the program, it ends
 */
class MyThread implements Runnable {
    //  After 5 seconds after creating the program, it ends
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.exit(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
