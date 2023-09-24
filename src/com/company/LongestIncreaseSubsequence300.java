package com.company;

import java.util.Arrays;

public class LongestIncreaseSubsequence300 {

    //动态规划尝试缩小问题的规模，砍半缩小 或者 逐个缩小
    //子序列问题一般都涉及动态规划
    //首先动态规划要找到状态 及 状态转移表达式

    //最直接的尝试是把问题的解当做状态
    //针对长度为n的数组，其最大的递增子序列长度为dp[n]
    //长度为n-1的数组，最大长度为dp[n-1]
    //如果num[n]比dp[n-1]对应的序列中的最大数还要大，则最长序列可以延长
    //但想知道dp[n-1]最大数是谁，需要维护dp[n-1]中多个候选子序列以及各自的最大值，复杂度太高

    //关于状态的表达转变思路，能够通过dp记录的状态计算出最终的解
    //比如dp[n]中记录的是 包含n这个位置上字符的子序列最大长度，此时对应序列的最大值也就是nums[n]
    //对于dp[n]的值，可以通过nums[n]与nums[0..n-1]的值对比，如果之前比nums[n]小，则加上nums[n]会增加，遍历[0..n-1]之后找到最大的子序列
    //dp[n] = for i in range(0,n-1) if nums[n] > nums[i] dp[n] = max(dp[n], dp[i]+1)
    //这个解的巧法在于 各种子序列的解 被 平均记录在了各个位置上，并且这个序列的最大值也通过nums[n]表达出来

    public int lengthOfLIS(int[] nums) {

        //dp的意思是maxLISLengthContainCurrentDigit
        int[] dp = new int[nums.length];
        //初始化第一个字符长度
        dp[0] = 1;
        //从前向后遍历
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            //对于每一个字符，向前遍历
            //如果值比自己大，pass
            //如比自己小，则在其后+1与当前值比较
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        int[] list = {10,9,2,5,3,7,101,18};
        System.out.println(new LongestIncreaseSubsequence300().lengthOfLIS(list));
    }
}
