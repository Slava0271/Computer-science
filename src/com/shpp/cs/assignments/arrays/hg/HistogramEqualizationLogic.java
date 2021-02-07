package com.shpp.cs.assignments.arrays.hg;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class HistogramEqualizationLogic {
    private static final int MAX_LUMINANCE = 255;

    /**
     * Given the luminances of the pixels in an image, returns a histogram of the frequencies of
     * those luminances.
     * <p/>
     * You can assume that pixel luminances range from 0 to MAX_LUMINANCE, inclusive.
     *
     * @param luminances The luminances in the picture.
     * @return A histogram of those luminances.
     */
    public static int[] histogramFor(int[][] luminances) {
        int[] histogram = new int[MAX_LUMINANCE + 1];

        for (int k = 0; k < histogram.length; k++) {
            for (int i = 0; i < luminances.length; i++) {
                for (int j = 0; j < luminances[i].length; j++) {
                    if (k == luminances[i][j]) {
                        histogram[k]++;
                    }
                }
            }
        }
        return histogram;
    }

    /**
     * Given a histogram of the luminances in an image, returns an array of the cumulative
     * frequencies of that image.  Each entry of this array should be equal to the sum of all
     * the array entries up to and including its index in the input histogram array.
     * <p/>
     * For example, given the array [1, 2, 3, 4, 5], the result should be [1, 3, 6, 10, 15].
     *
     * @param histogram The input histogram.
     * @return The cumulative frequency array.
     * <p>
     */
    public static int[] cumulativeSumFor(int[] histogram) {
        int[] sum = new int[histogram.length];
        for (int i = 0; i < sum.length; i++) {
            if (i == 0) {
                sum[i] = histogram[i];
            } else {
                sum[i] = histogram[i] + sum[i - 1];
            }
        }
        return sum;
    }

    /**
     * Returns the total number of pixels in the given image.
     *
     * @param luminances A matrix of the luminances within an image.
     * @return The total number of pixels in that image.
     */
    public static int totalPixelsIn(int[][] luminances) {
        int total = 0;
        for (int i = 0; i < luminances.length; i++) {
            for (int j = 0; j < luminances[i].length; j++) {
                total++;
            }
        }
        return total;
    }

    /**
     * Applies the histogram equalization algorithm to the given image, represented by a matrix
     * of its luminances.
     * <p/>
     * You are strongly encouraged to use the three methods you have implemented above in order to
     * implement this method.
     *
     * @param luminances The luminances of the input image.
     * @return The luminances of the image formed by applying histogram equalization.
     */
    public static int[][] equalize(int[][] luminances) {
        int width = 0, height = 0;
        for (int i = 0; i < luminances.length; i++) {
            for (int j = 0; j < luminances[i].length; j++) {
                width++;
            }
            height++;
        }
        int newwidth = width / luminances.length;
        int[][] total = new int[newwidth][height];
        int Nowluminances;
        double newLuminance;
        double PixelAlignment;
        for (int i = 0; i < luminances.length; i++) {
            for (int j = 0; j < luminances[i].length; j++) {
                Nowluminances = luminances[i][j];
                newLuminance = MAX_LUMINANCE * (double) histogramFor(luminances)[Nowluminances]
                        / (double) totalPixelsIn(luminances);
                PixelAlignment = newLuminance * 100;
                total[i][j] = (int) PixelAlignment;
            }
        }
        return total;
    }
}
