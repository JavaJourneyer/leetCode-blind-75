package com.codingpractice.dp;

import java.util.Arrays;

/**
 * Given an integer array nums, return the length of the longest strictly increasing
 * subsequence.
 * LC -M
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 */
public class LongestIncreasingSubsequence {

    public static void main(String args[]){
        LongestIncreasingSubsequence solution  = new LongestIncreasingSubsequence();
        int nums[] = {10,9,2,5,3,7,101,18};

        // Test cases
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Length of LIS: " + solution.lengthOfLIS(nums1)); // Output: 4

        int[] nums2 = {0, 1, 0, 3, 2, 3};
        System.out.println("Length of LIS: " + solution.lengthOfLIS(nums2)); // Output: 4

        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};
        System.out.println("Length of LIS: " + solution.lengthOfLIS(nums3)); // Output: 1

        int[] nums4 = {10, 20, 10, 30, 10, 40};
        System.out.println("Length of LIS: " + solution.lengthOfLIS(nums4)); // Output: 4


        int[] nums5 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Length of LIS: " + solution.lengthOfLISWithBinarySearch(nums5)); // Output: 4

        int[] nums6 = {0, 1, 0, 3, 2, 3};
        System.out.println("Length of LIS: " + solution.lengthOfLISWithBinarySearch(nums6)); // Output: 4

        int[] nums7 = {7, 7, 7, 7, 7, 7, 7};
        System.out.println("Length of LIS: " + solution.lengthOfLISWithBinarySearch(nums7)); // Output: 1

        int[] nums8 = {10, 20, 10, 30, 10, 40};
        System.out.println("Length of LIS: " + solution.lengthOfLISWithBinarySearch(nums8)); // Output: 4
    }

    /**
     * O(n^2) solution
     * @param nums
     * @return
     */
    private Integer lengthOfLIS(int[] nums) {

        int ans = 0;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1; // the longest subsequence of the first number is always 1 , right ?
        for (int i = 1; i < n; i++){
            int len = 0;
            for (int j = 0; j < i; j++ ){
                if(nums[i] > nums[j]){
                    len = Math.max(dp[j], len);
                }
                dp[i] = len + 1;
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    private Integer lengthOfLISWithBinarySearch(int[] nums){
        int ans = 0;
        int n = nums.length;
        int[] dp = new int[n];

        for (int num : nums){
            int index = Arrays.binarySearch(dp, 0, ans, num);
            System.out.println("Index: "+index);
            if(index < 0) {
                index = -(index+1);
            }
            dp[index] = num;

            if(index == ans) ans++;
        }
        return ans;
    }
}
