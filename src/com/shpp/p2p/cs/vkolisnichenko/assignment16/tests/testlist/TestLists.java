package com.shpp.p2p.cs.vkolisnichenko.assignment16.tests.testlist;


import com.shpp.p2p.cs.vkolisnichenko.assignment16.arraylist.ListArray;
import com.shpp.p2p.cs.vkolisnichenko.assignment16.linkedlist.ListLinked;
import com.shpp.p2p.cs.vkolisnichenko.assignment16.tests.Person;

import java.util.Scanner;

/**
 * A class in which tests for collections are
 * run and a linked list for methods clear,contains,remove,set,add
 */
public class TestLists {
    /**
     * Method in which all test methods are called
     */
    public void testLists() {
        System.out.println();
        testAdd();
        testRemove();
        testSet();
        testContains();
        testClear();
    }

    /**
     * A method that creates an object of a class TestListClear that tests
     * cleanup and, depending on the result, displays a message to the console
     */
    private void testClear() {
        TestListClear testListClear = new TestListClear();
        //get test result
        boolean testClear = testListClear.testClear(new ListLinked<>(), new Number[]{21, 44});

        //output to console
        if (testClear)
            System.out.println(" -Cleaning was successful in " + ListLinked.class.getSimpleName());
        else System.err.println("Error while clearing list");
    }

    /**
     * A method that creates an object of a class TestListContains that tests
     * contains and, depending on the result, displays a message to the console
     */
    private void testContains() {
        TestListContains testListContains = new TestListContains();
        //get  first test result
        boolean testContainsArrayList = testListContains.testContains(new ListArray<>());
        //get second test result
        boolean testContainsLinkedList = testListContains.testContains(new ListLinked<>(), new int[]{12, -1, 25, 11});

        if (testContainsArrayList)
            System.out.println(" -Item contains test passed successfully in the " + ListArray.class.getSimpleName());
        else System.err.println("Element contains test failed in class " + ListArray.class.getSimpleName());

        if (testContainsLinkedList)
            System.out.println(" -Item content test passed successfully in the " + ListLinked.class.getSimpleName());
        else System.err.println("Element contains test failed in class " + ListLinked.class.getSimpleName());

    }

    /**
     * A method that creates an object of a class TestListSet that tests
     * method set and, depending on the result, displays a message to the console
     */
    private void testSet() {
        TestListSet testListSet = new TestListSet();
        //get tests results
        boolean testLinkedListSet = testListSet.testSet(new ListLinked<>());
        boolean testArrayListSet = testListSet.testSet(new ListArray<>(), new String[]{"test", "1", "", "west"});

        if (testArrayListSet)
            System.out.println(" -Value set was successful in class " + ListArray.class.getSimpleName());
        else System.err.println("Value set test failed in " + ListArray.class.getSimpleName());

        if (testLinkedListSet)
            System.out.println(" -Value set was successful in class " + ListLinked.class.getSimpleName());
        else System.err.println("Value set test failed in " + ListLinked.class.getSimpleName());

    }

    /**
     * A method that creates an object of a class TestListRemove that tests
     * remove method and, depending on the result, displays a message to the console
     */
    public void testRemove() {
        TestListRemove testListRemove = new TestListRemove();
        //get tests result
        boolean testArrayListRemove = testListRemove.testRemove(new ListArray<>());
        boolean testLinkedListRemove = testListRemove.testRemove(new ListLinked<>(), new char[]{'1', 'z', 'q', '/'});

        //output result to console
        if (testArrayListRemove)
            System.out.println(" -Removing items was successful, all tests passed from " + ListArray.class.getSimpleName());
        else System.err.println("Some tests failed when removed in " + ListArray.class.getSimpleName());

        if (testLinkedListRemove)
            System.out.println(" -Removing items was successful, all tests passed from " + ListLinked.class.getSimpleName());
        else System.err.println("Some tests failed when removed in " + ListLinked.class.getSimpleName());


    }

    /**
     * A method that creates an object of a class TestListAdd that tests
     * add method and, depending on the result, displays a message to the console
     */
    public void testAdd() {
        ListArray<String> listArray = new ListArray<>();
        ListLinked<Integer> listLinked = new ListLinked<>();
        ListArray<Person> people = new ListArray<>();
        TestListAdd testListAdd = new TestListAdd();

        //test list size with 1000 objects
        int countPeople = 1000;

        //get others test results
        boolean testLinkedListAdd = testListAdd.testAdd(listLinked, new int[]{12, 543, -1, 0});
        boolean testArrayListAdd = testListAdd.testAdd(listArray, new String[]{"test", "get", "a132435"});
        boolean testPersons = testListAdd.testAdd(people, countPeople);
        boolean firstTestAddToIndex = testListAdd.testListArrayAdd(new int[]{1, 2, 3, 4, 5, 6}, new ListArray<>());
        boolean secondTestAddToIndex = testListAdd.otherTestForArrayAdd(new ListArray<>(), countPeople);
        boolean testLinkedListFirstAdd = testListAdd.testFirstIndexLinkedListAdd(new ListLinked<>(), "zzz");

        //output results to console
        if (testLinkedListAdd)
            System.out.println(" -Adding items was successful to " + listLinked.getClass().getSimpleName());
        else System.err.println("Some items could not be added to " + listLinked.getClass().getSimpleName());

        if (testArrayListAdd)
            System.out.println(" -Adding items was successful to " + listArray.getClass().getSimpleName());
        else System.err.println("Some items could not be added to " + listArray.getClass().getSimpleName());

        if (testPersons)
            System.out.println(" -Adding " + countPeople + " people objects to the list was successful in class"
                    + people.getClass().getSimpleName());
        else System.err.println("Failed to add new objects in number " + countPeople +
                "in class " + people.getClass().getSimpleName());

        if (firstTestAddToIndex && secondTestAddToIndex)
            System.out.println(" -Item added by index was successful to " + listArray.getClass().getSimpleName());
        else System.err.println("Item added by index failed in " + listArray.getClass().getSimpleName());

        if (testLinkedListFirstAdd)
            System.out.println(" -Adding an item to the beginning  was successful to " + listLinked.getClass().getSimpleName());
        else
            System.err.println("Adding an item to the beginning of the list failed in " + listLinked.getClass().getSimpleName());
    }

    private int[] getInts() {
        int[] ints = new int[3];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter 3 integer value");
        for (int i = 0; i < 3; i++) {
            ints[i] = scanner.nextInt();
        }
        return ints;
    }

    private String[] getStrings() {
        String[] strings = new String[3];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter 3 string value");
        for (int i = 0; i < 3; i++) {
            strings[i] = scanner.nextLine();
        }
        return strings;
    }
}
