package com.jay.cci.arraystring;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */
public class IsUnique {

    public static void main(String[] args) {

        String input1 = "tes";
        String input2 = "test2t";

        System.out.println(isUniqueBruteForce(input1));
        System.out.println(isUniqueBruteForce(input2));

        System.out.println(isUnique(input1));
        System.out.println(isUnique(input2));
    }

    /**
     * Time complexity O(n)
     * @param input
     * @return
     */
    private static boolean isUnique(String input) {

        if (input.length() > 256)
            return false;

        boolean[] asciiFlagArray = new boolean[256];

        for (int i = 0; i < input.length(); i++) {
            int ascii  = (int) input.charAt(i);

            if(asciiFlagArray[ascii]) {
                return false;
            }

            asciiFlagArray[ascii] = true;
        }

        return true;
    }

    /**
     * Time complexity is o(n2)
     * @param input
     * @return
     */
    private static boolean isUniqueBruteForce(String input) {

        // Extended ascii length is 256 anything more then
        // our string has unique values
        if (input.length() > 256)
            return false;

        char[] inputarr = input.toCharArray();

        for (int i = 0; i < inputarr.length; i++) {
            for (int j = i + 1; j < inputarr.length; j++) {
                if (inputarr[i] == inputarr[j]) {
                    return false;
                }
            }
        }
        return true;
    }


}
