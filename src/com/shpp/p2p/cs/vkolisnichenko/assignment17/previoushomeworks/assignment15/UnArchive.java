package com.shpp.p2p.cs.vkolisnichenko.assignment17.previoushomeworks.assignment15;

import com.shpp.p2p.cs.vkolisnichenko.assignment17.previoushomeworks.collecctions.arraylist.ListArray;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * The class in which the methods for
 * unzipping the file are implemented
 */
public class UnArchive {
    //variables with filenames
    private final String inputFile;
    private final String outputFile;

    //maximum length for one line
    private static final int MAX_STRING_SIZE = 10000;


    public UnArchive(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }


    /**
     * A method in which streams are created to read / write to a file,
     * after which we get a table with bytes and their encoded values.
     * After that, we create a sheet in which all the encoded
     * bits are stored, after which we create 1 string builder from them.
     * Then the decryption method is called and the decrypted
     * bytes are written to the file
     *
     * @throws Exception can throw exception
     */
    public void unArchive() throws Exception {
        //create input/output threads
        var inputStream = readFile();
        var outputStream = writeFile();

        //read table from file
        HashMap<Byte, String> tableMap = readTable(inputStream);
        //get all encoded bits
        ListArray<StringBuilder> builders = readFile(inputStream);
        StringBuilder read = new StringBuilder();
        for (StringBuilder builder : builders) {
            read.append(builder);
        }

        inputStream.close();

        //get decoded bytes
        ListArray<Byte> bytes = decode(read, tableMap);

        //write bytes to file
        for (Byte b : bytes) {
            outputStream.write(b);
        }
        outputStream.close();
    }

    /**
     * A method in which we get an array of encoded values,
     * after which, after replacement, we return an
     * array of original bytes
     *
     * @param stringBuilder - string with all encoded bits
     * @param codes         - map with bytes and encoded values
     * @return list with bytes
     */
    private ListArray<Byte> decode(StringBuilder stringBuilder, HashMap<Byte, String> codes) {
        //list with all read bytes
        ListArray<String> encoded = new ListArray<>();
        StringBuilder s = new StringBuilder();
        //list with map keys
        ListArray<String> mapKey = new ListArray<>();
        //list with map values
        ListArray<String> mapValues = new ListArray<>();

        //add map and values to list
        for (Byte b : codes.keySet()) {
            mapKey.add(b.toString());
            mapValues.add(codes.get(b));
        }

        for (int i = 0; i < stringBuilder.length(); i++) {
            s.append(stringBuilder.charAt(i));
            //checking for the presence of a code in the map
            if (mapValues.contains(s.toString())) {
                //add to string with all bytes
                encoded.add(s.toString());
                s = new StringBuilder();
            }
        }


        return bytes(encoded, mapKey, mapValues);
    }

    /**
     * The method in which the coded value is replaced
     * with the original one after which they are
     * added to the list and returned
     *
     * @param encoded   - list with all encoded values
     * @param mapKey    - map with bytes
     * @param mapValues -  map with encoded values
     * @return map with bytes
     */
    private ListArray<Byte> bytes(ListArray<String> encoded, ListArray<String> mapKey,
                                  ListArray<String> mapValues) {
        ListArray<Byte> bytes = new ListArray<>();
        for (int i = 0; i < encoded.size(); i++) {
            for (int j = 0; j < mapKey.size(); j++) {
                //If we find matches, add to the list
                if (encoded.get(i).equals(mapValues.get(j)))
                    bytes.add(Byte.valueOf(mapKey.get(j)));
            }
        }
        return bytes;
    }

    /**
     * a method in which the file is read byte by byte,
     * after which it is converted to a binary form and
     * added to the string builder, which is added
     * to the sheet with a large file
     *
     * @param inputStream - input stream
     * @return - list with strings
     * @throws Exception - can throw exception
     */
    private ListArray<StringBuilder> readFile(DataInputStream inputStream) throws Exception {
        ListArray<StringBuilder> stringBuilders = new ListArray<>();

        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            //read byte
            int k = inputStream.read();
            if (k == -1)
                break;

            //parse to binary
            String str = Integer.toBinaryString(k);
            while (str.length() < 8) {
                //add zero
                str = "0" + str;
            }

            //add parsed byte to big string
            stringBuilder.append(str);
            //check size
            if (stringBuilder.length() >= MAX_STRING_SIZE) {
                stringBuilders.add(stringBuilder);
                stringBuilder = new StringBuilder();
            }
        }
        stringBuilders.add(stringBuilder);
        return stringBuilders;
    }

    /**
     * First, the first line is read, where the table
     * size are stored. Then the getCoding
     * method is called which reads the entire table
     *
     * @param inputStream - input stream
     * @return - map with values
     * @throws IOException - can throw exception
     */

    private HashMap<Byte, String> readTable(DataInputStream inputStream) throws Exception {
        HashMap<Byte, String> map = new HashMap<>();
        int tableSize = Integer.parseInt(inputStream.readLine());
        for (int i = 0; i < tableSize; i++) {
            //read lines from file
            String read = inputStream.readLine();
            String[] split = read.split(" ");
            map.put(Byte.valueOf(split[0]), split[1]);
        }
        return map;
    }

    /**
     * method in which an object is created to read bytes from a file
     *
     * @return DataInputStream object
     */
    private DataInputStream readFile() {
        DataInputStream inputStream = null;
        try {
            inputStream = new DataInputStream(new FileInputStream(outputFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputStream;
    }

    /**
     * method in which an object is created to write bytes to a file
     *
     * @return DataOutputStream object
     */
    private DataOutputStream writeFile() {
        DataOutputStream outputStream = null;
        try {
            outputStream = new DataOutputStream(new FileOutputStream(inputFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outputStream;
    }
}
