package com.shpp.p2p.cs.vkolisnichenko.assignment17.tests.testhashmap;

import com.shpp.p2p.cs.vkolisnichenko.assignment17.hashmap.MyHashMap;

public class TestGet {
    boolean testGet(MyHashMap<String, Integer> myHashMap, String[] array) {
        for (int i = 0; i < myHashMap.size(); i++) {
            if (myHashMap.get(array[i]) != i)
                return false;
        }
        return myHashMap.size() == array.length;
    }
}
