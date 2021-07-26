/*

Leetcode Problem 121: Best Time to Buy and Sell Stock (Easy)

You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock
and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction.
If you cannot achieve any profit, return 0.

Complexity for this solution:
O(n) time and O(1) space

*/

class BestTimeToBuyAndSellStock {
    
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minBuy = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < minBuy) {
                minBuy = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minBuy);
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        //int[] prices = {4, 3, 2, 1};
        System.out.println(maxProfit(prices));
    }
}
