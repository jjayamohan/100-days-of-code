package com.jay.leetcode.easy;

/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 *       Note:
 *
 *       The length of both num1 and num2 is < 5100.
 *       Both num1 and num2 contains only digits 0-9.
 *       Both num1 and num2 does not contain any leading zero.
 *       You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */

public class AddString {


    public static void main(String[] args) {
        AddString string = new AddString();
        System.out.println(string.addStrings("1234", "32"));
    }

    public String addStrings(String num1, String num2) {


        char[] num1arr = num1.toCharArray();
        char[] num2arr = num2.toCharArray();


        int num1lenght = num1arr.length;
        int num2lenght = num2arr.length;

        int resultlenght = num1lenght >= num1lenght ? num1lenght : num2lenght;
        char[] result = new char[resultlenght];

        if (num1lenght >= num2lenght) {

            boolean hascarry = false;

            for (int i = num2lenght - 1; i <= 0; i++) {


            }

        }

        return null;

    }

}
