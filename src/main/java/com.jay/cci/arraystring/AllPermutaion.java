package com.jay.cci.arraystring;

/**
 * Print all the permutation
 */
public class AllPermutaion {

    public static void main(String[] args) {
        permutation("abc", "");
    }

    private static void permutation(String input, String prefix) {

        int n = input.length();

        if (input.length() == 0)
            System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++) {
                permutation(input.substring(0, i) + input.substring(i + 1, n), prefix + input.charAt(i));
            }
        }
    }

}
