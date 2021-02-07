package com.shpp.p2p.cs.vkolisnichenko.assignment14;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * The class in which the methods for
 * unzipping the file are implemented
 */
public class UnArchive {
    //variables with filenames
    private final String readFile;
    private final String writeToFile;
    //number of bit
    private int numberOfBits;
    //maximum iteration for a row
    private static final int MAX_STRING_ITERATION = 10000;

    //The constructor in which we pass the filenames
    public UnArchive(String readFile, String writeToFile) {
        this.readFile = readFile;
        this.writeToFile = writeToFile;
    }

    /**
     * The method in which the file is unzipped
     * and written to another file using the
     * implementation of other methods
     */
    public void unArchiveFile() {
        try (DataInputStream inputStream = new DataInputStream(
                new FileInputStream(readFile)
        )) {
            // map with coding values and bytes
            HashMap<String, String> table = readTable(inputStream);
            //list with bits
            ArrayList<String> strings = new ArrayList<>();
            //read encrypted file
            String read = readContext(inputStream);
            //parse string
            parseString(strings, read);
            //get original values
            byte[] bytes = replaceValues(strings, table);
            //write to file
            writeUnArchiveValues(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Writing the unzipped byte values to a file
     *
     * @param bytes - bytes array
     * @throws Exception - can throw exception
     */
    private void writeUnArchiveValues(byte[] bytes) throws Exception {
        DataOutputStream outputStream = new DataOutputStream
                (new FileOutputStream(writeToFile));
        for (int i = 0; i < bytes.length; i++) {
            outputStream.write(bytes[i]);
        }
    }

    /**
     * A method in which we replace the encrypted
     * values in the sheet with ordinary byte
     * values and put them in a byte array
     *
     * @param strings - list with encoded strings
     * @param table   - map with encrypted values and their keys
     * @return - return byte array
     */
    private byte[] replaceValues(ArrayList<String> strings, HashMap<String, String> table) {
        byte[] bytes = new byte[strings.size()];
        for (int i = 0; i < strings.size(); i++) {
            if (table.containsKey(strings.get(i))) {
                bytes[i] = (byte) Integer.parseInt(table.get(strings.get(i)));
            }
        }
        return bytes;
    }

    /**
     * A method that parses a string with another
     * string and adds values to the sheet
     *
     * @param strings- list in which stored parsed string
     * @param read     - string with all bites
     */
    private void parseString(ArrayList<String> strings, String read) {
        String toList = "";
        for (int i = 1; i <= read.length(); i++) {
            toList = toList + read.charAt(i - 1);
            //if i is divisible by the number of bits we add to the sheet
            if ((i % numberOfBits) == 0) {
                strings.add(toList);
                toList = "";
            }
        }
    }

    /**
     * The method in which we read the encrypted data
     * from the file and translate it into binary form,
     * then add it to the string and return
     *
     * @param inputStream - input stream
     * @return - string with all file
     * @throws Exception - can throw exception
     */
    public String readContext(DataInputStream inputStream) throws Exception {
        int count = 0;

        ArrayList<String> list = new ArrayList<>();
        int coefficient = 1;
        String toList = "";
        String getAll = "";
        do {
            //read one byte
            int n = inputStream.read();
            if (n == -1) break;

            //parse to binary form
            String str = Integer.toBinaryString(n);
            str = addZeroToString(str);
            toList = toList + str;
            count++;
            //check string iteration
            if (count >= MAX_STRING_ITERATION * coefficient) {
                list.add(toList);
                toList = "";
                coefficient++;
            }
        } while (true);
        list.add(toList);

        //get big string
        for (int i = 0; i < list.size(); i++) {
            getAll = getAll + list.get(i);
        }
        return getAll;
    }

    /**
     * Method in which zeros are added to get 8 bits
     *
     * @param str- binary string
     * @return - 8bit string
     */
    private String addZeroToString(String str) {
        while (str.length() < 8) {
            //add 0 to string
            str = "0" + str;
        }
        return str;
    }

    /**
     * First, the first line is read, where the table
     * size and bit size are stored. Then the getCoding
     * method is called which reads the entire table
     *
     * @param inputStream - input stream
     * @return - map with values
     * @throws IOException - can throw exception
     */
    public HashMap<String, String> readTable(DataInputStream inputStream) throws IOException {
        int tableSize;
        HashMap<String, String> map = null;
        String information = inputStream.readLine();
        String[] strings = information.split(" ");
        tableSize = Integer.parseInt(strings[0]);
        numberOfBits = Integer.parseInt(strings[1]);
        map = getCoding(inputStream, tableSize);

        return map;
    }

    /**
     * The method in which the map is created to
     * store the encoding. Then we read the file
     * and put the values in the map until the table ends
     *
     * @param inputStream - input stream
     * @param tableSize   - table size
     * @return - map with encoded values
     * @throws IOException - can throw exception
     */
    private HashMap<String, String> getCoding(DataInputStream inputStream, int tableSize)
            throws IOException {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < tableSize; i++) {
            //read line from file
            String inputString = inputStream.readLine();
            //split string
            String[] spl = inputString.split(" ");
            //put in map values
            map.put(spl[1], spl[0]);
        }
        return map;
    }

}
