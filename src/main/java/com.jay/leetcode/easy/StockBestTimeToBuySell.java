package com.jay.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Source https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 121. Best Time to Buy and Sell Stock
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 * Referemce - Used his logic
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/discuss/213451/Concise-Java-solution-Easy-to-understand
 */
public class StockBestTimeToBuySell {

    public static void main(String[] args) {
        int[] a1 = {7, 1, 5, 3, 6, 4};
        int[] a2 = {7, 6, 4, 3, 1};
        int[] a3 = {2, 4, 1};

        //System.out.println(new StockBestTimeToBuySell().maxProfit(a1));
        //System.out.println(new StockBestTimeToBuySell().maxProfit(a2));
        System.out.println(new StockBestTimeToBuySell().maxProfit(a3));

    }


    public int maxProfit(int[] prices) {

        if (prices.length == 0)
            return 0;

        int profit = 0;
        int prevMin = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            prevMin = Math.min(prevMin, prices[i]);
            profit = Math.max(profit, prices[i] - prevMin);
        }

        return profit;
    }


}
