/*

Leetcode Problem 322: Coin Change (Medium)

You are given coins of different denominations and a total amount of money 'amount'.
Write a function to compute the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Complexity for this solution:
O(n * amount) time and O(amount) space where n is the number of coins.

*/

import java.util.Arrays;

public class CoinChange {
    
    // DP approach
    public static int coinChange(int[] coins, int amount) {
        // create an array that stores the minimum number of coins needed for each amount up to the target amount
        int[] dp = new int[amount + 1];
        // initially fill it with something 'invalid'
        Arrays.fill(dp, amount + 1);
        // we need zero coins to make an amount of zero
        dp[0] = 0;

        // fill the array
        for (int i = 1; i <= amount; i++) {
            // try every coin
            for (int j = 0; j < coins.length; j++) {
                // only consider coins with a value less or equal the current amount
                if (coins[j] <= i) {
                    // If we use the current coin, we have an amount of i - coins[j] left.
                    // The minimum number of coins for that new amount is dp[i - coins[j]].
                    // We have to add 1 to account for the used coin j.
                    // Take the minimum of that value and the previous value.
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }


        return (dp[amount] > amount) ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }
}
