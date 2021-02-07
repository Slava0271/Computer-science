package com.shpp.p2p.cs.vkolisnichenko.assignment17.tests.testhashmap;

import com.shpp.p2p.cs.vkolisnichenko.assignment17.hashmap.MyHashMap;

public class TestPut {
    public boolean testPut(MyHashMap<String, Integer> myHashMap, String[] array) {
        int beginSize = array.length;
        boolean checkSize;
        for (int i = 0; i < array.length; i++) {
            myHashMap.put(array[i], i);
        }
        checkSize = beginSize == myHashMap.size();
        if (!checkSize)
            return false;

        for (int i = 0; i < myHashMap.size(); i++) {
            if (myHashMap.get(array[i]) != i)
                return false;
            System.out.println("key : " + array[i] + " value: " + i);
        }
        System.out.println("size : " + myHashMap.size());

        return true;
    }

}
