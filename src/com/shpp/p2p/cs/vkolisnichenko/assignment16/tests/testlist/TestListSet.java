package com.shpp.p2p.cs.vkolisnichenko.assignment16.tests.testlist;

import com.shpp.p2p.cs.vkolisnichenko.assignment16.tests.Person;
import com.shpp.p2p.cs.vkolisnichenko.assignment16.interfaces.MyList;

/**
 * A class in which all methods are tested
 * for changing elements in lists
 */
public class TestListSet {
    boolean testSet(MyList<String> list, String[] strings) {
        boolean checkSize;
        boolean checkSet1;
        boolean checkSet2;
        for (String string : strings) {
            list.add(string);
        }
        int beginSize = list.size();
        String saveSet = list.get(1);
        String saveLast = list.get(list.size() - 1);
        list.set(1, "newValue");
        list.set(list.size() - 1, "testLast");
        checkSet1 = !list.get(1).equals(saveSet) && list.get(1).equals("newValue");
        checkSet2 = !list.get(list.size() - 1).equals(saveLast) && list.get(list.size() - 1).equals("testLast");
        checkSize = beginSize == list.size();

        return checkSet1 && checkSet2 && checkSize;
    }

    boolean testSet(MyList<Person> persons) {
        boolean checkSize;
        boolean checkSet;
        addPerson(persons);
        int beginSize = persons.size();
        Person person = persons.get(1);
        persons.set(1, new Person(17, "Alex"));
        checkSet = !person.getName().equals(persons.get(1).getName())
                && persons.get(1).getAge() == 17;
        checkSize = beginSize == persons.size();
        return checkSet && checkSize;

    }

    private void addPerson(MyList<Person> list) {
        list.add(new Person(20, "Anastasia"));
        list.add(new Person(24, "Irina"));
        list.add(new Person(18, "Ivan"));
    }

}
