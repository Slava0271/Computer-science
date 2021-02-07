package com.shpp.p2p.cs.vkolisnichenko.assignment17.previoushomeworks.assignment11;

import java.util.HashMap;

/**
 *   An abstract class in which many checks
 *   are implemented in order to
 *   successfully parse the expression
 */
abstract class Checks {
    /**
     * A method that checks if the given parameter
     * is in the map or not, and returns true if yes
     *
     * @param map   - hashMap with parameters
     * @param chars - character array
     * @param i     - count
     * @return - return true or false
     */
    protected static boolean isThereKey(HashMap<String, Double> map, char[] chars, int i) {
        return map.containsKey(Character.toString(chars[i]));
    }

    /**
     * A method that checks if the string is empty
     * or if the character currently being tested is dot
     *
     * @param stringBuilder - input string
     * @param chars         - character array
     * @param i             - count
     * @return - true or false
     */
    protected static boolean checkString(StringBuilder stringBuilder, char[] chars, int i) {
        return stringBuilder.toString().isEmpty() || chars[i] == '.';
    }

    /**
     * Method that checks if a character is a number
     *
     * @param ch - character
     * @return - true or false
     */
    protected static boolean isDigit(char ch) {
        return Character.isDigit(ch);
    }

    /**
     * Method that returns true if character is an operator
     *
     * @param ch - symbol
     * @return - true or false
     */
    protected static boolean isOperation(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    /**
     * Method that checks if the counter
     * is at the end of the array or not
     *
     * @param chars - chars array
     * @param i     - counter
     * @return - true or false
     */
    protected static boolean isLastCharacter(char[] chars, int i) {
        return i == chars.length - 1;
    }

    /**
     * Checking if a character is a closing parenthesis
     *
     * @param i     - count
     * @param chars - character array
     * @return true or false
     */
    protected static boolean isCloseBracket(int i, char[] chars) {
        return i < chars.length - 1 && chars[i + 1] != ')';
    }
}
