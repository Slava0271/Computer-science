package com.shpp.p2p.cs.vkolisnichenko.assignment16.tests.teststackandqueue;

import com.shpp.p2p.cs.vkolisnichenko.assignment16.tests.Person;
import com.shpp.p2p.cs.vkolisnichenko.assignment16.queue.MyQueue;
import com.shpp.p2p.cs.vkolisnichenko.assignment16.stack.MyStack;

/**
 * The class in which the methods for testing the
 * queue and stack are run, namely methods pop,peek,push
 */
public class TestStackAndQueue {
    public void testStackAndQueue() {
        testPeek();
        testPop();
        testPush();
    }

    /**
     * The method in which the method is checked for pop,
     * after which the result is output to the console
     */
    private void testPop() {
        //get test result
        boolean testPop = new TestPop().testPop(new MyQueue<>(), new char[]{'1', 'x', '-', 'u'});

        if (testPop)
            //output result
            System.out.println(" -Delete test passed successfully in " + MyQueue.class.getSimpleName());
        else System.err.println("Error while deleting item in " + MyQueue.class.getSimpleName());
    }

    /**
     * The method in which the method is checked for push,
     * after which the result is output to the console
     */
    private void testPush() {
        //get test result
        boolean testPush = new TestPush().testPush(new MyStack<>(), new String[]{"test", " ", "12"});
        if (testPush)
            System.out.println(" -Push item passed test successfully in " + MyStack.class.getSimpleName());
        else System.out.println("Error adding item ");
    }

    /**
     * The method in which the method is checked for peek,
     * after which the result is output to the console
     */
    private void testPeek() {
        //get first test result
        boolean testStackPeek = new TestPeek().testPeek(new MyStack<>(), new int[]{12, 18, -1, 4});

        //output to console
        if (testStackPeek)
            System.out.println(" -Top item view test passed successfully in " + MyStack.class.getSimpleName());
        else System.err.println("Error when trying to look at the top item in the list ");

        //get second test result
        boolean testQueuePeek = new TestPeek().testPeek(new MyQueue<>(), new Person[]{
                new Person(14, "Ivan"), new Person(43, "Roman")
        });

        //output
        if (testQueuePeek)
            System.out.println(" -Top item view test passed successfully in " + MyQueue.class.getSimpleName());
        else System.err.println("Error when trying to look at the top item in the list ");

    }
}
