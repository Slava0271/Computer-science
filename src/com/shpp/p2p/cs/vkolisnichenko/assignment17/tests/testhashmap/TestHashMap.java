package com.shpp.p2p.cs.vkolisnichenko.assignment17.tests.testhashmap;

import com.shpp.p2p.cs.vkolisnichenko.assignment17.hashmap.MyHashMap;

/**
 * The class in which all MyHashMap
 * class  methods are tested
 */
public class TestHashMap {

    public void testPut(String[] array, MyHashMap<String, Integer> myHashMap) {
        System.out.println("Testing put");
        boolean testPut = new TestPut().testPut(myHashMap, array);
        if (testPut)
            System.out.println("Addition test passed successfully");
        else System.err.println("Failed to add items to the map");
    }

    public void testGet(String[] array, MyHashMap<String, Integer> myHashMap) {
        boolean testGet = new TestGet().testGet(myHashMap, array);
        if (testGet)
            System.out.println("Method get testing was successful ");
        else System.err.println("Failed to pass method get testing");
    }

    public void testRemove(String[] array, MyHashMap<String, Integer> myHashMap) {
        boolean testRemove = new TestRemove().testRemove(myHashMap, array);
        if (testRemove)
            System.out.println("Deleting map elements was successful");
        else System.err.println("Failed to remove items from the map");
    }


}
