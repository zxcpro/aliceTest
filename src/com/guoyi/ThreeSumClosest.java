package com.guoyi;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSumClosest {

    /*
    16 最接近的三数之和
    给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
    返回这三个数的和。假定每组输入只存在恰好一个解。
    示例 1：
    输入：nums = [-1,2,1,-4], target = 1
    输出：2
    解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
    示例 2：
    输入：nums = [0,0,0], target = 1
    输出：0
     */

    /*
    https://leetcode.cn/problems/3sum-closest/solutions/6959/hua-jie-suan-fa-16-zui-jie-jin-de-san-shu-zhi-he-b/
    思考：排序+双指针
    1、数字排序，时间复杂度O(nlogn)
    2、对数组nums进行遍历，nums[i]的遍历空间是i+1，lenght-1；
    3、这里有个数学运算，如果==目标，就结束，如果不等于，那么比较差值绝对值，是否当前sum与target更接近
    4、双指针，小了增加，大了减少
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (ans != target && start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return ans;
    }
}
