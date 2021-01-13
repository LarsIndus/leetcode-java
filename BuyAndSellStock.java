/*

Leetcode Problem 121: Best Time to Buy and Sell Stock (Easy)

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction
(i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Complexity for this solution:
O(n) time and O(1) space

*/

class BuyAndSellStock {
    
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
        int[] prices = {1, 3, 1, 6};
        //int[] prices = {4, 3, 2, 1};
        System.out.println(maxProfit(prices));
    }
}
