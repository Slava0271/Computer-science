package com.shpp.p2p.cs.vkolisnichenko.assignment7.namesurfer;

/*
 * File: NameSurferDataBase.java
 * -----------------------------
 * This class keeps track of the complete database of names.
 * The constructor reads in the database from a file, and
 * the only public method makes it possible to look up a
 * name and get back the corresponding NameSurferEntry.
 * Names are matched independent of case, so that "Eric"
 * and "ERIC" are the same names    .
 */


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class NameSurferDataBase implements NameSurferConstants {
    //Writes a line from a file
    ArrayList<String> list = new ArrayList<>();

    /* Constructor: NameSurferDataBase(filename) */

    /**
     * Creates a new NameSurferDataBase and initializes it using the
     * data in the specified file.  The constructor throws an error
     * exception if the requested file does not exist or if an error
     * occurs as the file is being read.
     */
    public NameSurferDataBase(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while (true) {
                line = br.readLine();
                if (line == null) break;
                list.add(line);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    /* Method: findEntry(name) */

    /**
     * Returns the NameSurferEntry associated with this name, if one
     * exists.  If the name does not appear in the database, this
     * method returns null.
     */
    public NameSurferEntry findEntry(String name) {
        String line = null;
        for (String string : list) {
            String[] spl = string.split(" ");
            if (spl[0].toLowerCase().equals(name.toLowerCase())) {
                line = string;
            }
        }
        if (line != null) {
            return new NameSurferEntry(line);
        }
        return null;
    }

}

