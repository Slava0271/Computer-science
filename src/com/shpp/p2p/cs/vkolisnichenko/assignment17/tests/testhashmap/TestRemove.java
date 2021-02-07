package com.shpp.p2p.cs.vkolisnichenko.assignment17.tests.testhashmap;

import com.shpp.p2p.cs.vkolisnichenko.assignment17.hashmap.MyHashMap;

public class TestRemove {
    boolean testRemove(MyHashMap<String, Integer> myHashMap, String[] array) {
        int beginSize = myHashMap.size();
        myHashMap.remove(array[0]);
        boolean checkSize = myHashMap.size() == beginSize - 1;
        boolean checkRemove = myHashMap.get(array[0]) == null;

        return checkRemove && checkSize;
    }
}
