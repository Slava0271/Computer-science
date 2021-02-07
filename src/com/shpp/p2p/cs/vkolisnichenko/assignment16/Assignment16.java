package com.shpp.p2p.cs.vkolisnichenko.assignment16;

import com.shpp.p2p.cs.vkolisnichenko.assignment16.tests.testlist.TestLists;
import com.shpp.p2p.cs.vkolisnichenko.assignment16.tests.teststackandqueue.TestStackAndQueue;

/**
 * The class in which tests for collections are run
 */
public class Assignment16 {
    public static void main(String[] args) {
        //run test for queue and stack
        new TestStackAndQueue().testStackAndQueue();
        //run the test for lists
        new TestLists().testLists();
    }
}



