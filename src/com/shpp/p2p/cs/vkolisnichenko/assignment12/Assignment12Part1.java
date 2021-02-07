package com.shpp.p2p.cs.vkolisnichenko.assignment12;

/**
 * The class in which the depth-first search
 * algorithm is implemented to count the number
 * of silhouettes of people in the image
 */
public class Assignment12Part1 implements Constans {
    //A variable that will count the number of pixels that the algorithm went through at a time
    private static int countPixel = 0;

    /**
     * The method in which first checks whether
     * the user has entered arguments, after which
     * an object of class Image is created and the method
     * itself is executed to find silhouettes
     *
     * @param args - program arguments
     */
    public static void main(String[] args) throws Exception {
        String filename = null;
        if (args.length == 0) filename = DEFAULT_FILENAME;
        else if (args.length == 1) filename = args[0];
        else throw new Exception("You entered more than 1 argument");

        Image image = new Image();
        //get rgb values array
        int[][] imageArray = image.sortedValues(filename);
        //get number of silhouettes
        int countOfSilhouettes = findSilhouettes(imageArray);
        System.out.println(countOfSilhouettes);


    }

    /**
     * A method that runs through the entire image,
     * if it comes across a pixel that is not equal
     * to the background color, then depth-first search
     * is started, after which 1 silhouette is added
     *
     * @param imageArray - array with values background or not
     * @return - number of silhouettes
     */
    private static int findSilhouettes(int[][] imageArray) {
        int count = 0;
        for (int y = 0; y < imageArray.length; y++) {
            for (int x = 0; x < imageArray[y].length; x++) {
                //if not a background
                if (imageArray[y][x] == MARK_SILHOUETTES) {
                    depthFirstSearch(y, x, imageArray);
                    //check small object
                    if (countPixel > GARBAGE_FILTER)
                        count++;
                    countPixel = 0;
                }
            }
        }
        return count;
    }

    /**
     * A method that implements the depth-first
     * search algorithm using recursion to count
     * the number of silhouettes
     *
     * @param y     - у coordinate
     * @param x     - x coordinate
     * @param array - array with pixels
     */
    private static void depthFirstSearch(int y, int x, int[][] array) {
        //The variable we check if the silhouette is garbage
        countPixel++;
        //mark pixel
        array[y][x] = MARK_BACKGROUND;

        if (x < array[0].length - 1 && array[y][x + 1] != MARK_BACKGROUND) {
            depthFirstSearch(y, x + 1, array);
        }
        if (y < array.length - 1 && array[y + 1][x] != MARK_BACKGROUND) {
            depthFirstSearch(y + 1, x, array);
        }
        if (y > 0 && array[y - 1][x] != MARK_BACKGROUND) {
            depthFirstSearch(y - 1, x, array);
        }
        if (x > 0 && array[y][x - 1] != MARK_BACKGROUND) {
            depthFirstSearch(y, x - 1, array);
        }
    }
}
