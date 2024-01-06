package com.guoyi;

public class CanJump {

    /*
    55. 跳跃游戏
    给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
    判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
    示例 1：
    输入：nums = [2,3,1,1,4]
    输出：true
    解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
    示例 2：
    输入：nums = [3,2,1,0,4]
    输出：false
    解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
     */

    /*
    思考：最大的可达长度，只要当前的i位置不超过最大即可，不然就达不到了，达不到就结束
    1、记录可到的最长距离
    2、当前距离是否超过最大距离，超过就弹出结束
    3、没超过的就是继续循环，更新最大距离=Math.max(当前位置+当前位置的值，原最大距离）
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int longest = 0;
        for (int i = 0; i < n; i++) {
            if (i > longest) {
                return false;
            }
            longest = Math.max(i + nums[i], longest);
        }
        return true;
    }


    /*
    45 跳跃游戏II
    给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
    每个元素 nums[`i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
    0 <= j <= nums[i]
    i + j < n
    返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。

    示例 1:
    输入: nums = [2,3,1,1,4]
    输出: 2
    解释: 跳到最后一个位置的最小跳跃数是 2。从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
    示例 2:
    输入: nums = [2,3,0,1,4]
    输出: 2`
     */

    /*
    思路：
    1、初始化最大长度，最大长度的游标位置，步数
    2、遍历，更新最大长度
    3、如果i已经到上一个最大长度的游标位置，必须step+1步了，以及更新end到当前记录的新的最大位置
    注意：只记录到length-1位置，如果已经是end，就+1步，如果不是，说明不是最大可达，就不用加，不然如果正好length位置是最大可达，会多加1步
     */
    public int jump(int[] nums) {
        int end = 0;
        int longest = 0;
        int step = 0;
        for (int i = 0; i < nums.length -1; i++) {
            longest = Math.max(nums[i] + i, longest);
            if (i == end) {
                end = longest;
                step++;
            }
        }
        return step;
    }


}
