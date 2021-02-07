package com.shpp.p2p.cs.vkolisnichenko.assignment11;


import java.util.HashMap;
import java.util.Stack;

/**
 * A class that implements an improved calculator
 * with the implementation of brackets and
 * trigonometric functions
 */

public class Assignment11Part1 extends Checks{

    //The stack in which numbers are stored
    private static Stack<Double> numbers = new Stack<>();
    //The stack in which operations are stored
    private static Stack<Character> operations = new Stack<>();

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
            if (args.length >= 1) {
                //parse input expression
                parseExpression(args[0], readParameters(args));
                //get result
                getFinalResult(operations, numbers);
            } else System.err.println("You have not entered parameters");
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
     * @param variables   - map with parameters
     */
    private static void parseExpression(String inputString, HashMap<String, Double> variables) {
        //Create a class object Trigonometry
        Trigonometry trigonometry = new Trigonometry();
        int countBracket = 0;
        //a string to which numbers are added character by character
        var stringBuilder = new StringBuilder();
        //Translating an input string to an char array
        char[] charArray = inputString.toCharArray();

        //Loop through an array
        for (int i = 0; i < charArray.length; i++) {

            //Check for number and point
            if (isDigit(charArray[i]) || charArray[i] == '.') {
                stringBuilder.append(charArray[i]);
            }

            //Checking the symbol for the possibility of being a trinonometric operation
            if (trigonometry.isFunction(charArray, i)) {
                double number;
                StringBuilder functionValue = new StringBuilder();
                i = goToBracket(charArray, i);
                i++;
                if (isThereKey(variables, charArray, i)) {
                    number = variables.get(Character.toString(charArray[i]));
                    i += 1;
                } else {
                    while (charArray[i] != ')') {
                        functionValue.append(charArray[i]);
                        i++;
                    }
                    number = Double.parseDouble(functionValue.toString());
                }
                numbers.push(trigonometry.getOperation(trigonometry.getFunc(), number));
                if (isCloseBracket(i, charArray)) {
                    i++;
                    operations.push(charArray[i]);
                }
            }
            if (charArray[i] == '(' && i != 0) {
                operations.push(charArray[i]);
                countBracket++;
                continue;
            }

            if (isThereKey(variables, charArray, i)) {
                numbers.push(variables.get(Character.toString(charArray[i])));
            } else if (!isDigit(charArray[i]) || isLastCharacter(charArray, i)) {
                //If the string is correct, push the number onto the stack
                if (checkString(stringBuilder, charArray, i)) continue;
                numbers.push(Double.parseDouble(stringBuilder.toString()));
                stringBuilder = new StringBuilder();
            }
            if (!isLastCharacter(charArray, i) && isThereKey(variables, charArray, i))
                operations.push(charArray[i + 1]);

            if (!isDigit(charArray[i]) && isOperation(charArray[i])) {
                if (!operations.empty()) {
                    if (getPriority(charArray[i]) < getPriority(operations.peek())
                            && operations.peek() != '(') {
                        System.out.println(calculate(numbers, operations));
                        operations.push(charArray[i]);
                        continue;
                    }
                }
                operations.push(charArray[i]);
            }
            if (charArray[i] == ')' && i < charArray.length - 1) {
                while (!operations.empty()) {
                    if (operations.peek() == '(') break;
                    System.out.println(calculate(numbers, operations));
                    if (countBracket > 1 && operations.peek() == '(') operations.pop();
                }
                operations.push(charArray[i + 1]);
            }
        }
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
            if (operation.peek() == '(') {
                operation.pop();
            }
            System.out.println(calculate(numbers, operation));
        }
    }



    /**
     * A method that reads parameters from the
     * input expression and parses by the equal sign.
     * Then it puts in the hashmap the name of the
     * parameter and its value as a key
     *
     * @param args - program arguments
     * @return - map with parameters
     */
    private static HashMap<String, Double> readParameters(String[] args) {
        HashMap<String, Double> variables = new HashMap<>();
        for (int i = 1; i < args.length; i++) {
            String[] split = args[i].split("=");
            variables.put(split[0], Double.parseDouble(split[1]));
        }
        return variables;
    }


    /**
     * A method that goes forward through
     * an expression until we meet a parenthesis
     *
     * @param chars - character array
     * @param i     - count
     * @return - count value
     */
    private static int goToBracket(char[] chars, int i) {
        while (chars[i] != '(') {
            i++;
        }
        return i;
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