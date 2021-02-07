package com.shpp.p2p.cs.vkolisnichenko.assignment15;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;


/**
 * A class that has methods for getting bytes
 * from a file and sorting in a map by the
 * number of repetitions
 */
public class SortBytes {

    /**
     * The method in which we get a byte array
     * that stores the bytes of the read file
     *
     * @return - byte array
     * @throws Exception - can throw exception
     */
    public byte[] getBytes(String inputFile) throws Exception {
        return Files.readAllBytes(Paths.get(inputFile));
    }

    /**
     * The method in which we get a map with
     * the number of repetitions for each byte
     *
     * @param bytes - file bytes
     * @return - map with repetitions
     */
    public HashMap<Byte, Integer> numberOfRepetitions(byte[] bytes) {
        HashMap<Byte, Integer> map = new HashMap<>();
        Integer count;
        for (int i = 0; i < bytes.length; i++) {
            count = map.get(bytes[i]);
            //check if element exists
            if (count != null)
                map.put(bytes[i], count + 1);
            else map.put(bytes[i], 1);
        }
        return map;
    }

}
