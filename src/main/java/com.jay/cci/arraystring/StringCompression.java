package com.jay.cci.arraystring;

/**
 *
 * String Compression: Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
 * "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 *
 * Hints:#92, #110
 *
 */
public class StringCompression {

    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa"));
    }


    private static String compress (String input) {

        char[] inputarr = input.toCharArray();
        char[] outputarr = new char[input.length()];

        int i = 1; int currentCount = 1; char currentchar = ' '; int j = 0;
        while (i < input.length()) {
            if (inputarr[i] == inputarr[i - 1]) {
                currentCount++;
            }

            if (inputarr[i] != inputarr[i - 1] || i == input.length() - 1) {
                outputarr[j++] = inputarr[i - 1];
                outputarr[j++] = (char) (48 + currentCount);
                currentCount = 1;
            }
            i++;
        }

        return new String(outputarr);
    }

}
