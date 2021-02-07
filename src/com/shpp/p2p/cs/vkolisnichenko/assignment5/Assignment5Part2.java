package com.shpp.p2p.cs.vkolisnichenko.assignment5;

import com.shpp.cs.a.console.TextProgram;

import java.util.ArrayList;

/**
 * A class in which 2 numbers are coordinated
 */
public class Assignment5Part2 extends TextProgram {
    @Override
    /**
     * The method in which the result of
     * adding 2 numbers is displayed in the console
     */
    public void run() {
        System.out.println(addNumericStrings("2111121324341234210", "4121121324341237210"));
    }

    /**
     * A method that takes 2 numbers in parameters,
     * smooths them, and returns the result in a string variable
     *
     * @param a - 1st number
     * @param b - 2nd number
     * @return - return sum;
     */
    private String addNumericStrings(String a, String b) {
        Integer number1;
        ArrayList<Integer> list1 = new ArrayList<>();
        char[] ch1 = a.toCharArray();
        for (int i = 0; i < ch1.length; i++) {
            number1 = Integer.parseInt(String.valueOf(ch1[i]));
            list1.add(number1);
        }
        Integer number2;
        ArrayList<Integer> list2 = new ArrayList<>();
        char[] ch2 = b.toCharArray();
        for (int i = 0; i < ch2.length; i++) {
            number2 = Integer.parseInt(String.valueOf(ch2[i]));
            list2.add(number2);
        }
        ArrayList<Integer> list3 = new ArrayList<>();
        Integer[] sum = new Integer[list1.size()];

        for (int i = 0; i < list1.size(); i++) {
            sum[i] = list1.get(i) + list2.get(i);
            if (sum[i] >= 10) {
                sum[i] = sum[i] - 10;
                sum[i - 1] = sum[i - 1] + 1;
                if (sum[i - 1] >= 10) {
                    sum[i - 1] = sum[i - 1] - 10;
                    sum[i - 2] = sum[i - 2] + 1;
                }
            }
        }
        for (int i = 0; i < list1.size(); i++) {
            list3.add(sum[i]);
        }
        String str = list3.toString();

        return str;
    }
}
