package com.guoyi;

import java.util.*;

public class Subsets {

    /* 78 子集
    给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
    解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
    示例 1：
    输入：nums = [1,2,3]
    输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     */

    /*
    思路，又是需要穷举+深度遍历的，用回溯即可，记录解的条件没有任何，所有路径都会被记录
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        backtrack(nums, new ArrayList<Integer>(), res, 0);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> ans, List<List<Integer>> res, int index) {
        //1、记录解
        res.add(new ArrayList<>(ans));

        for (int i = index; i < nums.length; i++) {
            //2、不需要剪枝
            //3、尝试解，回溯
            ans.add(nums[i]);
            backtrack(nums, ans, res, i + 1);
            //4、回退
            ans.remove(ans.size() - 1);
        }
    }



}
