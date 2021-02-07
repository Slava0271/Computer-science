package com.shpp.p2p.cs.vkolisnichenko.assignment5;

import com.shpp.cs.a.console.TextProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The class that reads the file and returns the desired column
 */
public class Assignment5Part4 extends TextProgram {
    //The constant that is responsible for the location of the file
    private static final String FILE_NAME = "C:\\Users\\Славуха\\IdeaProjects\\Assignment5\\src\\com\\shpp\\p2p\\cs\\vkolisnichenko\\assignment5\\filename.csv";

    /**
     * Method that displays column information to the console
     */
    @Override
    public void run() {
        System.out.println(extractColumn(FILE_NAME, 0));
    }

    /**
     * a method that takes a string
     * from a file and returns an ArrayList <String>
     * containing all the fields from the string
     *
     * @param filename - filemaname
     * @param line     - row number
     * @return - row
     */
    private ArrayList<String> fieldsIn(String filename, String line) {
        int i = 0;
        i = Integer.parseInt(line);
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> row = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String str = null;
            while (true) {
                str = br.readLine();
                if (str == null) break;
                list.add(str + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        char c[] = list.get(i).toCharArray();
        for (int n = 0; n < c.length; n++) {
            String q = Character.toString(c[n]);
            row.add(q);
        }
        return row;
    }

    /**
     * @param filename    - filename
     * @param columnIndex - column number
     * @return -
     * the method which finds a column and
     * assigns to it an index then, returns
     * ArrayList which contains the information from this column
     */
    private ArrayList<String> extractColumn(String filename, int columnIndex) {
        int a = columnIndex;
        Integer ss = 0;
        String column1str = "";
        String column2str = "";
        int index = 0;
        ArrayList<String> column = new ArrayList<>();
        if (a == 0) {
            while (ss < 7) {
                String sw = ss.toString();
                ArrayList<String> s = fieldsIn(filename, sw);
                for (String i : s) {
                    column1str = column1str + i;
                    if (i.equals(",")) break;
                }
                ss = ss + 1;
            }
            column.add(column1str);
        }
        if (a == 1) {
            while (ss < 7) {
                String sw = ss.toString();
                ArrayList<String> g = fieldsIn(filename, sw);
                for (String i : g) {
                    index++;
                    if (i.equals(",")) break;
                }
                for (String j : g.subList(index, g.size())) {
                    column2str = column2str + j;
                }
                index = 0;
                ss = ss + 1;
            }
            column.add(column2str);
        }
        return column;
    }
}
