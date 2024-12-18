package com.guoyi;

import java.util.Arrays;

public class lengthOfLIS {

    /*
    300  最长递增子序列
    给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
    子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
    示例 1：
    输入：nums = [10,9,2,5,3,7,101,18]
    输出：4
    解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
    示例 2：
    输入：nums = [0,1,0,3,2,3]
    输出：4
    示例 3：
    输入：nums = [7,7,7,7,7,7,7]
    输出：1
     */

    /*
    思考：动态规划
    1、创建数组dp[]，dp[i]用来记录该位置的解
    2、那么dp[i] = Math.max(dp[i],dp[j]+1); //（j<i），在nums[j]<nums[i]时
    3、遍历nums，记录每个dp[i]
    4、遍历i，用j求得i
    5、记录解，由于结果不一定是i这个位置的最长，中间最长的也要记录下来，res = Math.max(res, dp[i]);
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }


}
