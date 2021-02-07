package com.shpp.p2p.cs.vkolisnichenko.assignment17.previoushomeworks.assignment11;

/**
 * A class that stores functions and a
 * variable for working with trigonometric formulas
 */
public class Trigonometry {
    //a variable in which the name of the trigonometric function will be stored
    private static String func = "";


    /**
     * A method that performs mathematical operations
     * depending on the function and returns the result
     *
     * @param func   = function
     * @param number - input number
     * @return - result
     */
    public double getOperation(String func, double number) {
        double result;
        if (func.equals(Functions.ATAN.getName())) {
            result = Math.atan(number);
        } else if (func.equals(Functions.LOG2.getName())) {
            result = Math.log(number);
        } else if (func.equals(Functions.LOG10.getName())) {
            result = Math.log10(number);
        } else if (func.equals(Functions.TAN.getName())) {
            result = Math.tan(number);
        } else if (func.equals(Functions.SIN.getName())) {
            result = Math.sin(number);
        } else if (func.equals(Functions.COS.getName())) {
            result = Math.cos(number);
        } else if (func.equals(Functions.SQRT.getName())) {
            result = Math.sqrt(number);
        } else result = 0;
        return result;
    }

    /**
     * Method that checks if symbols are a function or not
     *
     * @param chars - character array
     * @param i     - count
     * @return - true or false
     */
    public boolean isFunction(char[] chars, int i) {
        if (chars.length > i + 3 && chars[i] == 's' && chars[i + 1] == 'i' && chars[i + 2] == 'n') {
            func = "sin";
            return true;
        } else if (chars.length > i + 3 && chars[i] == 'c' && chars[i + 1] == 'o' && chars[i + 2] == 's') {
            func = "cos";
            return true;
        } else if (chars.length > i + 3 && chars[i] == 't' && chars[i + 1] == 'a' && chars[i + 2] == 'n') {
            func = "tan";
            return true;
        } else if (chars.length > i + 3 && chars[i] == 'a' && chars[i + 1] == 't' && chars[i + 2]
                == 'a' && chars[i + 3] == 'n') {
            func = "atan";
            return true;
        } else if (chars.length > i + 3 && chars[i] == 'l' && chars[i + 1] == 'o' && chars[i + 2] == 'g') {
            func = "log";
            return true;
        } else if (chars.length > i + 3 && chars[i] == 'l' && chars[i + 1] == 'o' && chars[i + 2] == 'g'
                && chars[i + 3] == '1' && chars[i + 4] == '0') {
            func = "log10";
            return true;
        } else if (chars.length > i + 3 && chars[i] == 's' && chars[i + 1] == 'q' && chars[i + 2]
                == 'r' && chars[i + 3] == 't') {
            func = "sqrt";
            return true;
        }
        return false;
    }

    /**
     * Returns the value of a variable
     *
     * @return - return value
     */
    public String getFunc() {
        return func;
    }
}
