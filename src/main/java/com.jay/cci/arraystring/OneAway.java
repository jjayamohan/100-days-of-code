package com.jay.cci.arraystring;

/**
 * One Away: There are three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given two strings, write a function to check if they are
 * one edit (or zero edits) away.
 *
 * EXAMPLE
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 *
 */
public class OneAway {

    public static void main(String[] args) {


        System.out.println(oneAway("pale", "ple"));
        System.out.println(oneAway("pales", "pale"));
        System.out.println(oneAway("aaaa", "aaa"));
        System.out.println(oneAway("pale", "bake"));

    }


    private static boolean oneAway(String input1, String input2) {

        System.out.println("Input1 - " + input1 + " Input2 - " + input2);
        char[] input1arr = input1.toCharArray();
        char[] input2arr = input2.toCharArray();

        if (input1.equals(input2))
            return true;

        int diff = input1arr.length > input2arr.length ? input1arr.length - input2arr.length : input2arr.length - input1arr.length;
        if (diff > 2)
            return false;

        if (diff == 0) {
            // SHOULD only be replace
            int replaceCount = 0;
            for (int i = 0; i < input1arr.length; i++) {
                if (input1arr[i] != input2arr[i]) {
                    replaceCount++;
                    if (replaceCount > 1)
                        return false;
                }
            }
        } else {

            int i = 0;
            int j = 0;
            int changedCount = 0;
            while (i < input1.length() && j < input2.length()) {

                if (input1arr[i] == input2arr[j]) {
                    i++;
                    j++;
                } else {
                    if (input1arr[i + 1] == input2arr[j]) {
                        i++;
                        changedCount++;
                    } else if (input1arr[i] == input2arr[j + 1]) {
                        j++;
                        changedCount++;
                    } else {
                        return false;
                    }
                }

                if (changedCount > 1)
                    return false;
            }
        }

        return true;
    }
}
