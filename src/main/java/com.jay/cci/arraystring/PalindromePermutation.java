package com.jay.cci.arraystring;

/**
 * Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards.
 * A permutation is a rearrangement of letters. The palindrome does not need to be
 * limited to just dictionary words.
 *
 * EXAMPLE Input: Tact Coa
 * Output: True (permutations: "taco cat", "atco eta", etc.)
 */
public class PalindromePermutation {

    public static void main(String[] args) {

        String input = "abcabc";
        String input1 = "abcab";

        System.out.println("Is Palindrome  - " + isPalindrome("abccb"));
        System.out.println("Reverse - " + reverse(input));

        System.out.println("isPalindromePermutation - " + isPalindromePermutation(input));
        System.out.println("isPalindromePermutation - " + isPalindromePermutation(input1));


    }


    private static boolean isPalindromePermutation (String input) {

        char[] inputchar = new char[128];

        for (int i=0; i < input.length(); i++) {
            int asciiValue = (int) input.charAt(i);
            inputchar[asciiValue]++;
        }

        int minalowedUniqueChar = 0;
        if (input.length() % 2 != 0) {
            minalowedUniqueChar++;
        }

        int currentUnigueChar = 0;
        for (int j = 0; j < inputchar.length; j++) {

            if(inputchar[j] %2 != 0) {
                if (currentUnigueChar <= minalowedUniqueChar)
                    currentUnigueChar++;
                else
                    return false;
            }
        }

        return true;

    }

    private static boolean isPalindrome (String input) {

        int start = 0;
        int end = input.length() - 1;
        char[] inputarr = input.toCharArray();

        while (start < end) {
            if (inputarr[start] != inputarr[end])
                return false;
            start++;
            end--;
        }

        return true;
    }

    private static String reverse(String input) {

        char[] inputarr = input.toCharArray();

        int mid = (input.length() + 1) /2;

        int l = input.length() - 1;
        for (int i = 0; i < mid; i++) {

            char temp = inputarr[i];
            inputarr[i] = inputarr[l];
            inputarr[l] = temp;

            l--;
        }

        return new String(inputarr);

    }

}
