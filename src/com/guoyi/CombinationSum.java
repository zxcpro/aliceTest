package com.guoyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates.length < 1) {
            return res;
        }

        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<Integer>(), res);
        return res;

    }

    public void backtrack(int[] nums, int index, int target, List<Integer> ans, List<List<Integer>> res) {
        //1、记录解  target==0 记录ans到res
        if (target == 0) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            //2、剪枝 target<0，就没必要继续了
            //要么这里剪枝，不记录到解，如果记录到解，然后在判解这里如果<0需要return，不然一直加下去不会return，会栈溢出
            if (target - nums[i] < 0) {
                break;
            }
            //3、尝试解
            ans.add(nums[i]);
            backtrack(nums, i, target - nums[i], ans, res);
            //4、回退
            ans.remove(ans.size() - 1);
        }

    }
}
