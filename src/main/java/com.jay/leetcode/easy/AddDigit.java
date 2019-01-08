package com.jay.leetcode.easy;

/**
 * Source : https://leetcode.com/problems/add-digits/
 *
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *
 * Example:
 *
 * Input: 38
 * Output: 2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 *              Since 2 has only one digit, return it.
 *
 * Could you do it without any loop/recursion in O(1) runtime?
 *
 * Accepted in Leet Code - Runtime: 2 ms, faster than 40.51% of Java online submissions for Add Digits.
 *
 */
public class AddDigit {

    public static void main(String[] args) {
        System.out.println(new AddDigit().addDigits(19));
    }

    public int addDigits(int num) {

        int sum = 0;

        do {
            sum = sumAllDigit(num);
            num = sum;
        } while (sum >= 10);

        return sum;
    }

    private int sumAllDigit (int input) {
        int sum = 0;

        do {
            sum = sum + input % 10;
            input = input / 10;
        } while (input > 0);

        return sum;
    }
}
