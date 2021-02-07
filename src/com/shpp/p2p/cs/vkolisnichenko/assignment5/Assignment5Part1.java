package com.shpp.p2p.cs.vkolisnichenko.assignment5;

import com.shpp.cs.a.console.TextProgram;

/**
 * A class that counts the number of syllables
 */
public class Assignment5Part1 extends TextProgram {
    /**
     * A method that requests a word from the user and
     * displays the number of syllables in the console
     */
    public void run() {
        while (true) {
            System.out.println("Enter the word");
            System.out.println(syllablesInWord(readLine()) + " the number of syllables in a word");
        }
    }

    /**
     * A method that counts the number of syllables in a word
     */
    private int syllablesInWord(String word) {
        int syllables = 0;
        int i = 0;
        char[] ch = new char[]{'a', 'e', 'i', 'o', 'u', 'y'};
        String wordLower = word.toLowerCase();
        if (wordLower.equals("")) return 0;
        char[] result = wordLower.toCharArray();
        for (i = 0; i < result.length; i++) {
            for (int j = 0; j < ch.length; j++) {
                if (result[i] == ch[j] && i < result.length) {
                    syllables++;
                    try {
                        if (i < result.length - 1) {
                            while (i < result.length - 1 && result[i] == 'a' || result[i] == 'e' ||
                                    result[i] == 'i' || result[i] == 'o' || result[i] == 'u' || result[i] == 'y') i++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        return syllables;
                    }
                }
            }
        }
        if (syllables == 0 || syllables == 1) return 1;
        if (result[i - 1] == 'e') syllables--;
        return syllables;
    }
}
