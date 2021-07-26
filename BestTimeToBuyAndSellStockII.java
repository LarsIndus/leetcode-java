/*

Leetcode Problem 122: Best Time to Buy and Sell Stock II (Easy)

You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like
(i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions simultaneously
(i.e., you must sell the stock before you buy again).

Complexity for this solution:
O(n) time and O(1) space

*/

public class BestTimeToBuyAndSellStockII {
    
    // Idea: Buy in "valleys" and sell on "peaks"
    public static int maxProfit(int[] prices) {
        int i = 0;
        int n = prices.length - 1;
        int buy = 0; // day to buy
        int sell = 0; // day to sell
        int maxProfit = 0;

        while (i < n) {
            // Find the cheapest day to buy (next "valley"): as long as prices are falling, move on.
            while (i < n && prices[i + 1] <= prices[i]) i++;
            buy = prices[i];

            // Find the highest price to sell (next "peak"): as long as prices are rising, move on.
            while (i < n && prices[i + 1] > prices[i]) i++;
            sell = prices[i];

            // Add subprofits to the overall profit.
            maxProfit += sell - buy;
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        //int[] prices = {4, 3, 2, 1};
        System.out.println(maxProfit(prices));
    }
}