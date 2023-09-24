package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {
    public List<List<Integer>> threeSum(int[] nums) {

        //暴力解法是三层循环，时间复杂度O(n三次方)
        //优化方法是排序后退化为对n个数遍历时的双指针 TwoSum，时间复杂度O(logn) + O(n方)

        if (nums.length < 3) {
            return new ArrayList<>();
        }

        //存储符合条件的结果
        List<List<Integer>> results = new ArrayList<>();

        //sort {-4,-1,-1,0,1,2}
        Arrays.sort(nums);
        System.out.println("After sort:" + Arrays.toString(nums));

        int num2RemoveIndex = 0;
        while (num2RemoveIndex <= nums.length - 1) {
            //2.排除掉一个数i后，剩下的队列中是否存在两数和为-i的组合，twoSum
            //eg.排除-4 剩余{-1,-1,0,1,2}，其和为4
            System.out.println("Removing " + num2RemoveIndex);
            twoSum(nums, num2RemoveIndex, -nums[num2RemoveIndex], results);

            //3.找到待排除的下一个数，不能与上一个重复
            //e.g排除-1 剩下的值为{-4,-1,0,1,2}

            //默认num2RemoveIndex向后跳1个
            int nextTargetIndex = num2RemoveIndex + 1;
            //如果下一个数的值与当前排除的数相同，继续跳
            while(nextTargetIndex <= nums.length -1
                    && nums[num2RemoveIndex] == nums[nextTargetIndex]) {
                nextTargetIndex++;
            }
            num2RemoveIndex = nextTargetIndex;
        }

        return results;
    }

    public void twoSum(int[] nums, int num2RemoveIndex, int target, List<List<Integer>> results) {
        //twoSum 双指针遍历数组 leftIndex rightIndex
        //重要：左侧被排除过的数字均参与过运算，需要排除出去，否则后续计算会重复包含已排除数字的解
        int leftIndex = num2RemoveIndex + 1;
        int rightIndex = num2RemoveIndex == nums.length - 1 ? num2RemoveIndex - 1 : nums.length - 1;
        //和大于target则right变小，小于target则left变大，调整时需要至不重复值 {-4,1,1,1,3,3,3}
        while (leftIndex < rightIndex) {
            System.out.println("Current left:"+leftIndex + " right:" + rightIndex);
            int sum = nums[leftIndex] + nums[rightIndex];
            if (sum <= target) {
                if (sum == target) {
                    System.out.println("Matched!");
                    //放入待删除值、left、right
                    results.add(Arrays.asList(nums[num2RemoveIndex], nums[leftIndex], nums[rightIndex]));
                } else {
                    System.out.println("Smaller");
                }
                int nextLeft = leftIndex + 1;
                //下一个值和当前重复跳过，下一个值是当前待排除值也跳过
                while (nextLeft < nums.length - 1
                        && (nums[nextLeft] == nums[leftIndex] || nextLeft == num2RemoveIndex)) {
                    nextLeft++;
                }
                leftIndex = nextLeft;
                System.out.println("Next left:" + nextLeft);
            } else {
                System.out.println("Bigger");
                int nextRight = rightIndex - 1;
                //下一个值和当前重复跳过，下一个值是当前待排除值也跳过
                while (rightIndex > 0
                        && (nums[nextRight] == nums[rightIndex] || nextRight == num2RemoveIndex)) {
                    nextRight--;
                }
                rightIndex = nextRight;
                System.out.println("Next right:" + nextRight);
            }
        }
    }


    public static void main(String[] args) {
        int[] nums =
        //case 1 normal
        {-1,0,1,2,-1,-4};
        //[[-1,-1,2],[-1,0,1]]

        //case 2 待排除数有重复，nextIndex期望值为2，返回值为[{-1,-1,2}]
//        {-1,-1,2}
//        {-1,-1,-1,2}

        //case 3 待排除的数找到了最后一直重复，返回值为[{-4,2,2}]
//        {-4,2,2}
//        {-4,2,2,2}
        ;
        System.out.println(new ThreeSum15().threeSum(nums));
    }

}
