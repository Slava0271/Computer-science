package com.shpp.cs.assignments.vkolisnichenko.arrays.tm;

import static java.lang.Math.abs;

public class ToneMatrixLogic {
    /**
     * Given the contents of the tone matrix, returns a string of notes that should be played
     * to represent that matrix.
     *
     * @param toneMatrix The contents of the tone matrix.
     * @param column     The column number that is currently being played.
     * @param samples    The sound samples associated with each row.
     * @return A sound sample corresponding to all notes currently being played.
     */
    public static double[] matrixToMusic(boolean[][] toneMatrix, int column, double[][] samples) {
        double[] result = new double[ToneMatrixConstants.sampleSize()];
        double max = 0;
        double min = 0;
        for (int i = 0; i < toneMatrix.length; i++) {
            if (toneMatrix[i][column]) {
                for (int j = 0; j < result.length; j++) {
                    result[j] = result[j] + samples[i][j];
                    if (result[j] > max) {
                        max = result[j];
                    } else if (result[j] < min) {
                        min = result[j];
                    }
                }
            }
        }
        return normalize(max, min, result);
    }

    /**
     * Normalizes sounds in the matrix
     * @param max    maximal value
     * @param min    minimal value
     * @param sample array with sounds
     * @return array with normalized sound.
     */
    public static double[] normalize(double max, double min, double[] sample) {
        if (max != 0 && max > abs(min)) {
            for (int i = 0; i < sample.length; i++) {
                sample[i] = sample[i] / max;
            }
        } else if (min != 0 && max < abs(min)) {
            for (int i = 0; i < sample.length; i++) {
                sample[i] = sample[i] / min;
            }
        }
        return sample;
    }
}