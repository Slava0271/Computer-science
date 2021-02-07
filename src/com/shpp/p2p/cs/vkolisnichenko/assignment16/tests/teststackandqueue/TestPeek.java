package com.shpp.p2p.cs.vkolisnichenko.assignment16.tests.teststackandqueue;

import com.shpp.p2p.cs.vkolisnichenko.assignment16.tests.Person;
import com.shpp.p2p.cs.vkolisnichenko.assignment16.interfaces.ForQueueAndStack;

/**
 * The class in which the method peek
 * is tested for the queue and stack
 */
public class TestPeek {
    boolean testPeek(ForQueueAndStack<Person> person, Person[] people) {
        System.out.println();
        System.out.println("Testing method peek in " + person.getClass().getSimpleName());
        boolean checkSize;
        boolean checkPeek;
        int beginSize = people.length;
        for (int i = 0; i < people.length; i++) {
            person.push(people[i]);
        }
        Person person1 = person.peek();
        System.out.println("     Received object from method peek\n     "
                + person1.getName() + " " + person1.getAge());
        checkPeek = person1.equals(person.peek());
        System.out.println("     Checking the top element after calling the method peek: ");
        System.out.println("     " + person.peek().getName() + " " + person.peek().getAge());
        System.out.println("     Check begin and final size:");
        System.out.println("     Start size: " + beginSize + " Final size: " + person.size());
        checkSize = beginSize == person.size();
        return checkPeek && checkSize;
    }

    boolean testPeek(ForQueueAndStack<Integer> integers, int[] ints) {
        System.out.println("Testing method peek in " + integers.getClass().getSimpleName());
        boolean checkSize;
        boolean checkPeek;
        boolean checkPeekAfterRemove;
        int beginSize = ints.length;
        for (int i = 0; i < ints.length; i++) {
            integers.push(ints[i]);
        }
        int saveFirstElement = integers.peek();
        System.out.println("     Received number from method peek: " + saveFirstElement);
        checkPeek = saveFirstElement == integers.peek();
        int del = integers.pop();
        System.out.println("     Delete number: " + del);
        int saveSecondElement = integers.peek();
        System.out.println("     Received number from method peek again: " + saveSecondElement);
        System.out.println("     Checking the element that lies on top and the first element after removal:");
        System.out.println("     Before deletion: " + saveFirstElement + " After: " + saveSecondElement);
        checkPeekAfterRemove = saveSecondElement == integers.peek()
                && saveSecondElement != saveFirstElement;
        checkSize = beginSize - 1 == integers.size();
        return checkPeek && checkPeekAfterRemove && checkSize;
    }

}
