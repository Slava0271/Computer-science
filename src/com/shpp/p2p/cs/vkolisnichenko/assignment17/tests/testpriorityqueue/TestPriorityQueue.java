package com.shpp.p2p.cs.vkolisnichenko.assignment17.tests.testpriorityqueue;

import com.shpp.p2p.cs.vkolisnichenko.assignment17.priorityqueue.MyPriorityQueue;

/**
 * The class in which all MyPriorityQueue
 * class  methods are tested
 */
public class TestPriorityQueue {
    public void testAddAndGet(MyPriorityQueue<Integer> queue, int[] ints, int lowElement) {
        System.out.println(" Testing priority queue");
        boolean testAdd = new TestAdd().testAddAndGet(queue, ints, lowElement);
        if (testAdd)
            System.out.println("Adding items to the priority queue was successful");
        else System.err.println("Testing of items in the priority queue failed");
    }

    public void testDelete(MyPriorityQueue<Integer> queue, int lowElement, int nextEl) {
        boolean testRemove = new TestRemove().testRemove(queue, lowElement, nextEl);
        if (testRemove)
            System.out.println("Testing removing items in the queue was successful");
        else System.err.println("Failed to delete items successfully");
    }
}
