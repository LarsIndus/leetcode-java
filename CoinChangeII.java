/*

Leetcode Problem 518: Coin Change 2 (Medium)

You are given coins of different denominations and a total amount of money.
Write a function to compute the number of combinations that make up that amount.
You may assume that you have infinite number of each kind of coin.

Complexity for this solution:
O(n * amount) time and space where n is the number of coins.

*/

public class CoinChangeII {
    
    // DP approach
    public static int change(int amount, int[] coins) {
        /*
        Create a 2D array, where rows represent coins (starting with no coins and then
        adding one coin at a time) and columns represent money amounts (starting with 0 up to the target amount). 
        The value in the cell represents the number of combinations to make up the respective amount
        with the available coins, i.e., the desired result is the value of the last cell.
        */
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1; // 1 way to make an amount of 0 with no coins

        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1; // exactly one way to make up an amount of 0
            for (int j = 1; j <= amount; j++) {
                // Case 1: don't use the new coin in row i, i.e., same value as one row above
                // (corresponds to coins[i - 1], note the index shift as we start with no coins in row 0!)
                dp[i][j] = dp[i - 1][j];
                if (coins[i - 1] <= j) {
                    // Case 2: If it is possible to use the new coin (check that its value is less than currrent amount j)
                    // substract the coin's value from j and get the corresponding value from the same row
                    // (i.e., using the same coins)
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }

        // print the array
        System.out.println("Full array looks as follows:");
        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[coins.length][amount];
    }

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println("\nNumber of combinations: " + change(amount, coins));
    }
}
