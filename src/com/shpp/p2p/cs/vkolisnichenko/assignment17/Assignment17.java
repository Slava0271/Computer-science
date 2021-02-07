package com.shpp.p2p.cs.vkolisnichenko.assignment17;


import com.shpp.p2p.cs.vkolisnichenko.assignment17.hashmap.MyHashMap;
import com.shpp.p2p.cs.vkolisnichenko.assignment17.priorityqueue.MyPriorityQueue;
import com.shpp.p2p.cs.vkolisnichenko.assignment17.tests.testhashmap.TestHashMap;
import com.shpp.p2p.cs.vkolisnichenko.assignment17.tests.testpriorityqueue.TestPriorityQueue;

/**
 * A class in which arrays for testing
 * are created and tests for collections are run
 */
public class Assignment17 {

    public static void main(String[] args) {
        //create arrays for test
        String[] array = new String[]{"test", "qwerty", "asd", "java", "bus", "yxz", "fga"};
        int[] ints = new int[]{10, 54, 48, 5, 15, 11};

        //create collections for tests
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        MyPriorityQueue<Integer> queue = new MyPriorityQueue<>();

        //testing Hashmap
        TestHashMap testHashMap = new TestHashMap();
        testHashMap.testPut(array, myHashMap);
        testHashMap.testGet(array, myHashMap);
        testHashMap.testRemove(array, myHashMap);

        //testing PriorityQueue
        TestPriorityQueue priorityQueue = new TestPriorityQueue();
        priorityQueue.testAddAndGet(queue, ints, 5);
        priorityQueue.testDelete(queue, 5, 10);

    }
}
