package com.jay.cci.arraystring;

import java.util.HashMap;
import java.util.Map;

/**
 *  Given two strings, write a method to decide if one is a permutation of the other.
 */
public class CheckPermutation {

    public static void main(String[] args) {

        String input1 = "AB";
        String input2 = "ABC";

        System.out.println("Solution 1 " + isPermutationSol2(input1, input2));
        System.out.println("Solution 2 " + isPermutationSol1(input1, input2));

        // Understanding of my problem was wrong
        System.out.println("My Solution " + isPermutationMine(input1, input2));
    }



    private static boolean isPermutationSol2 (String input1, String input2) {

        if(input1.length() != input2.length())
            return false;

        int[] asciiarr = new int[128];
        for (char each : input1.toCharArray())
            asciiarr[(int) each]++;

        for(int i = 0; i < input2.length(); i++) {
            int asciivalue = input2.charAt(i);

            asciiarr[asciivalue]--;
            if (asciiarr[asciivalue] < 0)
                return false;
        }

        return true;
    }

    private static boolean isPermutationSol1 (String input1, String input2) {

        if (input1.length() != input2.length())
            return false;
        return sort(input1).equals(sort(input2));
    }

    private static String sort (String input) {
        char[] arr = input.toCharArray();
        java.util.Arrays.sort(arr);
        return new String(arr);
    }


    /**
     * My solution. My understanding of permutation is wrong.
     * Assumed two string are permutation of each if one string
     * is a substring of another
     * @param input1
     * @param input2
     * @return
     */
    private static boolean isPermutationMine (String input1, String input2) {

        String shorter = input1.length() >= input2.length() ? input2 : input1;
        String longer = input1.length() > input2.length() ? input1 : input2;

        if (shorter.length() == longer.length())
            if (shorter.equals(longer))
                return true;

        Map<String, Boolean> permutations = new HashMap<>();

        for(int i = 0; i < longer.length() - shorter.length(); i++) {
            String key = "";
            for (int j = 0; j < shorter.length(); j++) {
                key += longer.charAt(i+j);
            }

            if (permutations.containsKey(key))
                return true;
            else
                permutations.put(key, true);
        }

        return permutations.containsKey(shorter);
    }

}
