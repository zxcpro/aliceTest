package com.guoyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {

    /*
    90 子集II  是 78 子集 的变种
    题目：给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
    解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
    示例 1：
    输入：nums = [1,2,2]
    输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
    示例 2：
    输入：nums = [0]
    输出：[[],[0]]
    思考：深度遍历，回溯，但要剪枝，类似 CombinationSum2
     */

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        backtrackII(nums, new ArrayList<Integer>(), res, 0);
        return res;
    }

    private void backtrackII(int[] nums, List<Integer> ans, List<List<Integer>> res, int index) {
        //1、记录解，所有的可能路径
        res.add(new ArrayList<>(ans));
        for (int i = index; i < nums.length; i++) {
            //2、剪枝重复的数据,和40 组合总和II类似
            //这里只是这个index跳过，但是还要继续下面的，而不是整个path不要了，所以不是break，是continue
            if (i > index && (nums[i] == nums[i - 1])) {
                continue;
            }
            //3、尝试解，回溯
            ans.add(nums[i]);
            backtrackII(nums, ans, res, i + 1);
            //4、回退
            ans.remove(ans.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,1,2,2};
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
        List<List<Integer>> lists = subsetsWithDup.subsetsWithDup(nums);
        System.out.println(lists);
    }
}
