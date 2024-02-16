package com.guoyi;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    /*
    给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
    请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
    示例 1：
    输入：nums = [100,4,200,1,3,2]
    输出：4
    解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
    示例 2：
    输入：nums = [0,3,7,2,5,8,4,6,0,1]
    输出：9
     */
    /*
    思考：
    遍历数组内的数字，找到最长的结果
    1、初始化res记录结果，初始化seqLen记录每个循环的结果
    2、初始化记录下每个不重复数字
    3、遍历，如果这个数字是开头，就开始记录和更新长度
     */


    public int longestConsecutive(int[] nums) {
        //1、初始化res记录结果，初始化seqLen记录每个循环的结果
        int res = 0;
        int seqLen = 0;
        //2、初始化记录下每个不重复数字
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        //3、遍历，如果这个数字是开头，就开始记录和更新长度
        for (int num : nums) {
            if(!numSet.contains(num-1)){
                seqLen = 0;
                while (numSet.contains(num++)){
                    seqLen++;
                }
                res = Math.max(res,seqLen);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        LongestConsecutive longestConsecutive = new LongestConsecutive();
        int[] nums= {200,1,2,3,4,100};
        int i = longestConsecutive.longestConsecutive(nums);
        System.out.println(i);
    }

}
