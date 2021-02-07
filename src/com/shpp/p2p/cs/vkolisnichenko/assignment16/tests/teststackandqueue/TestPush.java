package com.shpp.p2p.cs.vkolisnichenko.assignment16.tests.teststackandqueue;

import com.shpp.p2p.cs.vkolisnichenko.assignment16.interfaces.ForQueueAndStack;


/**
 * The class in which the method for the queue
 * and stack is tested for adding an element
 */
public class TestPush {
    boolean testPush(ForQueueAndStack<String> strings, String[] str) {
        System.out.println();
        System.out.println("Test push elements in " + strings.getClass().getSimpleName());
        boolean checkBeginSize = strings.size() == 0;
        boolean checkLastSize;
        boolean checkPushElement = true;
        for (int i = 0; i < str.length; i++) {
            System.out.println("    Queue/Stack size :" + strings.size());
            System.out.println("    Push element :" + str[i]);
            strings.push(str[i]);
            if (!strings.peek().contains(str[i])) {
                checkPushElement = false;
                System.err.println("    Error pushing item");
                break;
            }
        }
        System.out.println("    Queue/Stack size :" + strings.size());
        checkLastSize = str.length == strings.size();
        return checkBeginSize && checkPushElement && checkLastSize;
    }
}
