package com.shpp.cs.vkolisnichenko.namesurfer;

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

import acm.graphics.GLine;
import com.shpp.cs.a.graphics.WindowProgram;
import com.shpp.cs.a.simple.SimpleProgram;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class NameSurferDataBase  implements NameSurferConstants {

    /* Constructor: NameSurferDataBase(filename) */

    /**
     * Creates a new NameSurferDataBase and initializes it using the
     * data in the specified file.  The constructor throws an error
     * exception if the requested file does not exist or if an error
     * occurs as the file is being read.
     */
    //The variable is false until the desired row is found.
    boolean b = false;
    NameSurferEntry nameSurferEntry;

    public NameSurferDataBase(String filename, String name) {
        String str;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            while (true) {
                str = bufferedReader.readLine();
                String line = str.toLowerCase();
                if (bufferedReader == null) break;
                this.nameSurferEntry = new NameSurferEntry(line);
                findEntry(name);
                if (b) break;
            }
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }

    /* Method: findEntry(name) */

    /**
     * Returns the NameSurferEntry associated with this name, if one
     * exists.  If the name does not appear in the database, this
     * method returns null.
     */
    public NameSurferEntry findEntry(String name) {
        if (name.equals(nameSurferEntry.getName())) {
            System.out.println(nameSurferEntry.toString());
            this.b = true;
            return nameSurferEntry;
        }
        return null;
    }


}

