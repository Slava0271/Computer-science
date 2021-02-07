package com.shpp.p2p.cs.vkolisnichenko.assignment16.tests.testlist;

import com.shpp.p2p.cs.vkolisnichenko.assignment16.interfaces.MyList;

/**
 * A class in which methods are tested
 * for the contain of elements in lists
 */
public class TestListContains {
    boolean testContains(MyList<Integer> list, int[] ints) {
        int size = ints.length;
        for (int i = 0; i < ints.length; i++) {
            list.add(ints[i]);
        }
        int first = ints[0];
        int last = ints[ints.length - 1];
        boolean firstTest = list.contains(first);
        boolean secondTest = list.contains(last);
        boolean thirdTest = size == list.size();
        return firstTest && secondTest && thirdTest;
    }

    boolean testContains(MyList<String> list) {
        boolean testContains = true;
        boolean checkFirst;
        String[] strings = new String[]{"test", "", "2021"};
        for (String s :
                strings) {
            list.add(s);
        }
        for (int i = 0; i < list.size(); i++) {
            if (!list.contains(strings[i])) {
                testContains = false;
                break;
            }
        }
        checkFirst = !list.contains("fake");

        return testContains && checkFirst;
    }

}
