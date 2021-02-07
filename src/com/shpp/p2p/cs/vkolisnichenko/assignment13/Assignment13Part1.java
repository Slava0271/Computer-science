package com.shpp.p2p.cs.vkolisnichenko.assignment13;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * A class in which the breadth-first search
 * algorithm is implemented to find silhouettes
 * of people in the image, and then outputs
 * the result to the console
 */
public class Assignment13Part1 implements Constans {
    //The queue in which the pixels are stored which will be traversed by the algorithm
    private static Queue<int[]> queue = new LinkedList<>();
    //The variable that is used to increment the silhouette
    private static int countPixels = 0;

    /**
     * The method in which we get the image object,
     * then check for the presence of arguments and
     * run the breadth-first search algorithm
     *
     * @param args- program arguments
     */
    public static void main(String[] args) {
        var image = new Image();
        String filename = null;
        //If no arguments were entered
        if (args.length == 0)
            filename = DEFAULT_FILENAME;
            //if 1 argument
        else if (args.length == 1)
            filename = args[0];
        else System.err.println("You entered more than 1 parameter");

        int[][] rgbValues = image.sortedValues(filename);
        // get the number of silhouettes
        var countOfSilhouettes = findSilhouettes(rgbValues);
        System.out.println(countOfSilhouettes);
    }

    /**
     * A method that takes as input rgb image
     * values and then goes through them in an
     * array, and if it comes across a pixel that
     * is not equal to the background, it starts
     * a breadth-first search
     *
     * @param rgbValues - array with rgb values
     * @return - count of silhouettes
     */
    private static int findSilhouettes(int[][] rgbValues) {
        int[] coordinates = new int[2];
        int countOfSilhouettes = 0;
        for (int y = 0; y < rgbValues.length; y++) {
            for (int x = 0; x < rgbValues[y].length; x++) {
                coordinates[0] = y;
                coordinates[1] = x;
                if (rgbValues[y][x] != MARK_BACKGROUND) {
                    //add pixel to queue
                    queue.add(coordinates);
                    //start breadth-first search
                    breadthFirstSearch(rgbValues);
                    //check number of pixels
                    if (countPixels > GARBAGE_FILTER)
                        countOfSilhouettes++;
                    countPixels = 0;
                }
            }
        }
        return countOfSilhouettes;
    }

    /**
     * The method in which the breadth-first
     * search algorithm is implemented. First,
     * we get a pixel from the queue and mark
     * it as a background, after which we look
     * at the nearest pixels and if they are not
     * equal to the background color, then we
     * add them to the queue
     *
     * @param rgbValues - array with rgb values
     */
    private static void breadthFirstSearch(int[][] rgbValues) {
        //while queue is not empty
        while (!queue.isEmpty()) {
            countPixels++;
            //get the pixel
            int[] coordinates = queue.poll();
            //mark pixel
            rgbValues[coordinates[0]][coordinates[1]] = MARK_BACKGROUND;
            if (isTopPixel(coordinates, rgbValues)) {
                //subtract 1 by y coordinate
                coordinates[0] -= 1;
                //add to queue
                queue.add(Arrays.copyOf(coordinates, coordinates.length));
                rgbValues[coordinates[0]][coordinates[1]] = MARK_BACKGROUND;
                coordinates[0] += 1;
            }
            if (isDownPixel(coordinates, rgbValues)) {
                //add 1 in y coordinate
                coordinates[0] += 1;
                //add pixel to queue
                queue.add(Arrays.copyOf(coordinates, coordinates.length));
                rgbValues[coordinates[0]][coordinates[1]] = MARK_BACKGROUND;
                coordinates[0] -= 1;
            }
            if (isLeftPixel(coordinates, rgbValues)) {
                //subtract 1 by x coordinate
                coordinates[1] -= 1;
                //add pixel to queue
                queue.add(Arrays.copyOf(coordinates, coordinates.length));
                rgbValues[coordinates[0]][coordinates[1]] = MARK_BACKGROUND;
                coordinates[1] += 1;
            }
            if (isRightPixel(coordinates, rgbValues)) {
                //add 1 in x coordinate
                coordinates[1] += 1;
                queue.add(Arrays.copyOf(coordinates, coordinates.length));
                coordinates[1] -= 1;
            }
        }
    }

    /**
     * A method that checks that the pixel is not at
     * the edge of the image and that the pixel
     * on top is not equal to the background color
     *
     * @param coordinates - array with 1 pixel coordinate
     * @param rgbValues   - array with rgb values
     * @return - true or false
     */
    private static boolean isTopPixel(int[] coordinates, int[][] rgbValues) {
        return coordinates[0] > 0 &&
                rgbValues[coordinates[0] - 1][coordinates[1]] == MARK_SILHOUETTES;
    }

    /**
     * A method that checks that the pixel is not at
     * the edge of the image and that the pixel
     * below is not equal to the background color
     *
     * @param coordinates - array with 1 pixel coordinate
     * @param rgbValues   - array with rgb values
     * @return - true or false
     */
    private static boolean isDownPixel(int[] coordinates, int[][] rgbValues) {
        return coordinates[0] < rgbValues.length - 1 &&
                rgbValues[coordinates[0] + 1][coordinates[1]] == MARK_SILHOUETTES;
    }

    /**
     * A method that checks that the pixel is not at
     * the edge of the image and that the pixel on
     * the left is not equal to the background color
     *
     * @param coordinates - array with 1 pixel coordinate
     * @param rgbValues   - array with rgb values
     * @return - true or false
     */
    private static boolean isLeftPixel(int[] coordinates, int[][] rgbValues) {
        return coordinates[1] > 0 &&
                rgbValues[coordinates[0]][coordinates[1] - 1] == MARK_SILHOUETTES;
    }

    /**
     * A method that checks that the pixel is not
     * at the edge of the image and that the pixel
     * on the right is not equal to the background color
     *
     * @param coordinates - array with 1 pixel coordinate
     * @param rgbValues   - array with rgb values
     * @return - true or false
     */
    private static boolean isRightPixel(int[] coordinates, int[][] rgbValues) {
        return coordinates[1] < rgbValues[coordinates[0]].length - 1 &&
                rgbValues[coordinates[0]][coordinates[1] + 1] == MARK_SILHOUETTES;
    }
}