package com.jay.cci.arraystring;

/**
 *  Write a method to replace all spaces in a string with '%20'.
 *  You may assume that the string has sufficient space at the end to hold the additional characters,
 *  and that you are given the "true" length of the string.
 *
 *  (Note: If implementing in Java, please use a character array so that you can perform this operation in place.)
 */
public class URLify {

    public static void main(String[] args) {

        String input = "Mr John Smith ";

        System.out.println(urlify(input, 13));
    }


    private static String urlify (String input, int buffer) {

        char[] inputarr = input.trim().toCharArray();
        char[] out = new char[input.trim().length() + buffer];

        int k = 0;
        for (int i = 0; i < input.trim().length(); i++) {

            if (inputarr[i] == ' ') {
                out[k++] = '%';
                out[k++] = '2';
                out[k++] = '0';
            } else {
                out[k++] = inputarr[i];
            }
        }

        return new String(out);
    }


}
