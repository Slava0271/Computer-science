package com.shpp.p2p.cs.vkolisnichenko.assignment17.tests.testpriorityqueue;

import com.shpp.p2p.cs.vkolisnichenko.assignment17.priorityqueue.MyPriorityQueue;

public class TestAdd {
    boolean testAddAndGet(MyPriorityQueue<Integer> myPriorityQueue, int[] ints, int lowElement) {
        for (int i = 0; i < ints.length; i++) {
            myPriorityQueue.add(ints[i]);
            System.out.println("Added element : " + ints[i] + " Top element: " + myPriorityQueue.get());
        }

        return myPriorityQueue.size() == ints.length &&
                myPriorityQueue.get() == lowElement;
    }
}
