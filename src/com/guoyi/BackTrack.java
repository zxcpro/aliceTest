package com.guoyi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xuanchen.zhao on 2023/9/24.
 */
public class BackTrack {

    //回溯算法
    //46，全排列，给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
    /* 全排列 I */
    List<List<Integer>> permutationsI(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(new ArrayList<Integer>(), nums, new boolean[nums.length], res);
        return res;
    }


    void backtrack(List<Integer> state, int[] choices, boolean[] selected, List<List<Integer>> res) {
        // 当状态长度等于元素数量时，记录解
        if (state.size() == choices.length) {
            res.add(new ArrayList<Integer>(state));
            return;
        }
        // 遍历所有选择
        for (int i = 0; i < choices.length; i++) {
            int choice = choices[i];
            // 剪枝：不允许重复选择元素 且 不允许重复选择相等元素
            if (!selected[i]) {
                // 尝试：做出选择，更新状态
                selected[i] = true;
                state.add(choice);
                // 进行下一轮选择
                backtrack(state, choices, selected, res);
                // 回退：撤销选择，恢复到之前的状态
                selected[i] = false;
                state.remove(state.size() - 1);
            }
        }
    }


    /* 回溯算法：全排列 II，可能有重复元素，去除重复元素，1，1，2只可以3个结果，112，121，211*/
    void backtrackII(List<Integer> state, int[] choices, boolean[] selected, List<List<Integer>> res) {
        // 当状态长度等于元素数量时，记录解
        if (state.size() == choices.length) {
            res.add(new ArrayList<Integer>(state));
            return;
        }
        // 遍历所有选择
        Set<Integer> duplicated = new HashSet<Integer>();
        for (int i = 0; i < choices.length; i++) {
            int choice = choices[i];
            // 剪枝：不允许重复选择元素 且 不允许重复选择相等元素
            if (!selected[i] && !duplicated.contains(choice)) {
                // 尝试：做出选择，更新状态
                duplicated.add(choice); // 记录选择过的元素值
                selected[i] = true;
                state.add(choice);
                // 进行下一轮选择
                backtrackII(state, choices, selected, res);
                // 回退：撤销选择，恢复到之前的状态
                selected[i] = false;
                state.remove(state.size() - 1);
            }
        }
    }

    /* 全排列 II */
    List<List<Integer>> permutationsII(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrackII(new ArrayList<Integer>(), nums, new boolean[nums.length], res);
        return res;
    }

    public static void main(String[] args) {
        BackTrack bt = new BackTrack();
        int[] nums = {1, 1, 2};
        List<List<Integer>> res1 = bt.permutationsI(nums);
        List<List<Integer>> res2 = bt.permutationsII(nums);
        System.out.println(res1 + "+" + res2);
    }

}
