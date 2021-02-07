package com.shpp.cs.assignments.arrays.tm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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
        ArrayList<Double> list = new ArrayList<>();
        double Sum_of_intensities = 0;
        for (int i = 0; i < toneMatrix.length; i++) {
            for (int j = 0; j < toneMatrix[i].length; j++) {
                if (toneMatrix[i][j] && column == j) {
                    Sum_of_intensities = Sum_of_intensities +
                            samples[i][(int) (ToneMatrixConstants.NUMBER_OF_SOUND /
                                    ToneMatrixConstants.NUMBER_OF_ROWS)];
                    list.add(Sum_of_intensities);
                    if (Sum_of_intensities >= 1) {
                        double x = Collections.max(list);
                        Sum_of_intensities = Sum_of_intensities / x;
                    } else if (Sum_of_intensities <= -1) {
                        double x = Collections.min(list);
                        Sum_of_intensities = Sum_of_intensities / x;
                    }
                    result[i] = Sum_of_intensities;
                }
            }
        }
        return result;
    }
}
