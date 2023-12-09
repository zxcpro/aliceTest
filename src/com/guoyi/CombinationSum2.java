package com.guoyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    /*
    40 组合总和II
    给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    candidates 中的每个数字在每个组合中只能使用 一次 。
    注意：解集不能包含重复的组合。
    示例 1:
    输入: candidates = [10,1,2,7,6,1,5], target = 8,
    输出:
    [[1,1,6],[1,2,5],[1,7],[2,6]]
     */

    /*
    思考：回溯深度遍历，但是要剪枝，类似SubsetsWithDup
    1、记录解 target == 0
    2、剪枝
    剪枝1、剪掉自身重复解，i从index遍历，通过index控制开始
    剪枝2、剪掉不符合的子集，target<0
    剪枝3、i > index && candidates[i] == candidates[i - 1]
        剪掉重复元素造成的重复子集
        i == i-1，判断当前元素是否和前一个相同，把重复用剪掉，比如第一个1，7和第二个1，7
        但是这样也会把同一个解里相同的元素剪掉，1，1，6也砍掉
        所以要砍掉的是i>当前index，它成为另一个新开始解，i=index的是当前子集的解，向下深度使用数字的保留
    3、尝试解
    4、回溯
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        backtrack(candidates, target, res, new ArrayList<Integer>(), 0);
        return res;

    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> res, List<Integer> ans, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(ans));
            return;
        }

        //2.1 剪枝1，i从index开始，是避免向前重复的选择
        for (int i = index; i < candidates.length; i++) {
            //2.2 剪枝2，如果已经不符合要求，剪枝
            if (target < 0) {
                break;
            }
            //2.3 砍掉重复元素的重复子集
            //i == i-1，是判断当前元素是否和前一个相同，把重复的子集剪掉，比如第一个1，7和第二个1，7
            //但是这样同样会把同一个解里相同的元素剪掉，1，1，6也砍掉
            //所以要砍掉的是i>当前index，它成为另一个新开始的解，i=index的是当前子集的解，向下深度使用数字的
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            //if (i > 0 && candidates[i] == candidates[i - 1]) {
            //  continue;
            //}
            //这样会剪掉1，1，6哦
            ans.add(candidates[i]);
            backtrack(candidates, target - candidates[i], res, ans, i + 1);
            ans.remove(ans.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        List<List<Integer>> lists = combinationSum2.combinationSum2(new int[]{10, 1, 2, 7, 6, 1,3, 5}, 8);
        System.out.println(lists);
    }
}
