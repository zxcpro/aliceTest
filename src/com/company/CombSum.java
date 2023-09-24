package com.company;

import java.util.*;

public class CombSum {
    private List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {2,3,5};
        System.out.println(new CombSum().combSum(nums, 8));
    }

    public List<List<Integer>> combSum(int[] nums, int target) {
        //采用缩减target的方式

        //升序排序
        Arrays.sort(nums);
        List<Integer> oneComb = new ArrayList<>();
        combSumRecur(nums, target, oneComb, nums.length - 1);
        return ans;

    }

    public void combSumRecur(int[] nums, int target, List<Integer> oneComb, int lastIndex) {
        //取一个nums中的值，target减去该值
        //为了保证不重复，排序后，只接受从大到小的解

        //已经为负数，不可能组成解
        if (target < 0) {
            return;
        }

        //组成了目标解，记录全局
        if (target == 0) {
            ans.add(new ArrayList<>(oneComb));
            return;
        }

        //由大到小去掉一个数字
        for (int i = lastIndex; i >= 0; i--) {
            int remains = target - nums[i];
            //记录当前解
            oneComb.add(nums[i]);
            combSumRecur(nums, remains, oneComb, i);
            //回溯删除这个解，继续遍历
            oneComb.remove(oneComb.size() - 1);
        }
    }
}
