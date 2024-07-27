package com.codingpractice.dp;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/coin-change/description/
 *
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {

    public static void main(String args[]){

        CoinChange solution = new CoinChange();
        // Test cases
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println("Fewest coins needed: " + solution.coinChangeWithDp(coins1, amount1)); // Output: 3 (11 = 5 + 5 + 1)
    }


    private int coinChangeWithDp(int[] coins, int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0; // initialize the dp array.
        for(int coin : coins){
            for(int i = coin; i <= amount; i++){
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] == amount + 1? -1: dp[amount];
    }


}
