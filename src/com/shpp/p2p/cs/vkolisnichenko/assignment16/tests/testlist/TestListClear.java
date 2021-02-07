package com.shpp.p2p.cs.vkolisnichenko.assignment16.tests.testlist;

import com.shpp.p2p.cs.vkolisnichenko.assignment16.interfaces.MyList;

/**
 * The class in which the method is tested
 * for deleting items in lists
 */
public class TestListClear {
    boolean testClear(MyList<Number> numberMyList, Number[] numbers) {
        boolean testClear;
        for (Number n :
                numbers) {
            numberMyList.add(n);
        }
        numberMyList.clear();
        testClear = numberMyList.size() == 0;

        return testClear;
    }
}
