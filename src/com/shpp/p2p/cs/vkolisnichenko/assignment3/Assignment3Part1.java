package com.shpp.p2p.cs.vkolisnichenko.assignment3;

import com.shpp.cs.a.console.*;

/**
 * This class checks to see if the user has done enough aerobics this week.
 */
public class Assignment3Part1 extends ConsoleProgram {
    //Constant that is responsible for the number of days
    public static final int DAYS = 7;
    //Constants that are responsible for the minimum performance for a lesson per day
    public static final int CARDIOVASCULAR_WORKOUT_PER_DAY = 30;
    public static final int BLOOD_PRESSURE_WORKOUT_PER_DAY = 40;
    //Variables that increment if the user has
    // completed the exercises for more than the minimum time
    int c = 0;
    int y = 0;
    int u = 0;

    /**
     * A method that asks the user for the number
     * of minutes per day and displays the result.
     * In case of a negative value, an exception is thrown
     */
    @Override
    public void run() {
        try {
            checkMinuts();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        cardiovacularHealth();
        bloodPressure();
    }

    /**
     * In this method, the user enters the number of
     * minutes that he spent on exercises per day.
     * If the quantity is negative, an exception is thrown,
     * otherwise the variables are incremented
     * @throws Exception  - If the quantity is negative, an exception is thrown
     */
    private void checkMinuts() throws Exception {
        for (int i = 1; i <= DAYS; i++) {
            int b = readInt("How many minutes did you do on day " + i + "?");
            if (b < 0) {
                throw new Exception("The number cannot be negative");
            }

            if (b >= CARDIOVASCULAR_WORKOUT_PER_DAY) c++;
            if (b >= BLOOD_PRESSURE_WORKOUT_PER_DAY) y++;

        }
    }

    /**
     * This method checks to see if enough workouts
     * have been performed for cardiovascular health.
     */
    private void cardiovacularHealth() {
        System.out.println("Cardiovacular health:");
        if (c < 5) {
            u = c;
            while (u != 5) u++;
            u = u - c;
            System.out.println("  You needed to train hard for at least " + u + " more   day(s) a week!");
        } else {
            System.out.println("  Great job! You've done enough exercise for cardiovacular health.");
        }
    }

    /**
     * This method checks to see if enough
     * workouts have been done for blood pressure.
     */
    private void bloodPressure() {
        System.out.println("Blood pressure:");
        u = 0;
        if (y < 3) {
            u = y;
            while (u != 3) u++;
            u = u - y;
            System.out.println("   You needed to train hard for at least " + u + " more day(s) a week!");
        } else {
            System.out.println("  Great job! You've done enough exercise to keep a low blood pressure.");
        }

    }

}
