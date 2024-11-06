package com.guoyi;

import java.util.HashMap;
import java.util.Map;


public class SubarraySum {
    /*
    560 和为K的子数组
    给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
    子数组是数组中元素的连续非空序列。

    示例 1：
    输入：nums = [1,1,1], k = 2
    输出：2
    示例 2：
    输入：nums = [1,2,3], k = 3
    输出：2
     */

    //前缀和+哈希优化，时间复杂度、空间复杂度都是O（n）
    //https://leetcode.cn/problems/subarray-sum-equals-k/solutions/238572/he-wei-kde-zi-shu-zu-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked

    public static void main(String[] args) {
        int[] nums = {1, 2, -3, 1, 2};
        SubarraySum subarraySum = new SubarraySum();
        int n = subarraySum.subarraySum(nums, 1);
        System.out.println(n);
    }


    public int subarraySum(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> preSumMap = new HashMap<>();
        //初始化，当前缀和与k差值是0时，有1个解
        preSumMap.put(0, 1);
        int presum = 0;
        for (int i = 0; i < nums.length; i++) {
            presum = presum + nums[i];
            //去拿前一个map预设的解的个数，因为前置初始化map在前
            res = preSumMap.getOrDefault(presum - k, 0) + res;
            //为后面的计算准备map
            preSumMap.put(presum, preSumMap.getOrDefault(presum, 0) + 1);
        }
        return res;
    }


    //暴力解
    public int subarraySum1(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum == k) {
                res = res + 1;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum == k) {
                    res = res + 1;
                }
            }
        }
        return res;
    }

}
