package com.guoyi;

import java.util.HashMap;
import java.util.Map;

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
        //key是前缀和，value是key对应的前缀和的个数
        Map<Integer, Integer> preSumFreq = new HashMap<>(nums.length+1);
        // 初始状态,前缀和为0的有1个
        preSumFreq.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            preSum = preSum + nums[i];
            //判断前缀和是否是当前前缀和和目标值差值，假设当前perSum是y，当x+k=y，那么x到y的子列就是前缀和
            if (preSumFreq.containsKey(preSum - k)) {
                //前缀和-目标值=某个前缀和，说明这个差量的都是符合条件的目标子序列
                count = count + preSumFreq.get(preSum - k);
            }
            //放入前缀和到map中，每次把存入的key的次数value+1
            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,-3,1,2};
        SubarraySum subarraySum = new SubarraySum();
        int n = subarraySum.subarraySum(nums, 1);
        System.out.println(n);
    }


    public int subarraySum1(int[] nums, int k) {
        int res = 0;
        Map<Integer,Integer> preSumMap = new HashMap<>();
        for (int num : nums) {

        }


        return 0;
    }
}
