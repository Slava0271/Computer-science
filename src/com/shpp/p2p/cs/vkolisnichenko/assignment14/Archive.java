package com.shpp.p2p.cs.vkolisnichenko.assignment14;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

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
    //constant with maximum number of bits
    private static final int MAX_SIZE_OF_BIT = 8;
    //maximum iteration for a row
    private static final int MAX_STRING_ITERATION = 10000;


    //The constructor in which we pass the filenames
    Archive(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    /**
     * The method in which we get all the bytes from
     * the file, then encode them with new
     * values, and put them in the map
     *
     * @param numberOfBits - bit size for encryption
     * @return - map with bytes and encoding values
     * @throws Exception - method can throw Exception
     */
    private HashMap<Byte, String> coding(int numberOfBits) throws Exception {
        ReadFile readFile = new ReadFile(inputFile);
        //get bytes
        ArrayList<Byte> sortedBytes = readFile.getSortedBytes();
        HashMap<Byte, String> map = new HashMap<>();
        //encoded byte value
        String value;
        for (int i = 0; i < readFile.getSortedBytes().size(); i++) {
            value = Integer.toBinaryString(i);
            //add 0 until the string size is equal to the desired bit size
            while (value.length() < numberOfBits)
                value = "0" + value;
            //put in map
            map.put(sortedBytes.get(i), value);
        }
        return map;
    }

    /**
     * A method in which we read bytes from a file,
     * get a map from the encoded values and make
     * a huge string until we read the entire file.
     * Then we parse this string, write the table
     * to a file and write the encoded values
     *
     * @throws Exception - method can throw exception
     */
    public void writeToFile() throws Exception {
        ReadFile readFile = new ReadFile(inputFile);
        //get bytes
        byte[] allBytes = readFile.getBytes();
        //get need bits length
        int numberOfBits = readFile.getNumberOfBits();
        //get map with encoding values
        HashMap<Byte, String> codingValues = coding(numberOfBits);
        ArrayList<String> strings = new ArrayList<>();

        try (DataOutputStream outputStream = new DataOutputStream(
                new FileOutputStream(outputFile)
        )) {
            //A list in which the entire encoded file will be stored in bits
            ArrayList<String> biggestString;
            //The line in which we split the previous one into 8 bits
            String parseForList = "";
            //write table to file
            writeTable(outputStream, numberOfBits, readFile);

            //get all file in bits
            biggestString = getBigString(allBytes, codingValues);

            String getAllBits = "";
            for (int i = 0; i < biggestString.size(); i++) {
                getAllBits = getAllBits + biggestString.get(i);
            }
            //parse biggestString
            parseString(getAllBits, parseForList, strings);
            //Writing encoded values to a file
            for (String string : strings) {
                outputStream.write((char) Integer.parseInt(string, 2));
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * We get a list that stores the entire file in encrypted bits
     *
     * @param bytes - array with bytes values
     * @param map   - map with encoded values
     * @return - return big string
     */
    private ArrayList<String> getBigString(byte[] bytes,
                                           HashMap<Byte, String> map) {
        ArrayList<String> list = new ArrayList<>();
        String str = "";
        int count = 1;
        int k = 0;
        for (int i = 0; i < bytes.length; i++) {
            str = str + map.get(bytes[i]);
            k++;
             //System.out.println(k + " " + bytes.length + " " + count);
            if (k >= MAX_STRING_ITERATION * (count)) {
                list.add(str);
                str = "";
                count++;
            }
        }
        list.add(str);
        return list;
    }

    /**
     * A method in which we split the line with the
     * entire file in encrypted bits into smaller
     * lines of 8 bits, and then put them on the sheet
     *
     * @param biggestString - string with all bits
     * @param parseForList  - The string needed for parsing
     * @param strings       - a sheet in which encrypted values of 8 bits are stored
     */
    private void parseString(String biggestString, String parseForList
            , ArrayList<String> strings) {
        for (int i = 1; i <= biggestString.length(); i++) {
            parseForList += biggestString.charAt(i - 1);
            if ((i % MAX_SIZE_OF_BIT) == 0) {
                strings.add(parseForList);
                parseForList = "";
            }
        }
    }

    /**
     * The method in which we get the size of the table,
     * the size of the bit and then write the table to the file
     *
     * @param outputStream - output stram
     * @param num          - number of bits
     * @param readFile     - object ReadFile class
     * @throws Exception - can throw Ecxeption
     */
    private void writeTable(DataOutputStream outputStream, int num,
                            ReadFile readFile) throws Exception {

        //list with sorted bytes
        ArrayList<Byte> bytes = readFile.getSortedBytes();
        //map with encoded values
        HashMap<Byte, String> map = coding(num);

        //table size
        int sizeTable = bytes.size();
        writeSizeInformation(outputStream, sizeTable, num);
        writeMapToFile(sizeTable, map, bytes, outputStream);
    }

    /**
     * The method in which we write to the file
     * the size of the table and the size of
     * the bit that we need to encode the file
     *
     * @param outputStream - output stream
     * @param sizeTable    - size table
     * @param num          - number of bits
     * @throws Exception - can throw exception
     */
    private void writeSizeInformation(DataOutputStream outputStream, int sizeTable, int num)
            throws Exception {
        String sizeT = Integer.toString(sizeTable);
        for (int i = 0; i < sizeT.length(); i++) {
            //write table size
            outputStream.write(sizeT.charAt(i));
        }
        outputStream.write(' ');
        //write number of bits
        outputStream.write(Integer.toString(num).charAt(0));
        outputStream.write('\n');
    }

    /**
     * The method in which we write to the file
     * a map of byte values - an encoded value.
     * We also write to the file one byte at a time.
     *
     * @param sizeTable    - table size
     * @param map          - map with encoded values
     * @param bytes        - all bytes in the file
     * @param outputStream - output stream
     * @throws Exception - can throw exception
     */
    private void writeMapToFile(int sizeTable, HashMap<Byte, String> map, ArrayList<Byte> bytes,
                                DataOutputStream outputStream) throws Exception {
        for (int i = 0; i < sizeTable; i++) {
            //get bytes
            String key = String.valueOf(bytes.get(i));
            //get encoded value
            String value = map.get(bytes.get(i));
            for (int j = 0; j < key.length(); j++) {
                //write bytes
                outputStream.write(key.charAt(j));
            }
            outputStream.write(' ');
            for (int j = 0; j < value.length(); j++) {
                //write encoded value
                outputStream.write(value.charAt(j));
            }
            outputStream.write('\n');
        }
    }

}
