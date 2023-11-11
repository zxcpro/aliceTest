package com.guoyi;

import java.util.HashMap;

/**
 * Created by xuanchen.zhao on 2023/10/15.
 */
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
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int preSum = 0;
        //key是前缀和 value是key对应的前缀和的个数
        HashMap<Integer, Integer> preSumFreq = new HashMap<>();
        // 对于下标为 0 的元素，前缀和为 0，个数为 1，初始状态
        preSumFreq.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            preSum = preSum + nums[i];
            if (preSumFreq.containsKey(preSum - k)) {
                count = count + preSumFreq.get(preSum - k);

            }
            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3};
        SubarraySum subarraySum = new SubarraySum();
        int n = subarraySum.subarraySum(nums, 4);
        System.out.println(n);

    }
}