package com.zsw.leetcode;

public class Q122 {

    public int maxProfit(int[] prices) {
        int low = 0, high = 0;
        int i = 0;
        int profit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] > prices[i+1]) {
                i++;
            }
            low = prices[i];
            while (i < prices.length - 1 && prices[i] < prices[i+1]) {
                i++;
            }
            high = prices[i];
            profit += (high - low);
        }
        return profit;
    }
}
