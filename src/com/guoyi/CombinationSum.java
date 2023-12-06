package com.guoyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum {

    //39 组合总和
    /*
    给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
    candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
    对于给定的输入，保证和为 target 的不同组合数少于 150 个。
    示例 1：
    输入：candidates = [2,3,6,7], target = 7
    输出：[[2,2,3],[7]]
    解释：
    2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
    7 也是一个候选， 7 = 7 。
    仅有这两种组合。
     */
    /*
    思考：深度遍历就是回溯，和其他不同的是，这里允许自身多次，所以index每次还是自己，以及不合适的需要及时中止，不然没有深度限制，一直加会栈溢出
    index是从这个位置开始尝试的解
    1、记录解   target == 0，如果没剪枝，target<0的要及时停止
    2、剪枝      target会<0的，就直接不要记录到解
    3、尝试      把当前尝试的数字，放到解里
    4、回退      把解的最后一位数字remove走
     */
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
            //要么这里剪枝，不记录到解，如果记录到解，在上面判解这里要加一个target<0需要return，不然一直加下去不会return，会栈溢出
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
