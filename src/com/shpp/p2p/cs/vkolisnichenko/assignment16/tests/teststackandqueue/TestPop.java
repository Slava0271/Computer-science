package com.shpp.p2p.cs.vkolisnichenko.assignment16.tests.teststackandqueue;

import com.shpp.p2p.cs.vkolisnichenko.assignment16.interfaces.ForQueueAndStack;

/**
 * The class in which the method for the queue
 * and stack is tested for removing an element
 */
public class TestPop {
    boolean testPop(ForQueueAndStack<Character> characters, char[] chars) {
        System.out.println();
        System.out.println("Delete test in " + characters.getClass().getSimpleName());
        int beginSize = characters.size();
        boolean checkDelete;
        boolean checkSize;
        for (Character c :
                chars) {
            characters.push(c);
        }
        System.out.println("     Top element before delete : " + characters.peek());
        System.out.println("     Size before delete : " + characters.size());

        char popElement = characters.pop();
        checkDelete = popElement != characters.peek();
        System.out.println("     Top element after delete : " + characters.peek());
        System.out.println("     Size after delete : " + characters.size());
        checkSize = beginSize < characters.size();

        return checkDelete && checkSize;
    }
}
