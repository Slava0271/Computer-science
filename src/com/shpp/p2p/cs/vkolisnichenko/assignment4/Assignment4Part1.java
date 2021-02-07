package com.shpp.p2p.cs.vkolisnichenko.assignment4;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.*;

import java.awt.*;
import java.awt.event.*;

/**
 * The class that is responsible for the game Breakout
 */
public class Assignment4Part1 extends WindowProgram {
    /**
     * Constants that control the size of the window
     */
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 600;
    private static final int WIDTH = APPLICATION_WIDTH;
    private static final int HEIGHT = APPLICATION_HEIGHT;

    //movement of the ball along the axis x
    private static double dx = 0;
    //movement of the ball along the axis y
    private static double dy = 0;
    //A variable that is responsible for the number of attempts
    private static int nturns = Const.NTURNS;
    //variable which is responsible for the number of bricks
    private static Integer number_bricks = 100;
    //variable that heals for the movement of the racket
    private GObject selectedObject;


    /**
     * A method in which the background color changes,
     * after which bricks are drawn, a listener is added
     * and physics is encapsulated, also the variable
     * nturns  decreases by 1 after each loss
     */
    @Override
    public void run() {
        setBackground(Color.getHSBColor(200, 300, 400));
        drawFullBricks();
        drawRacket(getWidth() / 2 - Const.PADDLE_WIDTH / 2, getHeight() - 40 - Const.PADDLE_HEIGHT,
                Const.PADDLE_WIDTH, Const.PADDLE_HEIGHT);
        addMouseListeners();
        game(drawBall());
        nturns--;
        game(drawBall());
        nturns--;
        game(drawBall());
        nturns--;
        lose();
    }

    /**
     * A method that implements the
     * movement of an object using the mouse
     *
     * @param e - Parameter that passes MouseEvent
     */
    @Override
    public void mousePressed(MouseEvent e) {
        selectedObject = getElementAt(e.getX(), e.getY());
    }

    /**
     * A method that moves a racket while holding the mouse
     *
     * @param e - Parameter that passes MouseEvent
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        if (selectedObject != null) {
            double newX = e.getX() - selectedObject.getWidth() / 2.0;
            selectedObject.setLocation(newX, getHeight() - Const.PADDLE_Y_OFFSET - 20);
        }
    }

    /**
     * The method that draws a racket
     *
     * @param x      - x coordinate for racket
     * @param y      - y coordinate for racket
     * @param width  - racket width
     * @param height - racket height
     * @return - return racket
     */
    private GRect drawRacket(double x, double y, int width, int height) {
        GRect g = new GRect(x, y, width, height);
        g.setFilled(true);
        g.setFillColor(Color.BLACK);
        add(g);
        return g;

    }

    /**
     * The method that draws a ball
     *
     * @return - return ball
     */
    private GOval drawBall() {
        GOval o = new GOval(getWidth() / 2 - Const.BALL_RADIUS, getHeight() / 2 - Const.BALL_RADIUS,
                Const.BALL_RADIUS * 2, Const.BALL_RADIUS * 2);
        o.setFilled(true);
        o.setFillColor(Color.BLUE);
        add(o);
        return o;
    }

    /**
     * A method in which the initial coordinates x, and y
     * After that, an inscription is drawn that displays the number of lives
     * Then the code that encapsulates the components
     * for playing the game is executed.
     *
     * @param o - Parameter in which the ball is passed for the game
     */
    private void game(GOval o) {
        dy = 10;
        dx = 0;

        //A piece of code that is responsible for drawing the number of lives
        //(No, it cannot be moved to a separate method)
        GLabel label = new GLabel("lives left: " + Integer.toString(nturns));
        label.setFont("London-20");
        label.setColor(Color.DARK_GRAY);
        double x = (getWidth() - label.getWidth());
        double y = (getHeight());

        while (o.getY() < getHeight()) {
            add(label, x, y);
            o.move(dx, dy);
            pause(60);
            ballPhysicsWithWall(o);
            ballPhysicsWithObjects(o);
            if (number_bricks == 0) {
                remove(o);
                winningString();
            }
        }
        remove(label);
    }

    /**
     * The method that is responsible for the
     * physics of the ball in a collision with objects
     *
     * @param o - The parameter to which the ball is passed
     */
    private void ballPhysicsWithObjects(GOval o) {
        GObject object = null;
        if ((object = getElementAt(o.getX(), o.getY())) != null && dx < 0) {
            if (o.getY() < 400 && o.getY() > 50) {
                remove(object);
                number_bricks--;
            }
            dy = Const.Y_COORDINATE_SPEED;
            dx = -Const.X_COORDINATE_SPEED;
        } else if ((object = getElementAt(o.getX(), o.getY())) != null && dx > 0) {
            if (o.getY() < 400 && o.getY() > 50) {
                remove(object);
                number_bricks--;
            }
            dy = Const.Y_COORDINATE_SPEED;
            dx = Const.X_COORDINATE_SPEED;
        }
        if ((object = getElementAt(o.getX() + 2 * Const.BALL_RADIUS, o.getY())) != null && dx > 0) {
            if (o.getY() < 400 && o.getY() > 50) {
                remove(object);
                number_bricks--;
            }
            dy = Const.Y_COORDINATE_SPEED;
            dx = Const.X_COORDINATE_SPEED;
        } else if ((object = getElementAt(o.getX() + 2 * Const.BALL_RADIUS, o.getY())) != null && dx < 0) {
            if (o.getY() < 400 && o.getY() > 50) {
                remove(object);
                number_bricks--;
            }
            dy = Const.Y_COORDINATE_SPEED;
            dx = -Const.X_COORDINATE_SPEED;
        }
        if ((object = getElementAt(o.getX(), o.getY() + 2 * Const.BALL_RADIUS)) != null) {
            if (o.getY() < 400 && o.getY() > 50) {
                remove(object);
                number_bricks--;
            }
            dy = -Const.Y_COORDINATE_SPEED;
            dx = Const.X_COORDINATE_SPEED;
        }
        if ((object = getElementAt(o.getX() + 2 * Const.BALL_RADIUS, o.getY() + 2 * Const.BALL_RADIUS)) != null) {
            if (o.getY() < 400 && o.getY() > 50) {
                remove(object);
                number_bricks--;
            }
            dy = -Const.Y_COORDINATE_SPEED;
            dx = -Const.X_COORDINATE_SPEED;
        }
    }

    /**
     * A method that handles ball collisions with walls
     * @param o - The parameter to which the ball is passed
     */
    private void ballPhysicsWithWall(GOval o) {
        if (o.getY() >= getHeight() - Const.BALL_RADIUS * 2) {
            remove(o);
        }
        if (o.getX() <= 0 && dy < 0) {
            dy = -Const.Y_COORDINATE_SPEED;
            dx = Const.X_COORDINATE_SPEED;
        } else if (o.getX() <= 0 && dy > 0) {
            dy = 12;
            dx = 10;
        }
        if (o.getY() <= 0 && dx < 0) {
            dy = Const.Y_COORDINATE_SPEED;
            dx = -Const.X_COORDINATE_SPEED;
        } else if (o.getY() <= 0 && dx > 0) {
            dy = Const.Y_COORDINATE_SPEED;
            dx = Const.X_COORDINATE_SPEED;
        }
        if (o.getX() + Const.BALL_RADIUS * 2 >= getWidth() && dy > 0) {
            dy = Const.Y_COORDINATE_SPEED;
            dx = -Const.X_COORDINATE_SPEED;
        } else if (o.getX() + Const.BALL_RADIUS * 2 >= getWidth() && dy < 0) {
            dy = -Const.Y_COORDINATE_SPEED;
            dx = -Const.X_COORDINATE_SPEED;
        }
    }

    /**
     * The method that draws the wall 10x10
     * and sets its color
     */
    private void drawFullBricks() {
        double y = 0;
        Color color = null;
        int[][] kr = new int[Const.NBRICKS_PER_ROW][Const.NBRICK_ROWS];
        for (int i = 0; i < kr.length; i++) {
            switch (i) {
                case 0:
                    color = Color.RED;
                    break;
                case 1:
                    color = Color.RED;
                    break;
                case 2:
                    color = Color.ORANGE;
                    break;
                case 3:
                    color = Color.ORANGE;
                    break;
                case 4:
                    color = Color.YELLOW;
                    break;
                case 5:
                    color = Color.YELLOW;
                    break;
                case 6:
                    color = Color.GREEN;
                    break;
                case 7:
                    color = Color.GREEN;
                    break;
                case 8:
                    color = Color.CYAN;
                    break;
                case 9:
                    color = Color.CYAN;
                    break;
            }
            y = (Const.BRICK_Y_OFFSET + Const.BRICK_SEP * i) + i * Const.BRICK_HEIGHT;
            for (int j = 0; j < kr[i].length; j++) {
                GRect brick = new GRect(Const.BRICK_SEP + (Const.BRICK_WIDTH * j) + Const.BRICK_SEP * j, y, Const.BRICK_WIDTH, Const.BRICK_HEIGHT);
                brick.setFilled(true);
                brick.setFillColor(color);
                add(brick);
            }
        }
    }

    /**
     * A method that draws a winning line if the bricks are over
     * and the program ends
     */
    private void winningString() {
        RandomGenerator rgen = RandomGenerator.getInstance();
        GLabel label = new GLabel("You winner!!!");
        label.setFont("London-60");
        label.setColor(Color.RED);
        double x = (getWidth() / 2 - label.getWidth() / 2);
        double y = (getHeight() / 2);
        add(label, x, y);
        for (int i = 0; i < 20; i++) {
            pause(200);
            label.setColor(rgen.nextColor());
        }
        System.exit(0);
    }

    /**
     * The method that works when losing,
     * and draws the corresponding inscription
     */
    private void lose() {
        if (number_bricks > 0) {
            removeAll();
            setBackground(Color.GREEN);
            GLabel label = new GLabel("You lose :(");
            label.setFont("London-60");
            label.setColor(Color.RED);
            double x = (getWidth() / 2 - label.getWidth() / 2);
            double y = (getHeight() / 4);
            add(label, x, y);
        }
    }
}
