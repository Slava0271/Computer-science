package com.shpp.cs.vkolisnichenko.namesurfer;

/*
 * File: NameSurferEntry.java
 * --------------------------
 * This class represents a single entry in the database.  Each
 * NameSurferEntry contains a name and a list giving the popularity
 * of that name for each decade stretching back to 1900.
 */

import java.util.*;

public class NameSurferEntry implements NameSurferConstants {
    //The array that is formed when reading a string
    String[] str;
    //The variable that is responsible for the name
    String name;

    /* Constructor: NameSurferEntry(line) */

    /**
     * Creates a new NameSurferEntry from a data line as it appears
     * in the data file.  Each line begins with the name, which is
     * followed by integers giving the rank of that name for each
     * decade.
     */
    public NameSurferEntry(String line) {
        this.str = line.split(" ");
        name = str[0];
    }

    /* Method: getName() */

    /**
     * Returns the name associated with this entry.
     */
    public String getName() {
        return name;
    }

    /* Method: getRank(decade) */

    /**
     * Returns the rank associated with an entry for a particular
     * decade.  The decade value is an integer indicating how many
     * decades have passed since the first year in the database,
     * which is given by the constant START_DECADE.  If a name does
     * not appear in a decade, the rank value is 0.
     */
    public int getRank(int decade) {
        if (decade == START_DECADE) {
            return Integer.parseInt(str[1]);
        } else if (decade == START_DECADE + 10) {
            return Integer.parseInt(str[2]);
        } else if (decade == START_DECADE + 20) {
            return Integer.parseInt(str[3]);
        } else if (decade == START_DECADE + 30) {
            return Integer.parseInt(str[4]);
        } else if (decade == START_DECADE + 40) {
            return Integer.parseInt(str[5]);
        } else if (decade == START_DECADE + 50) {
            return Integer.parseInt(str[6]);
        } else if (decade == START_DECADE + 60) {
            return Integer.parseInt(str[7]);
        } else if (decade == START_DECADE + 70) {
            return Integer.parseInt(str[8]);
        } else if (decade == START_DECADE + 80) {
            return Integer.parseInt(str[9]);
        } else if (decade == START_DECADE + 90) {
            return Integer.parseInt(str[10]);
        } else if (decade == START_DECADE + 100) {
            return Integer.parseInt(str[11]);
        } else if (decade == START_DECADE + 110) {
            return Integer.parseInt(str[12]);
        } else {
            return 0;
        }
    }


    /* Method: toString() */

    /**
     * Returns a string that makes it easy to see the value of a
     * NameSurferEntry.
     */
    public String toString() {
        return getName() + " " + getRank(START_DECADE) + " " + getRank(START_DECADE + 10) + " " +
                getRank(START_DECADE + 20) + " " + getRank(START_DECADE + 30) + " " + getRank(START_DECADE + 40) +
                " " + getRank(START_DECADE + 50) + " " + getRank(START_DECADE + 60) + " " + getRank(START_DECADE + 70) +
                " " + getRank(START_DECADE + 80) + " " + getRank(START_DECADE + 90) + " " + getRank(START_DECADE + 100)
                + " " + getRank(START_DECADE + 110);
    }
}

