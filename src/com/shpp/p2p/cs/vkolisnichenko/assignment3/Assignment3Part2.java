package com.shpp.p2p.cs.vkolisnichenko.assignment3;

import com.shpp.cs.a.console.ConsoleProgram;

/**
 * A class that reads a number from the user
 * and repeats the mathematical operations until it turns out 1
 */
public class Assignment3Part2 extends ConsoleProgram {
    /**
     * A method that asks the user for
     * a number and performs operations until the number is 1.
     * If the number does not match, an exception is thrown
     */
    @Override
    public void run() {
        System.out.println("Enter a number");
        int n = readInt();
        try {
            gardenNumbers(n);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * A method that, after a series of checks, checks whether the number is even.
     * If so, the number is divided by 2, otherwise the number is
     * multiplied by 3 and 1 is added until the result is 1
     *
     * @param n - The number the user enters into the console
     * @throws Exception - If the number is less than or equal to zero, an exception is thrown
     */
    private void gardenNumbers(int n) throws Exception {
        while (true) {
            if (n < 0 || n == 0) {
                throw new Exception("The numbers must be greater than zero");
            }
            if (n == 1) {
                System.out.println(n + " the end");
                System.exit(0);
            }
            if ((n % 2) == 0) {
                System.out.println(n + " is even so I take half");
                n = n / 2;
            } else if ((n % 2) != 0) {
                System.out.println(n + " is odd so I make 3n + 1");
                n = (n * 3) + 1;
            }
            gardenNumbers(n);
        }
    }

}

