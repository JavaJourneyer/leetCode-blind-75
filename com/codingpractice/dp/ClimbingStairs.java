package com.codingpractice.dp;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * LC -E
 * https://leetcode.com/problems/climbing-stairs/description/
 */
public class ClimbingStairs {

    public static void main(String args[]){
        ClimbingStairs solution = new ClimbingStairs();
        System.out.println(" the solution:  "+solution.climbStairs(3));
    }

    private int climbStairs(int n){
        if(n <= 2) return n;
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1; // can take 1 or 2 steps at a time
        dp[2] = 2; // can take 1 or 2 steps at a time

        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
