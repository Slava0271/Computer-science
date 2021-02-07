package com.shpp.p2p.cs.vkolisnichenko.assignment3;

import com.shpp.cs.a.console.ConsoleProgram;

/**
 * The class that makes the St. Petersburg game
 */
public class Assignment3Part5 extends ConsoleProgram {
    //a variable that counts money
    public static int n;
    @Override
    public void run() {
            game();
    }

    /**
     * A method that generates a random value from 0 to 1
     * @return - returns heads or tails
     */
    private int headsOrTails() {
        int a = (int) (Math.random() * 2);
        return a;
    }

    /**
     * The method that asks the user for a number,
     * the game runs until the user collects 100 dollars or more
     */
    private void game()  {
        System.out.println("Place a bet:");
        int i = readInt();
        n = n + i;
        if (headsOrTails() == 0) {
            System.out.println("This game, you earned $" + n);
            System.out.println("Your total is  $" + n);
            game();
        } else {
            n = n - i;
            if (n >= 20)
                System.out.println("you  win $" + n);
            else {
                System.out.println("Try again...");
                n = 0;
                game();
            }
        }
    }
}

