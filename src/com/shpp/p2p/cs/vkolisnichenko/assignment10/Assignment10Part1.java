package com.shpp.p2p.cs.vkolisnichenko.assignment10;

import java.util.HashMap;
import java.util.Stack;

/**
 * A class that implements a calculator for
 * operations addition, subtraction, division,
 * multiplication and exponentiation
 */

public class Assignment10Part1 {
    /**
     * The method that tries to call the method
     * that will calculate the expression,
     * in case of failure, will throw an exception
     *
     * @param args - program arguments
     */
    public static void main(String[] args) {
        try {
            //check the length of the array
            if (args.length >= 1)
                parseExpression(args[0], readParameters(args));
            else System.err.println("You have not entered parameters");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * A method that receives a stack with
     * operations and numbers as input.
     * This method performs mathematical operations
     *
     * @param numbers-   stack with numbers
     * @param operations - stack with operations
     * @return - return result
     */
    private static double calculate(Stack<Double> numbers, Stack<Character> operations) {
        //pop the first number off the stack
        double firstNumber = numbers.pop();
        //pop the second number off the stack
        double secondNumber = numbers.pop();
        //pop the operation off the stack
        char operation = operations.pop();

        System.out.println(secondNumber + " " + operation + " " + firstNumber);

        //Perform a mathematical action depending on the operation
        double result = switch (operation) {
            case '*' -> secondNumber * firstNumber;
            case '/' -> secondNumber / firstNumber;
            case '+' -> secondNumber + firstNumber;
            case '-' -> secondNumber - firstNumber;
            case '^' -> Math.pow(secondNumber, firstNumber);
            default -> 0;
        };
        //push the result onto the stack
        numbers.push(result);

        return result;
    }


    /**
     * A method that receives a string and a map
     * with parameters as input, it passes through
     * the string and many checks, after
     * which the result is calculated
     *
     * @param inputString - expression string
     * @param hashMap     - map with parameters
     */
    private static void parseExpression(String inputString, HashMap<String, Double> hashMap) {
        //a string to which numbers are added character by character
        var stringBuilder = new StringBuilder();
        //The stack in which numbers are stored
        Stack<Double> numbers = new Stack<>();
        //The stack in which operations are stored
        Stack<Character> operations = new Stack<>();
        //Translating an input string to an char array
        char[] charArray = inputString.toCharArray();

        //Loop through an array
        for (int i = 0; i < charArray.length; i++) {
            //Check for number and point
            if (isDigit(charArray[i]) || charArray[i] == '.') {
                stringBuilder.append(charArray[i]);
            }
            //Check if there is a key
            if (isThereKey(hashMap, charArray, i)) {
                numbers.push(hashMap.get(Character.toString(charArray[i])));
            } else if (!isDigit(charArray[i]) || isLastCharacter(charArray, i)) {
                //If the string is correct, push the number onto the stack
                if (checkString(stringBuilder, charArray, i)) continue;
                numbers.push(Double.parseDouble(stringBuilder.toString()));
                stringBuilder = new StringBuilder();
            }
            if (!isLastCharacter(charArray, i) && isThereKey(hashMap, charArray, i))
                operations.push(charArray[i + 1]);

            if (!isDigit(charArray[i]) && isOperation(charArray[i])) {
                if (!operations.empty()) {
                    if (getPriority(charArray[i]) < getPriority(operations.peek())) {
                        System.out.println(calculate(numbers, operations));
                        operations.push(charArray[i]);
                        continue;
                    }
                }
                operations.push(charArray[i]);
            }
        }
        getFinalResult(operations, numbers);
    }

    /**
     * A method that performs a computation operation
     * until the stack is empty, and displays
     * it on the screen
     *
     * @param operation - stack with operations
     * @param numbers   - stack with numbers
     */
    private static void getFinalResult(Stack<Character> operation, Stack<Double> numbers) {
        while (!operation.empty()) {
            System.out.println(calculate(numbers, operation));
        }
    }

    /**
     * A method that checks if the given parameter
     * is in the map or not, and returns true if yes
     *
     * @param map   - hashMap with parameters
     * @param chars - character array
     * @param i     - count
     * @return - return true or false
     */
    private static boolean isThereKey(HashMap<String, Double> map, char[] chars, int i) {
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
    private static boolean checkString(StringBuilder stringBuilder, char[] chars, int i) {
        return stringBuilder.toString().isEmpty() || chars[i] == '.';
    }

    /**
     * A method that processes parameters
     * and returns a map name - value
     *
     * @param args - program arguments
     * @return - map
     */
    private static HashMap<String, Double> readParameters(String[] args) {
        HashMap<String, Double> variables = new HashMap<>();
        char[] chars;
        String number = "";
        for (int i = 1; i < args.length; i++) {
            chars = args[i].toCharArray();
            for (int j = 2; j < chars.length; j++) {
                number += chars[j];
                variables.put(Character.toString(chars[0]), Double.parseDouble(number));
            }
            number = "";
        }
        return variables;
    }

    /**
     * Method that checks if a character is a number
     *
     * @param ch - character
     * @return - true or false
     */
    private static boolean isDigit(char ch) {
        return Character.isDigit(ch);
    }

    /**
     * Method that returns true if character is an operator
     *
     * @param ch - symbol
     * @return - true or false
     */
    private static boolean isOperation(char ch) {
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
    private static boolean isLastCharacter(char[] chars, int i) {
        return i == chars.length - 1;
    }

    /**
     * A method that prioritizes mathematical operations
     *
     * @param ch - character
     * @return - return priority
     */
    private static int getPriority(char ch) {
        return switch (ch) {
            case '^' -> 3;
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> 0;
        };
    }
}