package com.shpp.p2p.cs.vkolisnichenko.assignment12;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * A class that reads the file name,
 * after which it receives an image
 * and an array with rgb values
 */
class Image implements Constans {
    /**
     * A method in which an array with rgb values
     * is filtered and, as a result, an array
     * with values 0 or 1 is returned
     *
     * @param filename - filename
     * @return - return array with 0 | 1
     */
    protected int[][] sortedValues(String filename) {
        //get image
        var image = image(filename);
        //get rgb values
        int[][] rgbValues = rgbValues(image);
        int backgroundColor = getBackgroundColor(rgbValues);
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                //sort values
                if (rgbValues[y][x] == backgroundColor)
                    rgbValues[y][x] = MARK_BACKGROUND;
                else rgbValues[y][x] = MARK_SILHOUETTES;
            }
        }
        return rgbValues;
    }

    /**
     * A method that first reads the file,
     * then gets the image and returns it
     *
     * @param filename - filename
     * @return - image
     */
    private BufferedImage image(String filename) {
        var file = new File(filename);
        BufferedImage img = null;
        try {
            img = ImageIO.read(file);
        } catch (IOException exception) {
            System.err.println("You entered an invalid file name");
        }
        return img;
    }

    /**
     * An array that takes an image as input
     * and returns a two-dimensional array of rgb values
     *
     * @param image - input image
     * @return - array with rgb values
     */
    private int[][] rgbValues(BufferedImage image) {
        int[][] values = new int[image.getHeight()][image.getWidth()];

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                values[y][x] = image.getRGB(x, y);
            }
        }
        return values;
    }

    /**
     * A method that takes the 1st row in the
     * image and, depending on which color
     * dominates in it, determines the
     * background and returns it
     *
     * @param rgbValues - array with unsorted pixels
     * @return - background color
     */
    private int getBackgroundColor(int[][] rgbValues) {
        int[] firstRow = rgbValues[0];
        int firstPixel = firstRow[0];
        int otherPixel = 0;
        int countForFirst = 0;
        int countForOther = 0;
        for (int i = 1; i < firstRow.length; i++) {
            if (firstRow[i] != firstPixel) otherPixel = firstRow[i];
            if (firstRow[i] == firstPixel) countForFirst++;
            if (firstRow[i] == otherPixel) countForOther++;
        }
        if (countForFirst > countForOther)
            return firstPixel;
        return otherPixel;
    }
}
