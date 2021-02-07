package com.shpp.p2p.cs.vkolisnichenko.assignment17.previoushomeworks.assignment15;

import com.shpp.p2p.cs.vkolisnichenko.assignment17.previoushomeworks.collecctions.linkedlist.ListLinked;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * The class in which we encode the input file,
 * after which we create a table that stores the
 * encrypted values and the key. Then we write
 * encrypted data to the file
 */

public class Archive {
    //variables in which the file names will be stored
    private final String inputFile;
    private final String outputFile;

    //maximum length for one line
    private static final int MAX_STRING_SIZE = 10000;


    public Archive(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    /**
     * The method in which objects are created and various
     * methods are called to encode the data, after which
     * the method for writing to the file is called
     *
     * @throws Exception - can throw exception
     */
    public void archive() throws Exception {
        //create objects
        var sortBytes = new SortBytes();
        var huffman = new Huffman();
        //get file bytes
        byte[] bytes = sortBytes.getBytes(inputFile);

        //get list with objects
        ListLinked<TreesNode> linkedList = huffman.treesNodes(sortBytes.numberOfRepetitions(bytes));
        ListLinked<TreesNode> list = huffman.treesNodes(sortBytes.numberOfRepetitions(bytes));

//        //sort object by size
//        Collections.sort(list);
//        Collections.sort(linkedList);

        //call the huffman method
        var node = huffman.huffmanAlgorithm(linkedList);

        //get map with coded values
        HashMap<Byte, String> codes = huffman.coding(list, node);

        //get all coded strings
        ArrayList<StringBuilder> builderArrayList = encoder(bytes, codes);
        StringBuilder mainString = new StringBuilder();

        for (int i = 0; i < builderArrayList.size(); i++) {
            mainString.append(builderArrayList.get(i));
        }

        //write data to file
        writeToFile(codes, mainString);


    }

    /**
     * The method in which the bytes are replaced with their
     * encoded values from the map. All data is stored in
     * a sheet of string builders. They are needed if the file is too large.
     *
     * @param bytes - bytes input file
     * @param codes - map in with stores codes
     * @return list with encoded strings
     */
    private ArrayList<StringBuilder> encoder(byte[] bytes, HashMap<Byte, String> codes) {
        ArrayList<StringBuilder> stringBuilders = new ArrayList<>();
        StringBuilder encoder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            //add the coded bits to the string
            encoder.append(codes.get(bytes[i]));
            //check string size
            if (encoder.length() >= MAX_STRING_SIZE) {
                //add to list
                stringBuilders.add(encoder);
                encoder = new StringBuilder();
            }
        }
        stringBuilders.add(encoder);
        return stringBuilders;
    }


    /**
     * The method in which the data is written to the file.
     * First, a stream is opened in which data will be written,
     * after which the table is written. then we get the
     * parsed bytes and write them to the file
     *
     * @param map           - map with byte & coded value
     * @param stringBuilder - string with all bits
     */
    private void writeToFile(HashMap<Byte, String> map, StringBuilder stringBuilder) {
        try (DataOutputStream outputStream = new DataOutputStream(
                new FileOutputStream(outputFile)
        )) {
            //write table to file
            writeTable(map, outputStream);
            //We get a sheet with lines of 8 bits
            ArrayList<StringBuilder> list = parseString(stringBuilder);
            for (StringBuilder string : list) {
                //write information
                outputStream.write((char) Integer.parseInt(String.valueOf(string), 2));
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * A method in which we split the line with the
     * entire file in encrypted bits into smaller
     * lines of 8 bits, and then put them on the sheet
     *
     * @param stringBuilder - line with all coded bits
     * @return - list with coded bytes
     */
    private ArrayList<StringBuilder> parseString(StringBuilder stringBuilder) {
        ArrayList<StringBuilder> list = new ArrayList<>();
        StringBuilder put = new StringBuilder("");
        for (int i = 0; i < stringBuilder.length(); i++) {
            //append string while length<8
            put.append(stringBuilder.charAt(i));
            if ((put.length() % 8) == 0) {
                list.add(put);
                put = new StringBuilder();
            }
        }
        return list;
    }


    /**
     * The method in which we write to the file
     * a map of byte values - an encoded value.
     * We also write to the file one byte at a time.
     *
     * @param map          - map with bytes and codes
     * @param outputStream - output stream
     * @throws IOException - can throw exception
     */
    private void writeTable(HashMap<Byte, String> map, DataOutputStream outputStream) throws IOException {
        //get size table
        String sizeTable = Integer.toString(map.size());

        //write size  table
        for (int i = 0; i < sizeTable.length(); i++) {
            outputStream.write(sizeTable.charAt(i));
        }
        outputStream.write('\n');


        for (Byte b : map.keySet()) {
            //get map key
            String key = b.toString();
            //get map value
            String values = map.get(b);

            //write key
            for (int i = 0; i < key.length(); i++) {
                outputStream.write(key.charAt(i));
            }
            outputStream.write(' ');
            //write value
            for (int i = 0; i < values.length(); i++) {
                outputStream.write(values.charAt(i));
            }
            outputStream.write('\n');
        }
    }

}
