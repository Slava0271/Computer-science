package com.shpp.p2p.cs.vkolisnichenko.assignment5;

import com.shpp.cs.a.console.TextProgram;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * A class that is looking for a word with a license plate
 */
public class Assignment5Part3 extends TextProgram {
    //The constant that is responsible for the location of the file
    private static final String WORDS = "C:\\Users\\Славуха\\IdeaProjects\\Assignment5\\src\\com\\shpp\\p2p\\cs\\vkolisnichenko\\assignment5\\words.txt";

    /**
     * The method in which the licensePlate method is
     * called and displays the 1st word that
     * came from the letters
     */
    public void run() {
        try {
            licensePlate("7FTW142");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * A method that searches for the 1st
     * word that can be added with 3 letters,
     * if the word does not exist, an exception is generated
     *
     * @param plate - Number of the car
     * @throws Exception - if the word is impossible to add
     */

    private void licensePlate(String plate) throws Exception {
        String toLower = plate.toLowerCase();
        char ch[] = toLower.toCharArray();
        int index1, index2, index3;
        BufferedReader br = new BufferedReader(new FileReader(WORDS));
        String line = null;
        while (true) {
            line = br.readLine();
            checkExist(line);
            System.out.println(line);
            index1 = line.indexOf(ch[1]);
            if (index1 == 0 || index1 == 1 || index1 == 2) {
                index2 = line.indexOf(ch[2], index1 + 1);
                if (index2 > index1) {
                    index3 = line.indexOf(ch[3], index2 + 1);
                    if (index3 > index2) break;
                }
            }
        }
    }

    /**
     * The method that throws a word exception did not work out
     *
     * @param s - Line with BufferReader
     * @throws Exception - if words not exists
     */
    private void checkExist(String s) throws Exception {
        if (s == null) {
            throw new Exception("Words from these letters do not exist");
        }
    }


}