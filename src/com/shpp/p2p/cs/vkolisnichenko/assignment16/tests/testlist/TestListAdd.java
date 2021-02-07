package com.shpp.p2p.cs.vkolisnichenko.assignment16.tests.testlist;

import com.shpp.p2p.cs.vkolisnichenko.assignment16.arraylist.ListArray;
import com.shpp.p2p.cs.vkolisnichenko.assignment16.interfaces.MyList;
import com.shpp.p2p.cs.vkolisnichenko.assignment16.linkedlist.ListLinked;
import com.shpp.p2p.cs.vkolisnichenko.assignment16.tests.Person;

import java.util.ArrayList;

/**
 * A class in which all methods are tested
 * for adding elements to lists
 */
public class TestListAdd {
    public boolean testAdd(MyList<String> list, String[] strings) {
        boolean result = false;
        for (String s :
                strings) {
            list.add(s);
        }
        try {
            result = checkAdd(strings, list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public <E> boolean testAdd(MyList<E> list, int size) {
        for (int i = 0; i < size; i++) {
            list.add((E) new Person(i, "Test"));
        }
        return size == list.size();
    }

    public boolean testListArrayAdd(int[] ints, ListArray<Integer> list) {
        for (int i = 0; i < ints.length; i++) {
            list.add(ints[i]);
        }
        int beginSize = list.size();
        int saveElement = list.get(2);
        list.add(2, 14);
        boolean firstTest = list.get(2) != saveElement;
        boolean secondTest = list.get(3) == saveElement;
        boolean thirdTest = list.size() == beginSize + 1;
        return firstTest && secondTest && thirdTest;
    }

    //todo add exception to индекс больше массива
    public boolean otherTestForArrayAdd(ListArray<String> builders, int countForTest) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < countForTest; i++) {
            list.add(Integer.toString(i));
        }
        for (int i = 0; i < list.size(); i++) {
            builders.add(0, list.get(i));
        }
        for (int i = 0; i < builders.size(); i++) {
            if (!builders.get(i).equals(list.get(list.size() - i - 1)))
                return false;

        }

        return list.size() == builders.size();
    }

    public boolean testFirstIndexLinkedListAdd(ListLinked<String> listLinked, String str) {
        String beginElement = "firstEl";
        listLinked.addFirst(beginElement);
        boolean firstCheck = listLinked.get(0).equals(beginElement);
        listLinked.add("2");
        boolean secondCheck = listLinked.get(0).equals(beginElement) && listLinked.get(1).equals("2");
        listLinked.addFirst(str);
        boolean thirdCheck = listLinked.get(0).equals(str) && listLinked.get(1).equals(beginElement);

        return firstCheck && secondCheck && thirdCheck;
    }


    public boolean testAdd(MyList<String> list) {
        boolean result = false;
        list.add("test");
        list.add("happy new year");
        list.add(String.valueOf(123));
        list.add(Byte.valueOf("12").toString());
        try {
            result = checkAdd(new String[]{"test", "happy new year", "123", "12"}, list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean testAdd(MyList<Integer> list, int[] integers) {
        boolean result = false;
        for (int i = 0; i < integers.length; i++) {
            list.add(integers[i]);
        }
        try {
            result = checkAdd(integers, list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private boolean checkAdd(int[] ints, MyList<Integer> list) throws Exception {
        boolean check = list.size() == ints.length;
        for (int i = 0; i < list.size(); i++) {
            if (!(ints[i] == list.get(i))) {
                throw new Exception("Add new items test failed\n");
            }
        }
        return check;
    }

    private boolean checkAdd(String[] strings, MyList<String> list) throws Exception {
        boolean check = list.size() == strings.length;
        for (int i = 0; i < list.size(); i++) {
            if (!strings[i].equals(list.get(i))) {
                throw new Exception("Add new items test failed\n");
            }
        }
        return check;
    }


}
