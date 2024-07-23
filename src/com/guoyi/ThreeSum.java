package com.guoyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    /*
    15 三数之和
    给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
    你返回所有和为 0 且不重复的三元组。
    注意：答案中不可以包含重复的三元组。

    示例 1：
    输入：nums = [-1,0,1,2,-1,-4]
    输出：[[-1,-1,2],[-1,0,1]]
    解释：
    nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
    nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
    nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
    不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
    注意，输出的顺序和三元组的顺序并不重要。
    解法：
    选定第一个index，然后向后遍历，后两个双指针
    难点是结果集不要重复，所以每个数字，遇到自身数值一样要跳过，只用第一次，且控制位置first < second < third
     */

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //当前数组的长度为空，或者长度小于3时，直接退出
        if (nums == null || nums.length < 3) {
            return res;
        }
        //0、排序
        Arrays.sort(nums);
        //1、遍历锚点，不需要到最后，后3个数即可停
        for (int index = 0; index < nums.length-2; index++) {
            //2、条件剪枝，起始元素大于0，就直接退出
            if (nums[index] > 0) {
                break;
            }
            //2.2、去重，当起始的值等于前一个元素，那么跳过
            if (index > 0 && nums[index] == nums[index - 1]) continue;
            //3、初始化左右指针，循环
            int l = index + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[index] + nums[l] + nums[r];
                //4、小于0，l右移，大于0，r左移
                if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                } else {
                    //5、和为0，记录解
                    res.add(Arrays.asList(nums[index], nums[l], nums[r]));
                    //6、去重相同结果，只用挨的最近的一组
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    //7、l右移，r左移，尝试解
                    l++;
                    r--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {1, 0, 2, 0, 0, 2, 1, -3, 6, 5, 3};
        List<List<Integer>> lists = threeSum.threeSum(nums);
    }

}

