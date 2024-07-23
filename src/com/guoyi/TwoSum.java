package com.guoyi;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /*
    1、两数之和
    给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
    你可以按任意顺序返回答案。

    示例 1：
    输入：nums = [2,7,11,15], target = 9
    输出：[0,1]
    解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     */

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                //如果命中直接返回
                return new int[]{map.get(target - nums[i]), i};
            }
            //先判断完再存，就保证了不会把当前值用两次
            map.put(nums[i], i);
        }
        return new int[0];
    }

    //这是错误的，如果有相同数值，会重复取用
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        //这样会重复使用，上面的方法，记录着取用着，就不会重复
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i],i);
        }

        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
        }
        return new int[0];
    }


    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] ints = twoSum.twoSum(new int[]{3,2,4}, 6);
        System.out.println(ints[0]+","+ints[1]);
    }

}
