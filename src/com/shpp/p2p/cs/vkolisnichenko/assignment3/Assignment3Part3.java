package com.shpp.p2p.cs.vkolisnichenko.assignment3;
import com.shpp.cs.a.console.ConsoleProgram;
// A class that raises a given number to a power
public class Assignment3Part3 extends ConsoleProgram {
    /** A method that outputs to the console the result of exponentiation*/
    @Override
    public void run() {
        System.out.println(raiseToPower(3, 4));
    }
    /**
     * A method that raises a number to a power
     * @param base     - the number that ascends to a power
     * @param exponent - The degree to which to raise the number
     * @return - Returns the result of offering to the power
     */
    private double raiseToPower(double base, int exponent) {
        if (exponent == 0)
            return 1;
        double result = base;
        int mod = exponent;
        if (exponent < 0)
            mod = -exponent;
        for (int i = 1; i < mod; i++) {
            result *= base;
        }
        if (exponent < 0)
            return 1 / result;
        return result;
    }
}
