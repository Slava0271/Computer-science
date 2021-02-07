package com.shpp.p2p.cs.vkolisnichenko.assignment16.tests.testlist;

import com.shpp.p2p.cs.vkolisnichenko.assignment16.tests.Person;
import com.shpp.p2p.cs.vkolisnichenko.assignment16.interfaces.MyList;

/**
 * A class in which all methods are tested for deletion in lists
 */
public class TestListRemove {
    boolean testRemove(MyList<Person> list) {
        boolean check1;
        boolean check2;
        boolean check3;
        addPersons(list);
        int beginSize = list.size();
        list.remove(0);
        check1 = beginSize == list.size() + 1;
        check2 = list.get(0).getName().equals("Marina")
                && list.get(0).getAge() == 25;
        check3 = list.get(list.size() - 1).getName().equals("Sophia");

        return check1 && check2 && check3;
    }

    boolean testRemove(MyList<Character> chars, char[] ch) {
        boolean check1;
        boolean check2;
        for (int i = 0; i < ch.length; i++) {
            chars.add(ch[i]);
        }
        int beginSize = chars.size();
        char remove = chars.remove(chars.size() - 1);
        check1 = beginSize - 1 == chars.size();
        check2 = chars.get(chars.size() - 1) != remove;

        return check1 && check2;
    }

    void addPersons(MyList<Person> list) {
        list.add(new Person(12, "Frank"));
        list.add(new Person(25, "Marina"));
        list.add(new Person(18, "Sophia"));
    }
}
