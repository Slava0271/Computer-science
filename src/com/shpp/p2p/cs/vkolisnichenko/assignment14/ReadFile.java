package com.shpp.p2p.cs.vkolisnichenko.assignment14;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * a class in which we get the bytes from the file,
 * sort the unique bytes in the file and get
 * the required bit size for encryption
 */
class ReadFile {
    //constant with maximum number of bit
    private static final int MAX_SIZE_OF_BIT = 8;
    //variable with filename
    private final String inputFile;

    ReadFile(String inputFile) {
        this.inputFile = inputFile;
    }

    /**
     * The method in which we get a byte array
     * that stores the bytes of the read file
     *
     * @return - byte array
     * @throws Exception - can throw exception
     */
    public byte[] getBytes() throws Exception {
        return Files.readAllBytes(Paths.get(inputFile));
    }

    /**
     * The method in which we create a sheet where
     * we will store unique bit values (no repetition)
     *
     * @return - list with bytes
     * @throws Exception - can throw exception
     */
    public ArrayList<Byte> getSortedBytes() throws Exception {
        ArrayList<Byte> list = new ArrayList<>();
        //get bytes
        byte[] bytes = getBytes();
        for (byte aByte : bytes) {
            //check if this element is already in the sheet
            if (!list.contains(aByte))
                list.add(aByte);
        }
        return list;
    }

    /**
     * The method in which we get the required
     * number of bits to encrypt the file
     *
     * @return - number of bits
     * @throws Exception - can throw exception
     */
    public int getNumberOfBits() throws Exception {
        for (int i = 1; i < MAX_SIZE_OF_BIT; i++) {
            if (Math.pow(2, i) >= getSortedBytes().size())
                return i;
        }
        return MAX_SIZE_OF_BIT;
    }

}
